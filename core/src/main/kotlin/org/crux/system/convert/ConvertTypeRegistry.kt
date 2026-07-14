package org.crux.system.convert

import org.crux.CruxRegistryTypeKeys
import org.crux.annotations.Registry
import org.crux.system.registry.BuilderElementRegistry
import org.crux.system.registry.RegistryBuilder
import org.crux.system.registry.RegistryProcessor

@Registry
class ConvertTypeRegistry : RegistryProcessor {
    override fun register(builder: RegistryBuilder) {
        val registry = BuilderElementRegistry<String, ConvertType<*>>()

        for (convertType in ConvertTypes.entries) {
            registry.register(convertType.getKeyStringTag(), convertType)
        }

        builder.add(CruxRegistryTypeKeys.CONVERT_TYPE_KEY, registry)
    }
}