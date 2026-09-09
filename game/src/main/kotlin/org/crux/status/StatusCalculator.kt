package org.crux.status

import org.crux.modify.CalculateModifier
import org.crux.modify.PriorityList

class StatusCalculator<TYPE>(
	val targetStatus: Status,
	val statusSet: ImmutableStatusContainer<TYPE>
) {
	private var isCalculated = false
	private var resultCache: TYPE? = null

	@Suppress("UNCHECKED_CAST")
	fun calculation(
		stepPriority: PriorityList<StatusStep>,
		calculateModifierPriority: PriorityList<CalculateModifier<TYPE>>,
		defaultValue: TYPE,
	): TYPE {
		if (isCalculated) {
			return resultCache as TYPE
		}

		var resultValue: TYPE = defaultValue

		for (step in stepPriority.priority) {
			for (calc in calculateModifierPriority.priority) {
				resultValue = calc.calc(resultValue, statusSet[StatusModifierKey(targetStatus, step, calc)])
			}
		}

		resultCache = resultValue
		isCalculated = true

		return resultValue
	}
}