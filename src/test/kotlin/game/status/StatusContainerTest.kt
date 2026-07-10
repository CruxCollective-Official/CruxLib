package game.status

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

    @Test
    fun `filter and retrieve from the status container`() {
        val container = StatusContainer()
        container.add(testKey, 10.0)

        val statusContainer = container.filterStatus(status)
        val stepTypeContainer = container.filterStatusStepType(statusStepType)
        val calculateTypeContainer = container.filterCalculateType(calculateType)

        assertEquals(10.0, statusContainer.get(testKey))
        assertEquals(10.0, stepTypeContainer.get(testKey))
        assertEquals(10.0, calculateTypeContainer.get(testKey))
    }

    @Test
    fun `can copy the status container`() {
        val container = StatusContainer()
        container.add(testKey, 10.0)

        val copyContainer = container.copy()
        assertEquals(10.0, copyContainer.get(testKey))
    }

    @Test
    fun `can merge status containers`() {
        val container1 = StatusContainer()
        container1.add(testKey, 10.0)

        val container2 = StatusContainer()
        container2.add(StatusModifierKey(status, statusStepType, calculateType), 10.0)

        container1.merge(container2)

        assertEquals(20.0, container1.get(testKey))
    }
}