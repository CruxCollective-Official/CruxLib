internal data class Key(
    val namespace: String,
    val path: String
) {
    val identifier: String get() = "$namespace:$path"
}
