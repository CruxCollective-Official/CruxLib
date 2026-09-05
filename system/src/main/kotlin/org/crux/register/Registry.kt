package org.crux.register

class Registry<KEY, VALUE> internal constructor (
    private val registryMap: MutableMap<KEY, VALUE> = mutableMapOf()
): ImmutableRegistry<KEY, VALUE> {

    /**
     * @throws IllegalStateException if the key is already in the registry
     */
    fun add(key: KEY, value: VALUE) {
        if (registryMap.containsKey(key)) {
            throw IllegalStateException("Duplicate key: $key")
        }
        registryMap[key] = value
    }

    /**
     * @throws NoSuchElementException if the key is not in the registry
     */
    override fun get(key: KEY): VALUE {
        return registryMap[key] ?: throw NoSuchElementException("No value for key $key")
    }
}

interface ImmutableRegistry<KEY, VALUE> {
    /**
     * @throws NoSuchElementException if the key is not in the registry
     */
    fun get(key: KEY): VALUE
}