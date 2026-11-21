
package path.senior.prod.k

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProdTest {

    @Test
    fun configDefaultsAndOverride() {
        assertThat(AppConfig.load(emptyMap())).isEqualTo(AppConfig(8081, "dev"))
        assertThat(AppConfig.load(mapOf("APP_PORT" to "9000", "APP_ENV" to "prod")))
            .isEqualTo(AppConfig(9000, "prod"))
    }

    @Test
    fun masksSecrets() {
        val masked = SecretMasker.mask(
            mapOf("APP_TOKEN" to "abc", "password" to "x", "NAME" to "ada"),
        )
        assertThat(masked).containsEntry("APP_TOKEN", "***")
            .containsEntry("password", "***")
            .containsEntry("NAME", "ada")
    }

    @Test
    fun healthJson() {
        assertThat(Health.body(AppConfig(1, "prod"))).isEqualTo("""{"status":"ok","env":"prod"}""")
    }
}
