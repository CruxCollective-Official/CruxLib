package org.crux.annotations

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class JsonType(
    val targetRegistryKeyID : String,
    val fileName : String
)
