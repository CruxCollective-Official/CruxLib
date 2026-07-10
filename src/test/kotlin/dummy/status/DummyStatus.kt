package dummy.status

import game.status.Status
import system.Key

class DummyStatus : Status {
    override fun getPath(): Key {
        return Key("crux", "dummy_status")
    }
}
