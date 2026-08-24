package dummy.item

import org.crux.item.Item

class DummyItem : Item<Int> {
    override fun maxAmount(): Int {
        return 64
    }
}