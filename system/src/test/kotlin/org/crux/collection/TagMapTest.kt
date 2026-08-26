package org.crux.collection

import org.crux.dummy.DummyInstance
import kotlin.test.Test
import kotlin.test.assertEquals

class TagMapTest {
    private val instance1 = DummyInstance()
    private val instance2 = DummyInstance()
    private val instance3 = DummyInstance()
    private val instance4 = DummyInstance()

    @Test
    fun `can put and get`() {
        val map = TagMap<String, DummyInstance, String>()

        map["key"] = instance1
        assertEquals(instance1, map["key"])
    }

    @Test
    fun `can turn elements into a list`() {
        val map = TagMap<String, DummyInstance, String>()
        map["key"] = instance1

        assertEquals(instance1, map.toList()[0])
    }

    @Test
    fun `can narrow filter multiple times`() {
        val map = TagMap<String, DummyInstance, String>()

        map["key1"] = instance1
        map["key2"] = instance2
        map["key3"] = instance3
        map["key4"] = instance4

        map.putTag("tagA")
        map.putTag("tagB")

        map.setTag("tagA", "key1")
        map.setTag("tagA", "key2")
        map.setTag("tagA", "key3")

        map.setTag("tagB", "key1")
        map.setTag("tagB", "key3")
        map.setTag("tagB", "key4")

        map.addFilter("tagA")

        assertEquals(
            listOf(instance1, instance2, instance3),
            map.getFilter()
        )

        map.addFilter("tagB")

        assertEquals(
            listOf(instance1, instance3),
            map.getFilter()
        )
    }

    @Test
    fun `filter does not include elements outside the tag`() {
        val map = TagMap<String, DummyInstance, String>()

        map["key1"] = instance1
        map["key2"] = instance2
        map["key3"] = instance3

        map.putTag("tagA")

        map.setTag("tagA", "key1")
        map.setTag("tagA", "key3")

        map.addFilter("tagA")

        assertEquals(
            listOf(instance1, instance3),
            map.getFilter()
        )
    }
}