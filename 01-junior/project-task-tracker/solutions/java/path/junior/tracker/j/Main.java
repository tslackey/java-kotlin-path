
package path.junior.tracker.j;

import java.nio.file.Path;

public final class Main {
    public static void main(String[] args) throws Exception {
        Path file = Path.of("tasks-java.txt");
        TaskStore store = new TaskStore();
        store.load(file);
        int code = run(store, args);
        store.save(file);
        if (code != 0) {
            System.exit(code);
        }
    }

    static int run(TaskStore store, String[] args) {
        if (args.length == 0) {
            System.err.println("usage: add <title> | list | done <id>");
            return 2;
        }
        switch (args[0]) {
            case "add" -> {
                if (args.length < 2) {
                    System.err.println("usage: add <title>");
                    return 2;
                }
                String title = String.join(" ", java.util.Arrays.copyOfRange(args, 1, args.length));
                Task task = store.add(title);
                System.out.println(format(task));
            }
            case "list" -> {
                for (Task task : store.list()) {
                    System.out.println(format(task));
                }
            }
            case "done" -> {
                if (args.length != 2) {
                    System.err.println("usage: done <id>");
                    return 2;
                }
                boolean ok = store.complete(Integer.parseInt(args[1]));
                if (!ok) {
                    System.err.println("unknown id");
                    return 1;
                }
            }
            default -> {
                System.err.println("unknown command");
                return 2;
            }
        }
        return 0;
    }

    static String format(Task task) {
        return task.id() + " [" + (task.done() ? "x" : " ") + "] " + task.title();
    }
}
