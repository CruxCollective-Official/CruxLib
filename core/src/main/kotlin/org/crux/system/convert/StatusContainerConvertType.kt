package org.crux.system.convert

import org.crux.core.Crux
import org.crux.core.CruxRegistryTypeKeys
import org.crux.core.createCruxKey
import org.crux.game.status.CalculateType
import org.crux.game.status.Status
import org.crux.game.status.StatusContainer
import org.crux.game.status.StatusModifierKey
import org.crux.game.status.StatusStepType
import org.crux.system.key.Key
import org.crux.system.registry.Registry
import org.crux.system.registry.RegistryTypeKey

class StatusContainerConvertType(
    private val keyConvertType: KeyConvertType,
    private val doubleConvertType: DoubleConvertType,
) : ConvertType<StatusContainer> {
    override fun getKeyTag(): Key {
        return createCruxKey("status_container")
    }

    override fun stringConvertLogic(source: StatusContainer): String {
        val dataString = "${getKeyTag().identifier}>"

        val builder = StringBuilder()
        for ((key, value) in source.getMap()) {
            builder
                .append("[")
                .append(keyConvertType.stringConvertLogic(key.status.getPath())).append(",")
                .append(keyConvertType.stringConvertLogic(key.statusStepType.key)).append(",")
                .append(keyConvertType.stringConvertLogic(key.calculateType.key)).append(",")
                .append(doubleConvertType.stringConvertLogic(value))
                .append("]")
        }

        return dataString + builder.toString()
    }

    //未実装!!!
    override fun dataTypeConvertLogic(source: String): StatusContainer {
        val data = removeTag(getKeyTag().identifier, source)
        val entries = data.removePrefix("[").removeSuffix("]").split("][")
        val map = mutableMapOf<StatusModifierKey, Double>()
        val statusRegistry = Crux.registry(CruxRegistryTypeKeys.STATUS_KEY)
        for (entry in entries) {
            val (status, stepType, calcType, value) = entry.split(",")
            println(keyConvertType.dataTypeConvertLogic(status))
            println(statusRegistry.javaClass.getDeclaredField("registryMap").let {
                it.isAccessible = true
                it.get(statusRegistry) as MutableMap<Key, Status>
            })
            val key = StatusModifierKey(
                statusRegistry.get(keyConvertType.dataTypeConvertLogic(status)),
                StatusStepType(keyConvertType.dataTypeConvertLogic(stepType)),
                CalculateType(keyConvertType.dataTypeConvertLogic(calcType))
            )
            map[key] = doubleConvertType.dataTypeConvertLogic(value)
        }
        return StatusContainer(map)
    }
}