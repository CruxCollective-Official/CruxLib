package org.crux.core

import org.crux.generated.GeneratedRegistries
import org.crux.system.registry.ImmutableRegistry
import org.crux.system.registry.RegistryBuilder
import org.crux.system.registry.RegistryTypeKey

class Crux {
    companion object {
        fun <K, V> registry(typeKey: RegistryTypeKey<K, V>): ImmutableRegistry<K, V> {
            CruxState.initialize()
            return CruxState.registryBuilder.getBuildRegistry(typeKey)
        }
    }
}

internal object CruxState {

    val registryBuilder = RegistryBuilder()

    private var initialized = false

    fun initialize() {
        if (initialized) return

        initialized = true

        GeneratedRegistries.register()
    }
}