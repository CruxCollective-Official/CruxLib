package system.key

@ConsistentCopyVisibility
data class Key internal constructor(
    val namespace: String,
    val path: String
) {
    val identifier: String get() = "${namespace}_${path}"
}

class KeyFactory(
    val namespace: String
) {
    fun createKey(path: String): Key {
        return Key(namespace, path)
    }
}