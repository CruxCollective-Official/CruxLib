package mmo.registry

interface ImmutableRegistry<K, V> {
    fun get(key: K): V
}