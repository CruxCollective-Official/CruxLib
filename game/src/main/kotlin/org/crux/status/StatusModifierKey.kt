package org.crux.status

import org.crux.modify.CalculateModifier

data class StatusModifierKey<TYPE>(
    val status: Status,
    val step: StatusStep,
    val calculateModifier: CalculateModifier<TYPE>
)

class StatusStep