package org.crux.status

import org.crux.modify.CalculateModifier

class ImmutableStatusContainer<TYPE>(
	val defaultValue: TYPE,
	private val statusMap: Map<StatusModifierKey<TYPE>, TYPE> = mapOf()
) {
	private fun filterBy(predicate: (StatusModifierKey<TYPE>) -> Boolean): ImmutableStatusContainer<TYPE> {
		return ImmutableStatusContainer(defaultValue, statusMap.filterKeys(predicate))
	}

	operator fun get(key: StatusModifierKey<TYPE>): TYPE {
		return statusMap[key] ?: defaultValue
	}

	fun filterStatus(filter: Status) = filterBy { it.status == filter }

	fun filterStep(filter: StatusStep) = filterBy { it.step == filter }

	fun filterCalculateModifier(filter: CalculateModifier<TYPE>) = filterBy { it.calculateModifier == filter }
}


class MutableStatusContainer<TYPE>(
	val defaultValue: TYPE,
) {
	private val statusMap: MutableMap<StatusModifierKey<TYPE>, TYPE> = mutableMapOf()

	private fun filterBy(predicate: (StatusModifierKey<TYPE>) -> Boolean): ImmutableStatusContainer<TYPE> {
		return ImmutableStatusContainer(defaultValue, statusMap.filterKeys(predicate))
	}

	operator fun get(key: StatusModifierKey<TYPE>): TYPE {
		return statusMap[key] ?: defaultValue
	}

	operator fun set(key: StatusModifierKey<TYPE>, value: TYPE) {
		statusMap[key] = value
	}

	fun toImmutable(): ImmutableStatusContainer<TYPE> {
		return ImmutableStatusContainer(defaultValue, statusMap.toMap())
	}

	fun filterStatus(filter: Status) = filterBy { it.status == filter }

	fun filterStep(filter: StatusStep) = filterBy { it.step == filter }

	fun filterCalculateModifier(filter: CalculateModifier<TYPE>) = filterBy { it.calculateModifier == filter }
}