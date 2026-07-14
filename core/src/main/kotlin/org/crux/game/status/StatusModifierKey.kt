package org.crux.game.status

import org.crux.system.key.Key

data class StatusModifierKey(
    val status: Status,
    val statusStepType: StatusStepType,
    val calculateType: CalculateType,
)

data class CalculateType(val key: Key)

data class StatusStepType(val key: Key)