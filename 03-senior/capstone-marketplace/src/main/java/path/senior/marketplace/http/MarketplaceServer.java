
package path.senior.marketplace.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import path.senior.marketplace.domain.Listing;
import path.senior.marketplace.domain.Marketplace;
import path.senior.marketplace.domain.Order;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public final class MarketplaceServer {
    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(System.getenv().getOrDefault("APP_PORT", "8081"));
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        Marketplace marketplace = new Marketplace();
        server.createContext("/health", ex -> write(ex, 200, "{\"status\":\"ok\"}"));
        server.createContext("/listings", ex -> handleListings(marketplace, ex));
        server.createContext("/orders", ex -> handleOrders(marketplace, ex));
        server.start();
        System.out.println("marketplace on :" + port);
    }

    static void handleListings(Marketplace marketplace, HttpExchange ex) throws IOException {
        try {
            if ("GET".equals(ex.getRequestMethod())) {
                String body = marketplace.listings().stream().map(MarketplaceServer::listingJson)
                        .collect(Collectors.joining(",", "[", "]"));
                write(ex, 200, body);
                return;
            }
            if ("POST".equals(ex.getRequestMethod())) {
                String raw = new String(ex.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
                Listing listing = marketplace.listItem(
                        field(raw, "sellerId"),
                        field(raw, "title"),
                        Long.parseLong(field(raw, "priceCents")),
                        Integer.parseInt(field(raw, "stock"))
                );
                write(ex, 200, listingJson(listing));
                return;
            }
            write(ex, 405, "{\"error\":\"method\"}");
        } catch (RuntimeException err) {
            write(ex, 400, "{\"error\":\"" + err.getMessage() + "\"}");
        }
    }

    static void handleOrders(Marketplace marketplace, HttpExchange ex) throws IOException {
        try {
            if (!"POST".equals(ex.getRequestMethod())) {
                write(ex, 405, "{\"error\":\"method\"}");
                return;
            }
            String raw = new String(ex.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
            Order order = marketplace.placeOrder(
                    field(raw, "buyerId"),
                    field(raw, "listingId"),
                    Integer.parseInt(field(raw, "qty"))
            );
            write(ex, 200, orderJson(order));
        } catch (RuntimeException err) {
            write(ex, 400, "{\"error\":\"" + err.getMessage() + "\"}");
        }
    }

    static String listingJson(Listing listing) {
        return "{\"id\":\"" + listing.getId() + "\",\"sellerId\":\"" + listing.getSellerId()
                + "\",\"title\":\"" + listing.getTitle() + "\",\"priceCents\":" + listing.getPriceCents()
                + ",\"stock\":" + listing.getStock() + "}";
    }

    static String orderJson(Order order) {
        return "{\"id\":\"" + order.getId() + "\",\"listingId\":\"" + order.getListingId()
                + "\",\"buyerId\":\"" + order.getBuyerId() + "\",\"qty\":" + order.getQty()
                + ",\"totalCents\":" + order.getTotalCents() + "}";
    }

    static String field(String json, String name) {
        String key = "\"" + name + "\"";
        int at = json.indexOf(key);
        if (at < 0) {
            throw new IllegalArgumentException("missing " + name);
        }
        int i = json.indexOf(':', at + key.length()) + 1;
        while (i < json.length() && Character.isWhitespace(json.charAt(i))) {
            i++;
        }
        if (i < json.length() && json.charAt(i) == '"') {
            int end = json.indexOf('"', i + 1);
            return json.substring(i + 1, end);
        }
        int end = i;
        while (end < json.length() && json.charAt(end) != ',' && json.charAt(end) != '}') {
            end++;
        }
        return json.substring(i, end).trim();
    }

    static void write(HttpExchange ex, int status, String body) throws IOException {
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        ex.getResponseHeaders().add("Content-Type", "application/json");
        ex.sendResponseHeaders(status, bytes.length);
        try (OutputStream os = ex.getResponseBody()) {
            os.write(bytes);
        }
    }
}
