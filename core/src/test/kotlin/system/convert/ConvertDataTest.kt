package system.convert

import org.crux.system.convert.BooleanConvertType
import org.crux.system.convert.DoubleConvertType
import org.crux.system.convert.IntegerConvertType
import org.crux.system.convert.StringConvertType
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ConvertDataTest {
    @Test
    fun `can string convert data`() {

        val integerConvertData = IntegerConvertType().stringConvertLogic(10)
        val doubleConvertData = DoubleConvertType().stringConvertLogic(10.0)
        val stringConvertData = StringConvertType().stringConvertLogic("test")
        val booleanConvertData = BooleanConvertType().stringConvertLogic(true)

        assertEquals("crux:integer>10", integerConvertData)
        assertEquals("crux:double>10.0", doubleConvertData)
        assertEquals("crux:string>test", stringConvertData)
        assertEquals("crux:boolean>1", booleanConvertData)
    }
}