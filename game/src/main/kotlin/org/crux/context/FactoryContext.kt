package org.crux.context

class FactoryContext<PRODUCT>(
    override val product: PRODUCT,
    private val contextMap: MutableMap<FactoryContextKey<*>, Any> = mutableMapOf(),
) : DataImmutableFactoryContext<PRODUCT>, ProductImmutableFactoryContext<PRODUCT>, AllImmutableFactoryContext<PRODUCT> {

    @Suppress("UNCHECKED_CAST")
    override operator fun <TYPE> get(key: FactoryContextKey<TYPE>): TYPE {
        return contextMap[key] as TYPE
    }

    override operator fun <TYPE> set(key: FactoryContextKey<TYPE>, value: TYPE) {
        contextMap[key] = value as Any
    }
}

interface DataImmutableFactoryContext<PRODUCT> {
    val product: PRODUCT
    operator fun <TYPE> get(key: FactoryContextKey<TYPE>): TYPE
}

interface ProductImmutableFactoryContext<PRODUCT> {
    operator fun <TYPE> get(key: FactoryContextKey<TYPE>): TYPE
    operator fun <TYPE> set(key: FactoryContextKey<TYPE>, value: TYPE)
}

interface AllImmutableFactoryContext<PRODUCT> {
    operator fun <TYPE> get(key: FactoryContextKey<TYPE>): TYPE
}

class FactoryContextKey<TYPE>(
    val name: String
)