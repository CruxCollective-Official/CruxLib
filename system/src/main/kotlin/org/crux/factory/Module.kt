package org.crux.factory

import org.crux.collection.Context
import org.crux.context.AllImmutableContext
import org.crux.context.FactoryContext
import org.crux.context.DataImmutableContext
import org.crux.context.ProductImmutableContext

interface FactoryModule<PRODUCT> {
    /**
     * 既存のデータをContextにロードするモジュールです。
     */
    fun read(remarks: Context, context: FactoryContext<PRODUCT>, other: PRODUCT)

    /**
     * Contextにロードした既存データを、加工するモジュールです。
     */
    fun update(remarks: Context, updateContext: AllImmutableContext<PRODUCT>?, context: ProductImmutableContext<PRODUCT>)

    /**
     * 定義や定数に依存しない生成時に必要な特殊処理を扱うモジュールです。
     */
    fun process(remarks: Context, context: ProductImmutableContext<PRODUCT>)

    /**
     * Contextのデータを完成予定品に反映するモジュールです。
     */
    fun reflect(remarks: Context, context: DataImmutableContext<PRODUCT>)
}