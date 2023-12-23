package utils

import java.io.File
import java.io.InputStream

class FileReader {

    fun getAllLines(filename: String): List<String> {
        val list: MutableList<String> = mutableListOf()
        val inputStream: InputStream = File(PATH + filename).inputStream();
        inputStream.bufferedReader().forEachLine { line ->
            list.add(line);
        }
        return list
    }

    private companion object {
        const val PATH = "src/main/kotlin/text_files/"
    }
}