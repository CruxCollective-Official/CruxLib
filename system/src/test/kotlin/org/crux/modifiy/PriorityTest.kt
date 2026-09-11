package org.crux.modifiy

import org.crux.modify.PriorityList
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PriorityTest {

	private val priorityList = PriorityList(
		listOf(
			"apple",
			"banana",
			"cherry",
			"date",
			"elderberry"
		)
	)

	@Test
	fun `can extract high-priority items containing specified elements from the priority list`() {
		assertEquals(
			PriorityList(listOf("apple", "banana")),
			priorityList.toRange("banana")
		)

		assertEquals(
			PriorityList(listOf("apple", "banana")),
			priorityList.toRange(1)
		)
	}
}