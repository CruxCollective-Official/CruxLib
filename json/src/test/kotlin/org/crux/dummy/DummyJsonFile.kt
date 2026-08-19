package org.crux.dummy

object DummyJsonFile {
    const val dummy1: String = """
        {
          "id": 1,
          "name": "user 1",
          "is_active": true
        }
    """

    const val dummy2: String = """
        {
          "id": 1,
          "name"   :    "user 1",
              "is_active": true
        }
    """
}