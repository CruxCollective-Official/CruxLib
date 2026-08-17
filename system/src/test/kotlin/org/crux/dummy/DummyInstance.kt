package org.crux.dummy

import org.crux.ID

class DummyInstance : ID<Int> {
    override fun getID(): Int {
        return 1
    }
}