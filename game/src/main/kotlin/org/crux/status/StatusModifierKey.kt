package org.crux.status

import org.crux.key.Key

/**
 * ステータス補正値（Modifier）を一意に識別するための複合キークラスです。
 *
 * 「どのステータス（[status]）に対して」、「どの計算ステップ（[statusStepType]）で」、
 * 「どのような計算方法（[calculateType]）を適用するか」を組み合わせて管理します。
 *
 * @property status 補正対象となるステータス（例: 攻撃力、防御力、最大HPなど）
 * @property statusStepType 補正が適用される計算ステップ（例: 装備品による補正、バフによる補正など）
 * @property calculateType 補正値の計算タイプ（例: 固定値の加算、ベース値に対する乗算など）
 */
data class StatusModifierKey(
    val status: Status,
    val statusStepType: StatusStepType,
    val calculateType: CalculateType,
)

/**
 * ステータス補正の計算方法（例: 加算、乗算など）を識別するための識別クラスです。
 *
 * @property key インスタンスを一意に識別するための [Key] 型データ
 */
data class CalculateType(val key: Key)

/**
 * ステータス補正が「どの計算フェーズ（段階）」で適用されるかを識別するための識別クラスです。
 *
 * 装備品（EQUIPMENT）、パッシブスキル（PASSIVE）、一時的なバフ（BUFF）などを区別し、
 * 正しい計算順序でステータスを集計するために使用します。
 *
 * @property key インスタンスを一意に識別するための [Key] 型データ
 */
data class StatusStepType(val key: Key)