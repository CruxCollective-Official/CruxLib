package org.crux.modify

data class PriorityList<TYPE>(
	val priority: List<TYPE>
) {
	fun toRange(index: Int): PriorityList<TYPE> {
		if (index !in priority.indices) {
			throw IndexOutOfBoundsException("Index $index is out of bounds.")
		}
		return PriorityList(priority.take(index + 1))
	}

	fun toRange(target: TYPE): PriorityList<TYPE> {
		val index = priority.indexOf(target)
		if (index == -1) {
			throw IndexOutOfBoundsException("Target element not found in the priority list.")
		}
		return PriorityList(priority.take(index + 1))
	}
}