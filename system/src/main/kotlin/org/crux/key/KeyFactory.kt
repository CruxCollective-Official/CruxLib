package org.crux.key

class KeyFactory(
    val namespace: String
) {
    fun create(path: String): Key {
        return Key(namespace, path)
    }
}