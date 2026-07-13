package org.crux.system.key

internal class KeyManager {
    val keyFactory = KeyFactory("crux")
}

fun createCruxKey(path: String): Key {
    return KeyManager().keyFactory.createKey(path)
}