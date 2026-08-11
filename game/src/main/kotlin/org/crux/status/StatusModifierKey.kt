package org.crux.status

import org.crux.key.Key

data class StatusModifierKey(
    val status: Status,
    val statusStepType: StatusStepType,
    val calculateType: CalculateType,
)

data class CalculateType(val key: Key)

data class StatusStepType(val key: Key)