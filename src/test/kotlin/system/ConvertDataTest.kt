package system

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ConvertDataTest {
    @Test
    fun `can string convert data`() {
        val convertType: ConvertType = DummyData()

        val integerConvertData = ConvertData().convert(ConvertDataType.INTEGER, 10)
        val doubleConvertData = ConvertData().convert(ConvertDataType.DOUBLE, 10.0)
        val stringConvertData = ConvertData().convert(ConvertDataType.STRING, "test")
        val booleanConvertData = ConvertData().convert(ConvertDataType.BOOLEAN, true)
        val versatileConvertData = ConvertData().convert(ConvertDataType.VERSATILE, convertType)

        assertEquals("int>10", integerConvertData)
        assertEquals("duble>10.0", doubleConvertData)
        assertEquals("string>test", stringConvertData)
        assertEquals("boolean>1", booleanConvertData)
        assertEquals("dummy>10:20:30", versatileConvertData)
    }
}