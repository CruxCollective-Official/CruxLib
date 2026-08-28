package dummy

import org.crux.holder.IdHolder

class DummyInstance : IdHolder<Int> {
    override fun id(): Int {
        return 1
    }
}