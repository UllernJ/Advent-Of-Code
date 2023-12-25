package solutions

import utils.FileReader

class Day4 {
    private val input: List<String> = FileReader("day4.txt").getAllLines()
    private val games = input.map { game ->
        CardGame.of(game)
    }

    fun solutionPart1(): Int {
        val sum = games.sumOf { game ->
            game.calculatePointsPart1()
        }
        return sum
    }

    private data class CardGame(val winningNumbers: List<Int>, val numbers: List<Int>, private var points: Int = 0) {


        fun calculatePointsPart1(): Int {
            winningNumbers.forEach { winningNumber ->
                if (numbers.contains(winningNumber)) {
                    if (points == 0) {
                        points = 1
                    } else {
                        points *= 2
                    }
                }
            }
            return points
        }

        companion object {
            fun of(input: String): CardGame {
                val winningNumbers = mutableListOf<Int>()
                val numbers = mutableListOf<Int>()

                val data = input.substringAfter(":")
                val split = data.split("|")
                val numbersString = split[0].split(" ")
                val winningNumbersString = split[1].split(" ")
                numbersString.forEach {
                    if (it.toIntOrNull() != null) {
                        numbers.add(it.toInt())
                    }
                }
                winningNumbersString.forEach {
                    if (it.toIntOrNull() != null) {
                        winningNumbers.add(it.toInt())
                    }
                }
                return CardGame(winningNumbers, numbers)
            }
        }
    }
}