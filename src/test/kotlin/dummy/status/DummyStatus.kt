package dummy.status

import game.status.Status
import system.key.Key
import system.key.createCruxKey

class DummyStatus : Status {
    override fun getPath(): Key {
        return createCruxKey("dummy_status")
    }
}
