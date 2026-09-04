package org.crux.context

class FactoryContext<PRODUCT>(
    override val product: PRODUCT,
    private val contextMap: MutableMap<FactoryContextKey<*>, Any> = mutableMapOf(),
) : DataImmutableContext<PRODUCT>, ProductImmutableContext<PRODUCT>, AllImmutableContext<PRODUCT> {

    @Suppress("UNCHECKED_CAST")
    override operator fun <TYPE> get(key: FactoryContextKey<TYPE>): TYPE {
        return contextMap[key] as TYPE
    }

    override operator fun <TYPE> set(key: FactoryContextKey<TYPE>, value: TYPE) {
        contextMap[key] = value as Any
    }
}

interface DataImmutableContext<PRODUCT> {
    val product: PRODUCT
    operator fun <TYPE> get(key: FactoryContextKey<TYPE>): TYPE
}

interface ProductImmutableContext<PRODUCT> {
    operator fun <TYPE> get(key: FactoryContextKey<TYPE>): TYPE
    operator fun <TYPE> set(key: FactoryContextKey<TYPE>, value: TYPE)
}

interface AllImmutableContext<PRODUCT> {
    operator fun <TYPE> get(key: FactoryContextKey<TYPE>): TYPE
}

class FactoryContextKey<TYPE>(
    val name: String
)