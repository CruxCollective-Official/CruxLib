package org.crux.dummy

import org.crux.holder.IdHolder

class DummyInstance : IdHolder<Int> {
    override fun getID(): Int {
        return 1
    }
}