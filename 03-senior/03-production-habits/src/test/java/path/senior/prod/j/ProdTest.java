
package path.senior.prod.j;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ProdTest {

    @Test
    void configDefaultsAndOverride() {
        assertThat(AppConfig.load(Map.of())).isEqualTo(new AppConfig(8081, "dev"));
        assertThat(AppConfig.load(Map.of("APP_PORT", "9000", "APP_ENV", "prod")))
                .isEqualTo(new AppConfig(9000, "prod"));
    }

    @Test
    void masksSecrets() {
        Map<String, String> masked = SecretMasker.mask(Map.of(
                "APP_TOKEN", "abc",
                "password", "x",
                "NAME", "ada"
        ));
        assertThat(masked).containsEntry("APP_TOKEN", "***")
                .containsEntry("password", "***")
                .containsEntry("NAME", "ada");
    }

    @Test
    void healthJson() {
        assertThat(Health.body(new AppConfig(1, "prod"))).isEqualTo("{\"status\":\"ok\",\"env\":\"prod\"}");
    }
}
