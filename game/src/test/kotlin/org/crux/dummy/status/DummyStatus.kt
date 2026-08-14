package org.crux.dummy.status

import org.crux.Crux.CRUX_KEY_MANAGER
import org.crux.key.Key
import org.crux.status.Status

class DummyStatus : Status {
    override fun getID(): Key {
        return CRUX_KEY_MANAGER.create("dummy_status")
    }
}
