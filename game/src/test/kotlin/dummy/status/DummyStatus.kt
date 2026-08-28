package dummy.status

import org.crux.Crux.CRUX_KEY_MANAGER
import org.crux.annotations.InternalCruxApi
import org.crux.key.Key
import org.crux.status.Status

@InternalCruxApi
class DummyStatus : Status {
    override fun id(): Key {
        return CRUX_KEY_MANAGER.create("dummy_status")
    }
}
