package org.crux.system.key

@ConsistentCopyVisibility
data class Key internal constructor(
    val namespace: String,
    val path: String
) {
    val identifier: String = "${namespace}:${path}"

    companion object {
        private val KEY_TEST = "^[a-zA-Z0-9-_]+$".toRegex()
    }

    init {
        require(namespace.matches(KEY_TEST))
        require(path.matches(KEY_TEST))
    }
}

class KeyFactory(
    val namespace: String
) {
    fun createKey(path: String): Key {
        return Key(namespace, path)
    }
}