package org.crux.register

class Registry<KEY, VALUE> internal constructor (
    private val registryMap: MutableMap<KEY, VALUE> = mutableMapOf()
): ImmutableRegistry<KEY, VALUE> {

    fun add(key: KEY, value: VALUE) {
        if (registryMap.containsKey(key)) {
            throw IllegalStateException("Duplicate key: $key")
        }
        registryMap[key] = value
    }

    override fun get(key: KEY): VALUE {
        return registryMap[key] ?: throw NoSuchElementException("No value for key $key")
    }
}

interface ImmutableRegistry<KEY, VALUE> {
    fun get(key: KEY): VALUE
}