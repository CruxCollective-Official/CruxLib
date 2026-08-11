package org.crux

import org.crux.register.RegistryBuilder

import org.crux.generated.GeneratedRegistries
import org.crux.key.KeyFactory
import org.crux.register.RegistryContainer

class Crux {
    companion object {
        init {
            CruxStatus.initialize()
        }

        val REGISTRY_CONTAINER: RegistryContainer = CruxStatus.registryBuilder.build()
        val CRUX_KEY_MANAGER = KeyFactory("crux")
    }
}

internal object CruxStatus {

    val registryBuilder = RegistryBuilder()

    private var initialized = false

    fun initialize() {
        if (initialized) return

        initialized = true

        GeneratedRegistries.register()
    }
}