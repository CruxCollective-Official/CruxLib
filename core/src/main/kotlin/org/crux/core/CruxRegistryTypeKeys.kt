package org.crux.core

import org.crux.game.status.Status
import org.crux.system.convert.ConvertType
import org.crux.system.registry.RegistryTypeKey

object CruxRegistryTypeKeys {
    val CONVERT_TYPE_KEY = RegistryTypeKey<String, ConvertType<*>>()
    val STATUS_KEY = RegistryTypeKey<String, Status>()
}