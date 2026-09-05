package org.crux.factory

import org.crux.collection.Context
import org.crux.collection.EmptyContext
import org.crux.context.FactoryContext

class Factory<PRODUCT, MODULE_TYPE : FactoryModule<PRODUCT>> {

    fun regeneration(
        remarks: Context?,
        updateContext: FactoryContext<PRODUCT>?,
        newProduct: PRODUCT,
        modules: List<MODULE_TYPE>,
        other: PRODUCT
    ): PRODUCT {
        val remarksContext = remarks ?: EmptyContext
        val context = FactoryContext(newProduct)

        for (module in modules) {
            module.read(remarksContext, context, other)
        }

        for (module in modules) {
            module.update(remarksContext, updateContext, context)
        }

        for (module in modules) {
            module.process(remarksContext, context)
        }

        for (module in modules) {
            module.reflect(remarksContext, context)
        }

        return context.product
    }

    fun generation(
        remarks: Context?,
        generateContext: FactoryContext<PRODUCT>,
        modules: List<MODULE_TYPE>
    ): PRODUCT {
        val remarksContext = remarks ?: EmptyContext

        for (module in modules) {
            module.process(remarksContext, generateContext)
        }

        for (module in modules) {
            module.reflect(remarksContext, generateContext)
        }

        return generateContext.product
    }
}