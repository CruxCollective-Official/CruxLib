package org.crux.json

class JsonFile(
    rawData: String,
) {
    val data: String = normalize(rawData)



    private fun normalize(input: String): String {
        var result = ""
        var stringFlag = false

        input.forEach { char ->
            if (char == '"') stringFlag = !stringFlag
            if (char == ' ') {
                if (stringFlag) result += char
            } else {
                result += char
            }
        }

        return result
    }
}
