package org.crux.system.convert

import org.crux.game.status.StatusContainer
import kotlin.collections.iterator

class StatusContainerConvertType : ConvertType<StatusContainer> {
    override fun getKeyStringTag(): String {
        return "status_container"
    }

    override fun stringConvertLogic(source: StatusContainer): String {
        var dataString = "${getKeyStringTag()}>"

        for ((key, value) in source.getMap()) {
            dataString += "[${key.status.getPath()},${key.statusStepType.key.identifier},${key.calculateType.key.identifier}:$value]"
        }

        return dataString
    }

    //未実装!!!
    override fun dataTypeConvertLogic(source: String): StatusContainer {
        val container = StatusContainer()
        var dataString = removeTag(getKeyStringTag(), source)

        return container
    }

    //求める値 status_container>[dummy_status,test,add:10]
}