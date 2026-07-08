package mmo.registry

class RegistryContainer {
    private val containerMap = mutableMapOf<RegistryTypeKey<*, *>, Registry<*, *>>()

    operator fun <K, V> set(key: RegistryTypeKey<K, V>, registry: Registry<K, V>) {
        containerMap[key] = registry
    }

    @Suppress("UNCHECKED_CAST")
    operator fun <K, V> get(key: RegistryTypeKey<K, V>): Registry<K, V> {
        return containerMap[key]!! as Registry<K, V>
    }
}

class RegistryTypeKey<K, V>
