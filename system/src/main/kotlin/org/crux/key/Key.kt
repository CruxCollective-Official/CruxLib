package org.crux.key

data class Key(
    val namespace: String,
    val path: String
) : Comparable<Key> {
    val id = "$namespace:$path"

    companion object {
        private val KEY_TEST = "^[a-zA-Z0-9-_]+$".toRegex()
    }

    init {
        require(namespace.matches(KEY_TEST))
        require(path.matches(KEY_TEST))
    }

    override fun compareTo(other: Key): Int {
        return compareBy<Key>(
            { it.namespace }, { it.path }
        ).compare(this, other)
    }
}