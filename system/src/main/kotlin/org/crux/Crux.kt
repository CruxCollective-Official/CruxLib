package org.crux

import org.crux.register.RegistryBuilder

import org.crux.generated.GeneratedRegistries
import org.crux.key.KeyFactory
import org.crux.register.RegistryContainer

object Crux {

    val REGISTRY_CONTAINER: RegistryContainer

    internal val CRUX_KEY_MANAGER = KeyFactory("crux")

    init {
        val builder = RegistryBuilder()

        GeneratedRegistries.register(builder)

        REGISTRY_CONTAINER = builder.build()
    }
}