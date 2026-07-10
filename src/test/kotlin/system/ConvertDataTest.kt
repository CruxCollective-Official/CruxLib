package system

import org.junit.jupiter.api.Test
import system.convert.BooleanConvertType
import system.convert.DoubleConvertType
import system.convert.IntegerConvertType
import system.convert.StringConvertType
import kotlin.test.assertEquals

class ConvertDataTest {
    @Test
    fun `can string convert data`() {

        val integerConvertData = IntegerConvertType().stringConvertLogic(10)
        val doubleConvertData = DoubleConvertType().stringConvertLogic(10.0)
        val stringConvertData = StringConvertType().stringConvertLogic("test")
        val booleanConvertData = BooleanConvertType().stringConvertLogic(true)

        assertEquals("int>10", integerConvertData)
        assertEquals("double>10.0", doubleConvertData)
        assertEquals("string>test", stringConvertData)
        assertEquals("boolean>1", booleanConvertData)
    }
}