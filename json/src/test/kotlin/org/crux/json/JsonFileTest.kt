package org.crux.json

import dummy.DummyJsonFile
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JsonFileTest {
    @Test
    fun `can normalize files`() {
        val file1 = JsonFile(DummyJsonFile.dummy1)
        val file2 = JsonFile(DummyJsonFile.dummy2)

        val expected = file1.data
        val actual = file2.data

        println("Expected: $expected")
        println("Actual: $actual")
        assertEquals(expected, actual)
    }
}