package system.convert

import dummy.status.DummyCalculateType
import dummy.status.DummyStatus
import dummy.status.DummyStatusStepType
import org.crux.game.status.Status
import org.crux.game.status.StatusContainer
import org.crux.game.status.StatusModifierKey
import org.crux.system.convert.KeyConvertType
import org.crux.system.convert.StatusContainerConvertType
import org.crux.system.key.Key
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CruxElementConvertDataTest {
    private val status: Status = DummyStatus()

    private val testKey1 = StatusModifierKey(status, DummyStatusStepType.TEST.type, DummyCalculateType.ADDITION.type)
    private val testKey2 = StatusModifierKey(status, DummyStatusStepType.TEST.type, DummyCalculateType.MULTIPLICATION.type)

    @Test
    fun `status container data string convert test`() {
        val container = StatusContainer()

        container.add(testKey1, 10.0)
        container.add(testKey2, 20.0)
        assertEquals("crux_status_container>[crux_dummy_status,crux_test,crux_addition:10.0][crux_dummy_status,crux_test,crux_multiplication:20.0]", StatusContainerConvertType().stringConvertLogic(container))
    }

    @Test
    fun `status container string data convert test`() {
        val container = StatusContainer()
        container.add(testKey1, 10.0)

        val statusContainerConvertData = StatusContainerConvertType().stringConvertLogic(container)

        assertEquals(container, StatusContainerConvertType().dataTypeConvertLogic(statusContainerConvertData))
    }

    @Test
    fun `key data string convert test`() {
        val key = Key("test", "test")
        assertEquals("crux_key>test_test", KeyConvertType().stringConvertLogic(key))
    }
}