package org.crux.status

import kotlin.collections.iterator

/**
 * ステータス補正値（Modifier）を一括管理するコンテナクラスです。
 *
 * ゲームのキャラクターのステータス（攻撃力、防御力など）に対する、
 * 複数のバフ・デバフや計算ステップ（加算・乗算）の補正値を集計・フィルタリングするために使用します。
 *
 * @property statusModifierMap ステータス補正キーと補正値を保持する内部マップ。デフォルトは空のマップ。
 */
class StatusContainer(
    private val statusModifierMap: MutableMap<StatusModifierKey, Double> = linkedMapOf()
) {
    /**
     * 指定されたキーに対応するステータス補正値を取得します。
     *
     * @param key 取得したいステータス補正キー
     * @return 補正値。キーが存在しない場合は `0.0`
     */
    operator fun get(key: StatusModifierKey): Double {
        return statusModifierMap[key] ?: 0.0
    }

    /**
     * 指定されたキーのステータス補正値に、指定された値を加算（蓄積）します。
     *
     * @param key 加算対象のステータス補正キー
     * @param value 加算する数値
     */
    fun add(key: StatusModifierKey, value: Double) {
        statusModifierMap[key] = get(key) + value
    }

    /**
     * 指定されたキーと値のペアを現在のコンテナに加算（蓄積）します。
     *
     * 本演算子によって、`container += (key to value)` のような直感的な加算代入構文が使用可能です。
     *
     * @param pair 加算対象のステータス補正キーと加算する数値のペア
     */
    operator fun plusAssign(pair: Pair<StatusModifierKey, Double>) {
        add(pair.first, pair.second)
    }


    /**
     * 現在のコンテナの複製（シャローコピー）を作成します。
     *
     * 内部マップの参照を切り離した、新しい独立したコンテナを返します。
     *
     * @return 独立した新しい [StatusContainer] インスタンス
     */
    fun copy(): StatusContainer {
        return StatusContainer(statusModifierMap.toMutableMap())
    }

    /**
     * 指定された特定のステータス（例: 攻撃力のみ）に関する補正値だけを抽出した、新しいコンテナを返します。
     *
     * @param status 抽出条件にするステータス
     * @return フィルタリングされた新しい [StatusContainer] インスタンス
     */
    fun filterStatus(status: Status): StatusContainer {
        val filteredMap = statusModifierMap.filter { it.key.status == status }
        return StatusContainer(filteredMap.toMutableMap())
    }

    /**
     * 指定された計算ステップ（例: 装備品補正、バフ補正など）に関する補正値だけを抽出した、新しいコンテナを返します。
     *
     * @param statusStepType 抽出条件にするステータス計算ステップ種別
     * @return フィルタリングされた新しい [StatusContainer] インスタンス
     */
    fun filterStatusStepType(statusStepType: StatusStepType): StatusContainer {
        val filteredMap = statusModifierMap.filter { it.key.statusStepType == statusStepType }
        return StatusContainer(filteredMap.toMutableMap())
    }

    /**
     * 指定された計算タイプ（例: 加算、乗算など）に関する補正値だけを抽出した、新しいコンテナを返します。
     *
     * @param calculateType 抽出条件にする計算タイプ
     * @return フィルタリングされた新しい [StatusContainer] インスタンス
     */
    fun filterCalculateType(calculateType: CalculateType): StatusContainer {
        val filteredMap = statusModifierMap.filter { it.key.calculateType == calculateType }
        return StatusContainer(filteredMap.toMutableMap())
    }

    /**
     * 別のコンテナが持つステータス補正値を、現在のコンテナにすべて合算（マージ）します。
     * 相手のコンテナにのみ存在するキーも、正しく現在のコンテナに追加されます。
     *
     * @param container 合算元となる別の [StatusContainer] インスタンス
     */
    fun merge(container: StatusContainer) {
        for ((key, value) in container.getMap()) {
            this.add(key, value)
        }
    }


    /**
     * 保持しているステータス補正値のマップを、外部読み取り用の不変（Immutable）マップとして取得します。
     *
     * @return ステータス補正キーと補正値のペアを持つ読み取り専用の [Map]
     */
    fun getMap(): Map<StatusModifierKey, Double> {
        return statusModifierMap.toMap()
    }
}