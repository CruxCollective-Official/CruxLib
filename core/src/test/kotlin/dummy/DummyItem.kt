package dummy

import org.crux.game.item.ItemType
import org.crux.system.key.Key
import org.crux.core.createCruxKey

class DummyItem : ItemType {
    override fun getTypeId(): Key {
        return createCruxKey("dummy_item")
    }
}