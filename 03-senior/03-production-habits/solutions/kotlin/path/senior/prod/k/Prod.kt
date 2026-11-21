
package path.senior.prod.k

data class AppConfig(val port: Int, val env: String) {
    companion object {
        fun load(env: Map<String, String>): AppConfig {
            val port = env.getOrDefault("APP_PORT", "8081").toInt()
            val environment = env["APP_ENV"]?.takeIf { it.isNotBlank() } ?: "dev"
            return AppConfig(port, environment)
        }
    }
}

object SecretMasker {
    fun mask(input: Map<String, String>): Map<String, String> =
        input.mapValues { (key, value) ->
            val k = key.lowercase()
            if ("token" in k || "password" in k || "secret" in k) "***" else value
        }
}

object Health {
    fun body(config: AppConfig): String = """{"status":"ok","env":"${config.env}"}"""
}
