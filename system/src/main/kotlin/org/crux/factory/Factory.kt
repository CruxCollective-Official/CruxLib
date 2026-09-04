package org.crux.factory

import org.crux.collection.Context
import org.crux.context.FactoryContext

class Factory<PRODUCT, MODULE_TYPE : FactoryModule<PRODUCT>> {

    fun regeneration(remarks: Context, updateContext: FactoryContext<PRODUCT>?, newProduct: PRODUCT, modules: List<MODULE_TYPE>, other: PRODUCT): PRODUCT {
        val context = FactoryContext(newProduct)

        for (module in modules) {
            module.read(context, other)
        }

        for (module in modules) {
            module.update(updateContext, context)
        }

        for (module in modules) {
            module.process(remarks, context)
        }

        for (module in modules) {
            module.reflect(context)
        }

        return context.product
    }

    fun generation(remarks: Context, newProduct: PRODUCT, modules: List<MODULE_TYPE>): PRODUCT {
        val context = FactoryContext(newProduct)

        for (module in modules) {
            module.process(remarks, context)
        }

        for (module in modules) {
            module.reflect(context)
        }

        return context.product
    }
}