package org.crux.key

data class Key(
    val namespace: String,
    val path: String
) : Comparable<Key> {
    val id = "$namespace$SPLIT_CHAR$path"

    companion object {
        private const val SPLIT_CHAR = ":"
        private val KEY_TEST = "^[a-zA-Z0-9-_]+$".toRegex()

        fun parse(keyString: String): Key? {
            return keyString.split(SPLIT_CHAR).takeIf { it.size == 2 }?.let {
                Key(it[0], it[1])
            }
        }
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