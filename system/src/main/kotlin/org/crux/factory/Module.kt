package org.crux.factory

interface Module

interface ProcesserModule : Module {
    fun process()
}

interface ReaderModule : Module {
    fun reader()
}