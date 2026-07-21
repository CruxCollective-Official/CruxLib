package org.crux.core

import org.crux.system.key.Key
import org.crux.system.key.KeyFactory

internal class KeyManager {
    val keyFactory = KeyFactory("crux")
}

internal fun createCruxKey(path: String): Key {
    return KeyManager().keyFactory.createKey(path)
}