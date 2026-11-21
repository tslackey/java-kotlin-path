
package path.senior.prod.k

data class AppConfig(val port: Int, val env: String) {
    companion object {
        fun load(env: Map<String, String>): AppConfig {
            TODO("Implement me")
        }
    }
}

object SecretMasker {
    fun mask(input: Map<String, String>): Map<String, String> {
        TODO("Implement me")
    }
}

object Health {
    fun body(config: AppConfig): String {
        TODO("Implement me")
    }
}
