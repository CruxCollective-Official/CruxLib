package org.crux.register

import org.crux.ID
import org.crux.key.Key

class RegistryKey<KEY_TYPE, VALUE : ID<KEY_TYPE>>(
    val name: Key
)