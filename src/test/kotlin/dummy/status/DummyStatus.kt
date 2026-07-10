package dummy.status

import game.status.Status

class DummyStatus : Status {
    override fun getPath(): String {
        return "dummy_status"
    }
}
