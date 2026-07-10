package mmo.status

class StatusContainer(
    private val statusModifierMap: HashMap<StatusModifierKey, Double> = hashMapOf()
) {
    fun get(key: StatusModifierKey): Double {
        return statusModifierMap[key] ?: 0.0
    }

    fun add(key: StatusModifierKey, value: Double) {
        statusModifierMap[key] = get(key) + value
    }

    fun copy(): StatusContainer {
        val newMap = HashMap<StatusModifierKey, Double>()
        for ((key, value) in statusModifierMap) {
            newMap[key] = value
        }
        return StatusContainer(newMap)
    }

    fun filterStatus(status: Status): StatusContainer {
        val newMap = HashMap<StatusModifierKey, Double>()
        for ((key, value) in statusModifierMap) {
            if (key.status == status) {
                newMap[key] = value
            }
        }
        return StatusContainer(newMap)
    }

    fun filterStatusStepType(statusStepType: StatusStepType): StatusContainer {
        val newMap = HashMap<StatusModifierKey, Double>()
        for ((key, value) in statusModifierMap) {
            if (key.statusStepType == statusStepType) {
                newMap[key] = value
            }
        }
        return StatusContainer(newMap)
    }

    fun filterCalculateType(calculateType: CalculateType): StatusContainer {
        val newMap = HashMap<StatusModifierKey, Double>()
        for ((key, value) in statusModifierMap) {
            if (key.calculateType == calculateType) {
                newMap[key] = value
            }
        }
        return StatusContainer(newMap)
    }

    fun merge(container: StatusContainer) {
        for ((key) in statusModifierMap) {
            statusModifierMap[key] = get(key) + container.get(key)
        }
    }

    fun getAllPaths(): String {
        var path = "status_container"

        for ((key, value) in statusModifierMap) {
            path += "[${key.getPaths()}:${value}]"
        }
        return path
    }
}
