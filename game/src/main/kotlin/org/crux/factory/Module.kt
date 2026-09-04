package org.crux.factory

import org.crux.collection.Context
import org.crux.context.AllImmutableFactoryContext
import org.crux.context.FactoryContext
import org.crux.context.DataImmutableFactoryContext
import org.crux.context.ProductImmutableFactoryContext

/**
 * [PRODUCT]型の完成予定データに必要な変更を施す[Factory]を動かすためのモジュールを作成する際に使用します。
 *
 * @param PRODUCT 完成予定データの型
 */
interface FactoryModule<PRODUCT> {
    /**
     * 既存のデータをContextにロードします。
     *
     * @param remarks 外部に存在する必要なデータを格納したContext
     * @param context 空の状態の[ProductImmutableFactoryContext] このContextに必要なデータを[read]メソッドでロードします。
     * @param other 既に一度完成された[PRODUCT]型のデータ このモジュールが担当するデータを[read]メソッドでロードする際に使用します。
     */
    fun read(remarks: Context?, context: ProductImmutableFactoryContext<PRODUCT>, other: PRODUCT)

    /**
     * Contextにロードした既存データを変更後状態に加工します。
     *
     * @param remarks 外部に存在する必要なデータを格納したContext
     * @param updateContext 変更データを持つ[AllImmutableFactoryContext]
     * @param context モジュールが担当するデータを変更後状態にして反映する対象の[ProductImmutableFactoryContext]
     */
    fun update(remarks: Context?, updateContext: AllImmutableFactoryContext<PRODUCT>?, context: ProductImmutableFactoryContext<PRODUCT>)

    /**
     * 定義や定数に依存しない生成時に必要な特殊処理を担当します。
     *
     * @param remarks 外部に存在する必要なデータを格納したContext
     * @param context モジュールが担当するデータに外部依存や定義定数を使わない生成時に行う特殊な処理結果を反映する対象（[DataImmutableFactoryContext]）
     */
    fun process(remarks: Context?, context: ProductImmutableFactoryContext<PRODUCT>)

    /**
     * Contextのデータを完成予定データに反映します。
     *
     * @param remarks 外部に存在する必要なデータを格納したContext
     * @param context モジュールが担当するデータを完成予定データに反映する時に参照する対象（[DataImmutableFactoryContext]）
     */
    fun reflect(remarks: Context?, context: DataImmutableFactoryContext<PRODUCT>)
}