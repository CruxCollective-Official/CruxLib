package org.crux.modify

abstract class CalculateModifier<TYPE>{
    abstract fun calc(target: TYPE, value: TYPE): TYPE
}