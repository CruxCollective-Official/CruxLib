package org.crux.collection

class Context(
    private val contextMap: MutableMap<ContextKey<*>, Any> = mutableMapOf()
) : ImmutableContext {
    @Suppress("UNCHECKED_CAST")
    override operator fun <TYPE> get(key: ContextKey<TYPE>): TYPE? {
        return contextMap[key] as TYPE
    }

    operator fun <TYPE> set(key: ContextKey<TYPE>, value: TYPE) {
        contextMap[key] = value as Any
    }
}

object EmptyContext : ImmutableContext {
    override fun <TYPE> get(key: ContextKey<TYPE>): TYPE? = null
}

interface ImmutableContext {
    @Suppress("UNCHECKED_CAST")
    operator fun <TYPE> get(key: ContextKey<TYPE>): TYPE?
}

class ContextKey<TYPE>(
    val name: String
)