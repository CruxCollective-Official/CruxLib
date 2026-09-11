package org.crux.modifiy

import org.crux.modify.CalculateModifier
import kotlin.test.Test
import kotlin.test.assertEquals

class CalculateModifierTest {
    private val ADDITION = object : CalculateModifier<Int>() {
        override fun calc(target: Int, value: Int): Int {
            return target + value
        }
    }

    @Test
    fun `value can achieve the desired behavior on the target`() {
        assertEquals(
            15,
            ADDITION.calc(10, 5)
        )
    }
}