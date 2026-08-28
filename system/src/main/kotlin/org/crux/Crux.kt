package org.crux

import org.crux.annotations.InternalCruxApi
import org.crux.register.RegistryBuilder

import org.crux.generated.GeneratedRegistries
import org.crux.holder.IdHolder
import org.crux.key.KeyFactory
import org.crux.register.ImmutableRegistry
import org.crux.register.RegistryContainer
import org.crux.register.RegistryKey

/**
 * Cruxライブラリ全体のマスターエントリーポイント（唯一の入り口）です。
 *
 * 本クラスはスレッドセーフなシングルトンとして実装されており、JVM起動時に
 * アノテーションプロセッサによって自動集約されたすべてのレジストリを内包します。
 */
object Crux {

    /**
     * 外部には露出させない、ライブラリ内部の集約レジストリコンテナ。
     * カプセル化を徹底し、外部からの不正な変更やマップ構造の露出を防ぐため private にしています。
     */
    private val registryContainer: RegistryContainer

    /**
     * プロジェクト内の全モジュール（Core、API、各内部コンポーネント間）で共通利用するキーファクトリー。
     *
     * ※一般のライブラリ利用者が直接触ることは想定されていません。
     */
    @InternalCruxApi
    val CRUX_KEY_MANAGER = KeyFactory("crux")

    init {
        val builder = RegistryBuilder()
        GeneratedRegistries.register(builder)
        registryContainer = builder.build()
    }

    /**
     * 指定された [RegistryKey] に紐づく、変更不可能なレジストリを取得します。
     *
     * クラス名（[RegistryContainer]）を隠蔽し、この関数を唯一の窓口にすることで、
     * 将来的な内部データ構造の変更に対して高いリファクタリング耐性を持ちます。
     *
     * @param KEY レジストリが管理する要素の識別IDの型
     * @param VALUE レジストリが保持する要素（[IdHolder]を継承したデータ）の型
     * @param key 取得したいレジストリを識別するための固有キー
     * @return キーに対応する、値の追加・削除が不可能な [ImmutableRegistry] インスタンス
     */
    operator fun <KEY, VALUE : IdHolder<KEY>> get(key: RegistryKey<KEY, VALUE>): ImmutableRegistry<KEY, VALUE> {
        return registryContainer[key]
    }
}
