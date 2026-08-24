package org.crux.register

import org.crux.holder.IdHolder
import org.crux.key.Key

class RegistryKey<KEY_TYPE, VALUE : IdHolder<KEY_TYPE>>(
    val name: Key
)