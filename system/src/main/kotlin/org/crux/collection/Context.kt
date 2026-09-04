package org.crux.collection

class Context(
private val contextMap: MutableMap<ContextKey<*>, Any> = mutableMapOf()
) {
    @Suppress("UNCHECKED_CAST")
    operator fun <TYPE> get(key: ContextKey<TYPE>): TYPE {
        return contextMap[key] as TYPE
    }

    operator fun <TYPE> set(key: ContextKey<TYPE>, value: TYPE) {
        contextMap[key] = value as Any
    }
}

class ContextKey<TYPE>(
    val name: String
)