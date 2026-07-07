package mmo.status

import dummy.status.DummyCalculateType
import dummy.status.DummyStatus
import dummy.status.DummyStatusStepType
import kotlin.test.Test
import kotlin.test.assertEquals

class StatusContainerTest {
    private val status: Status = DummyStatus()
    private val statusStepType: StatusStepType = DummyStatusStepType.TEST.type
    private val calculateType: CalculateType = DummyCalculateType.ADD.type

    private val testKey = StatusModifierKey(status, statusStepType, calculateType)

    @Test
    fun `put and get status modifier value`() {
        val container = StatusContainer()

        container.put(testKey, 10.0)
        assertEquals(10.0, container.get(testKey))
    }
}