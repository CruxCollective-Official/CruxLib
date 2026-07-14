package org.crux.system.convert

object ConvertTypes {
    val entries: List<ConvertType<*>> = listOf(
        IntegerConvertType(),
        DoubleConvertType(),
        StringConvertType(),
        BooleanConvertType(),
        StatusContainerConvertType()
    )
}