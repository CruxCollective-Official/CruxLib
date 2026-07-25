package org.crux.system.convert

import org.crux.annotations.Registry
import org.crux.core.CruxRegistryTypeKeys
import org.crux.system.registry.BuilderElementRegistry
import org.crux.system.registry.RegistryBuilder
import org.crux.system.registry.RegistryProcessor

@Registry
class ConvertTypeRegistry : RegistryProcessor {
    override fun register(builder: RegistryBuilder) {
        val registry = BuilderElementRegistry<String, ConvertType<*>>()

        for (convertType in ConvertTypes.entries) {
            val type = convertType.type
            registry.register(type.getKeyTag().identifier, type)
        }

        builder.add(CruxRegistryTypeKeys.CONVERT_TYPE_KEY, registry)
    }
}

class ConvertTypes<T : ConvertType<*>>(internal val type: T) {
    companion object {
        val INTEGER = ConvertTypes(IntegerConvertType())
        val DOUBLE = ConvertTypes(DoubleConvertType())
        val STRING = ConvertTypes(StringConvertType())
        val BOOLEAN = ConvertTypes(BooleanConvertType())
        val KEY = ConvertTypes(KeyConvertType())
        val STATUS_CONTAINER = ConvertTypes(StatusContainerConvertType(KEY.type, DOUBLE.type))

        val entries = listOf(INTEGER, DOUBLE, STRING, BOOLEAN, KEY, STATUS_CONTAINER)
    }
}
