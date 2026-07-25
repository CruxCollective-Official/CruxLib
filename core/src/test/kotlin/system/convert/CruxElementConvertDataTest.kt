package system.convert

import dummy.status.DummyCalculateType
import dummy.status.DummyStatus
import dummy.status.DummyStatusStepType
import org.crux.annotations.Registry
import org.crux.core.CruxRegistryTypeKeys
import org.crux.game.status.Status
import org.crux.game.status.StatusContainer
import org.crux.game.status.StatusModifierKey
import org.crux.system.convert.ConvertTypes
import org.crux.system.convert.KeyConvertType
import org.crux.system.key.Key
import org.crux.system.registry.RegistryBuilder
import org.crux.system.registry.RegistryProcessor
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
        assertEquals("crux:status_container>[crux:key>crux:dummy_status,crux:key>crux:test,crux:key>crux:addition,crux:double>10.0][crux:key>crux:dummy_status,crux:key>crux:test,crux:key>crux:multiplication,crux:double>20.0]", ConvertTypes.STATUS_CONTAINER.type.stringConvertLogic(container))
    }

    @Test
    fun `status container string data convert test`() {
        val container = StatusContainer()
        container.add(testKey1, 10.0)

        val convertType = ConvertTypes.STATUS_CONTAINER.type
        val statusContainerConvertData = convertType.stringConvertLogic(container)

        assertEquals(container, convertType.dataTypeConvertLogic(statusContainerConvertData))
    }

    @Test
    fun `key data string convert test`() {
        val key = Key("test", "test")
        assertEquals("crux:key>test:test", KeyConvertType().stringConvertLogic(key))
    }
}

@Registry
class DummyRegistryProcessor : RegistryProcessor {
    override fun register(builder: RegistryBuilder) {
        println("Registry processor: ")
        builder.getBuildRegistry(CruxRegistryTypeKeys.STATUS_KEY)
            .put(DummyStatus().getPath(), DummyStatus())
    }
}