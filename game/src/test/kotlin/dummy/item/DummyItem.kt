package dummy.item

import org.crux.Crux.CRUX_KEY_MANAGER
import org.crux.annotations.InternalCruxApi
import org.crux.item.Item
import org.crux.key.Key

@InternalCruxApi
class DummyItem : Item {
    fun maxAmount(): Int {
        return 64
    }

    override fun id(): Key {
        return CRUX_KEY_MANAGER.create("test_item")
    }
}