package org.crux.register

import org.crux.ID

class RegistryKey<KEY_TYPE, VALUE : ID<KEY_TYPE>>(
    val name: String
)