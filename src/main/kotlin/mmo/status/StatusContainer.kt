package mmo.status

class StatusContainer(
    private val statusModifierMap: HashMap<StatusModifierKey, Double> = hashMapOf()
) {
    fun get(key: StatusModifierKey): Double {
        return statusModifierMap[key] ?: 0.0
    }

    fun put(key: StatusModifierKey, value: Double) {
        statusModifierMap[key] = value
    }
}
