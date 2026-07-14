package dummy

import org.crux.game.item.ItemType
import org.crux.system.key.Key
import org.crux.system.key.createCruxKey

class DummyItem : ItemType {
    override fun getTypeName(): Key {
        return createCruxKey("dummy_item")
    }
}