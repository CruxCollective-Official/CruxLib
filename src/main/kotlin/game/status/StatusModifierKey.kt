package game.status

data class StatusModifierKey(
    val status: Status,
    val statusStepType: StatusStepType,
    val calculateType: CalculateType,
)