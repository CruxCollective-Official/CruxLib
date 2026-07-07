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
    fun `add and get status modifier value`() {
        val container = StatusContainer()

        container.add(testKey, 10.0)
        container.add(testKey, 10.0)
        assertEquals(20.0, container.get(testKey))
    }
}