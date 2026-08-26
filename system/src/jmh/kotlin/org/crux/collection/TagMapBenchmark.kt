package org.crux.collection

import org.openjdk.jmh.annotations.*
import java.util.BitSet
import java.util.concurrent.TimeUnit

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(3)
open class TagMapBenchmark {

    private lateinit var map: TagMap<Int, String, Int>

    // 全探索用
    private lateinit var values: ArrayList<String>
    private lateinit var referenceIndex: BitSet

    @Setup
    fun setup() {
        map = TagMap()

        map.putTag(1)

        val elementCount = 10_000_000
        val tagCount = 1_000

        values = ArrayList(elementCount)
        referenceIndex = BitSet()

        for (i in 0 until elementCount) {
            val value = "要素:$i"

            map[i] = value
            values.add(value)
        }

        for (i in 0 until tagCount) {
            val index = i * (elementCount / tagCount)

            map.setTag(1, index)
            referenceIndex.set(index)
        }

        map.addFilter(1)
    }

    /**
     * 今作っているTagMap
     */
    @Benchmark
    fun tagMapGetFilter(): List<String> {
        return map.getFilter()
    }

    /**
     * 1,000,000要素を全部調べる方式
     */
    @Benchmark
    fun fullScanGetFilter(): List<String> {
        val result = ArrayList<String>()

        for (i in values.indices) {
            if (referenceIndex.get(i)) {
                result.add(values[i])
            }
        }

        return result
    }
}