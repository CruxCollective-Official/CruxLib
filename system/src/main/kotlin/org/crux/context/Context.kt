package org.crux.context

class Context<PRODUCT>(
    val product: PRODUCT,
    private val contextMap: MutableMap<ContextKey<*>, Any> = mutableMapOf(),
) : ImmutableContext {

    @Suppress("UNCHECKED_CAST")
    override operator fun <TYPE> get(key: ContextKey<TYPE>): TYPE {
        return contextMap[key] as TYPE
    }

    operator fun <TYPE> set(key: ContextKey<TYPE>, value: TYPE) {
        contextMap[key] = value as Any
    }
}

interface ImmutableContext {
    operator fun <TYPE> get(key: ContextKey<TYPE>): TYPE
}

class ContextKey<TYPE>(
    val name: String
)