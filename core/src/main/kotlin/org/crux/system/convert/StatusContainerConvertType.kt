package org.crux.system.convert

import org.crux.core.createCruxKey
import org.crux.game.status.StatusContainer
import org.crux.system.key.Key
import kotlin.collections.iterator

class StatusContainerConvertType : ConvertType<StatusContainer> {
    override fun getKeyTag(): Key {
        return createCruxKey("status_container")
    }

    override fun stringConvertLogic(source: StatusContainer): String {
        var dataString = "${getKeyTag().identifier}>"

        for ((key, value) in source.getMap()) {
            dataString += "[${key.status.getPath().identifier},${key.statusStepType.key.identifier},${key.calculateType.key.identifier}:$value]"
        }

        return dataString
    }

    //未実装!!!
    override fun dataTypeConvertLogic(source: String): StatusContainer {
        TODO("だれかなんとかして")
    }
}