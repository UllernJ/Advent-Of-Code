package solutions

import utils.FileReader

class Day3 {
    private val input = FileReader("day3.txt").getAllLines()
    private var sum = 0
    fun solutionPart1(): Int {
        val values = getValues()
        for ((layerIndex, layer) in values.withIndex()) {
            var currentNumberAsString = ""
            var symbolNeighbor = false
            for ((valueIndex, value) in layer.withIndex()) {
                val number = value.toIntOrNull()
                if (number != null) {
                    currentNumberAsString += number
                    if (layerIndex != 0 && !symbolNeighbor) {
                        symbolNeighbor = containsSymbol(values[layerIndex - 1][valueIndex])
                        if (valueIndex != 0 && !symbolNeighbor) {
                            symbolNeighbor = containsSymbol(values[layerIndex - 1][valueIndex - 1])
                        }
                        if (valueIndex != values.size - 1 && !symbolNeighbor) {
                            symbolNeighbor = containsSymbol(values[layerIndex - 1][valueIndex + 1])
                        }
                    }
                    if (layerIndex != values.size - 1 && !symbolNeighbor) {
                        symbolNeighbor = containsSymbol(values[layerIndex + 1][valueIndex])
                        if (valueIndex != 0 && !symbolNeighbor) {
                            symbolNeighbor = containsSymbol(values[layerIndex + 1][valueIndex - 1])
                        }
                        if (valueIndex != values.size - 1 && !symbolNeighbor) {
                            symbolNeighbor = containsSymbol(values[layerIndex + 1][valueIndex + 1])
                        }
                    }
                    if (valueIndex != 0 && !symbolNeighbor) {
                        symbolNeighbor = containsSymbol(values[layerIndex][valueIndex - 1])
                        if (layerIndex != values.size - 1 && !symbolNeighbor) {
                            symbolNeighbor = containsSymbol(values[layerIndex + 1][valueIndex - 1])
                        }
                        if (layerIndex != 0 && !symbolNeighbor) {
                            symbolNeighbor = containsSymbol(values[layerIndex - 1][valueIndex - 1])
                        }
                    }
                    if (valueIndex != layer.size - 1 && !symbolNeighbor) {
                        symbolNeighbor = containsSymbol(values[layerIndex][valueIndex + 1])
                        if (layerIndex != values.size - 1 && !symbolNeighbor) {
                            symbolNeighbor = containsSymbol(values[layerIndex + 1][valueIndex + 1])
                        }
                        if (layerIndex != 0 && !symbolNeighbor) {
                            symbolNeighbor = containsSymbol(values[layerIndex - 1][valueIndex + 1])
                        }
                    }
                }
                if (number == null && currentNumberAsString.isNotEmpty() && symbolNeighbor) {
                    sum += currentNumberAsString.toInt()
                    symbolNeighbor = false
                }
                if (number == null && !symbolNeighbor) {
                    currentNumberAsString = ""
                }
            }
        }
        return sum
    }

    private fun containsSymbol(symbol: String): Boolean {
        with(symbol) {
            when {
                contains('#') -> return true
                contains('*') -> return true
                contains('$') -> return true
                contains('+') -> return true
                contains('?') -> return true
                contains('%') -> return true
                contains('&') -> return true
                contains('/') -> return true
                contains('=') -> return true
                contains('-') -> return true
                contains('@') -> return true
                contains('-') -> return true
                else -> return false
            }
        }
    }

    private fun getValues(): MutableList<MutableList<String>> {
        val list = mutableListOf<MutableList<String>>()
        for ((index, line) in input.withIndex()) {
            for (value in line.split("")) {
                if (list.size <= index) {
                    list.add(mutableListOf(value))
                } else {
                    list[index].add(value)
                }
            }
        }
        return list
    }

}