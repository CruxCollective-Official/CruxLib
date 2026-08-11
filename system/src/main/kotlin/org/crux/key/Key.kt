package org.crux.key

data class Key(
    val namespace: String,
    val path: String
) {
    val id = "$namespace:$path"

    companion object {
        private val KEY_TEST = "^[a-zA-Z0-9-_]+$".toRegex()
    }

    init {
        require(namespace.matches(KEY_TEST))
        require(path.matches(KEY_TEST))
    }
}