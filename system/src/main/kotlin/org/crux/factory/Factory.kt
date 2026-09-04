package org.crux.factory

import org.crux.collection.Context
import org.crux.context.FactoryContext

class Factory<PRODUCT, MODULE_TYPE : FactoryModule<PRODUCT>> {

    fun regeneration(
        remarks: Context?,
        updateContext: FactoryContext<PRODUCT>?,
        newProduct: PRODUCT,
        modules: List<MODULE_TYPE>,
        other: PRODUCT
    ): PRODUCT {
        val context = FactoryContext(newProduct)

        for (module in modules) {
            module.read(remarks, context, other)
        }

        for (module in modules) {
            module.update(remarks, updateContext, context)
        }

        for (module in modules) {
            module.reflect(remarks, context)
        }

        return context.product
    }

    fun generation(
        remarks: Context?,
        generateContext: FactoryContext<PRODUCT>,
        modules: List<MODULE_TYPE>
    ): PRODUCT {
        for (module in modules) {
            module.process(remarks, generateContext)
        }

        for (module in modules) {
            module.reflect(remarks, generateContext)
        }

        return generateContext.product
    }
}