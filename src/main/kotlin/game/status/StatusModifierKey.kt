package game.status

data class StatusModifierKey(
    val status: Status,
    val statusStepType: StatusStepType,
    val calculateType: CalculateType
) {
    fun getPaths(): String {
        return "status_modifier_key:${status.getPath()}:${statusStepType.path}:${calculateType.path}"
    }
}
