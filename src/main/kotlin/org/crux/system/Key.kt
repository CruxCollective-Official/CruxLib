package org.crux.system

data class Key(
    val namespace: String,
    val path: String
) {
    val identifier: String get() = "${namespace}_${path}"
}