package org.crux.collection

import java.util.BitSet

class FullScanMap(
    private val values: ArrayList<String>,
    private val referenceIndex: BitSet
) {
    fun getFilter(): List<String> {
        val result = ArrayList<String>()

        for (i in values.indices) {
            if (referenceIndex.get(i)) {
                result.add(values[i])
            }
        }

        return result
    }
}