package org.crux

import org.crux.annotations.Registry
import org.crux.register.RegistryBuilder
import org.crux.register.RegistryProcessor

@Registry
class CruxRegistry : RegistryProcessor {
    override fun register(builder: RegistryBuilder) {
    }
}

object CruxRegistryKeys {}