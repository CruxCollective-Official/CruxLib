package org.crux.key

import org.crux.key.Key
import org.crux.key.KeyFactory
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class KeyTest {
    @Test
    fun `it stores the namespace and path, allowing it to be treated as an ID as well`() {
        val key = Key("namespace", "test")

        assertEquals("namespace:test", key.id)
    }

    @Test
    fun `can generate keys with a fixed namespace`() {
        val keyFactory = KeyFactory("namespace")

        val key = keyFactory.create("test")
        assertEquals("namespace:test", key.id)
    }
}