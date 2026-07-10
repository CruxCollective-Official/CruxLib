package dummy.status

import mmo.status.Status

class DummyStatus : Status {
    override fun getPath(): String {
        return "dummy_status"
    }
}
