package dummy.status

import org.crux.game.status.Status
import org.crux.system.key.Key
import org.crux.system.key.createCruxKey

class DummyStatus : Status {
    override fun getPath(): Key {
        return createCruxKey("dummy_status")
    }
}
