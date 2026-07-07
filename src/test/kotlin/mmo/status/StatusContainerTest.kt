package mmo.status

import kotlin.test.Test
import kotlin.test.assertEquals

class StatusContainerTest {
    private val status: Status = DummyStatus()
    private val statusStepType: StatusStepType = DummyStatusStepType.TEST
    private val calculateType: CalculateType = DummyCalculateType.ADD

    private val testKey = StatusModifierKey(status, statusStepType, calculateType)

    @Test
    fun `put and get status modifier value`() {
        val container = StatusContainer()

        container.put(testKey, 10.0)
        assertEquals(10.0, container.get(testKey))
    }
}