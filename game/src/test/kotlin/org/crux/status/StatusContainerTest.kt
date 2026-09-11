package org.crux.status

import dummy.status.DummyCalculateType
import dummy.status.DummyStatus
import dummy.status.DummyStatusStep
import org.crux.annotations.InternalCruxApi
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

@InternalCruxApi
class StatusContainerTest {
    private val status = DummyStatus()
    private val stepType = DummyStatusStep.TEST.statusStep
    private val calculateModifier = DummyCalculateType.ADDITIONAL.calculateModifier

    private val statusModifierKey = StatusModifierKey(status, stepType, calculateModifier)

    @Test
    fun `can use add and get on the status container`() {
        val container = MutableStatusContainer(0)

        container[statusModifierKey] = 10

        assertEquals(10, container[statusModifierKey])
    }

    @Test
    fun `if the value of the key is null it can be treated as default value`() {
        val defaultValue = 0
        val container = MutableStatusContainer(defaultValue)

        assertEquals(defaultValue, container[statusModifierKey])
    }

    @Test
    fun `filtering is possible`() {
        val container = MutableStatusContainer(0)
        container[statusModifierKey] = 10
        assertEquals(10, container.filterStatus(status)[statusModifierKey])
    }
}