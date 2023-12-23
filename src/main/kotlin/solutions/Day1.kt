package solutions

import utils.FileReader
import java.util.Stack

class Day1 {
    private val input: List<String> = FileReader().getAllLines("day1.txt")
    private var totalValue: Int = 0;

    //Task 1
    fun calculate(): Int {
        input.forEach { value ->
            val nums = Stack<Int>();
            val arr = value.toCharArray()
            arr.forEach { value ->
                if (value.isDigit()) {
                    nums.push(value.digitToInt())
                }
            }
            totalValue += if (nums.size == 1) {
                nums.pop() * 11
            } else {
                nums.firstElement() * 10 + nums.lastElement()
            }
        }
        return totalValue
    }

    //Task 2
    fun calculateTask2(): Int {
        input.forEach { value ->
            val nums = Stack<Int>();
            val arr = value.toCharArray()
            val currentString: StringBuilder = StringBuilder();
            arr.forEach { value ->
                if (value.isDigit()) {
                    nums.push(value.digitToInt())
                }
                currentString.append(value)

                val fetchedNumber = stringToNumber(currentString.toString())
                if (fetchedNumber != 0) {
                    currentString.clear()
                    nums.add(fetchedNumber)
                }
            }

            totalValue += if (nums.size == 1) {
                nums.pop() * 11
            } else {
                nums.firstElement() * 10 + nums.lastElement()
            }
        }
        return totalValue
    }

    private fun stringToNumber(number: String): Int {
        with(number.lowercase()) {
            when {
                contains("one") -> return 1
                contains("two") -> return 2
                contains("three") -> return 3
                contains("four") -> return 4
                contains("five") -> return 5
                contains("six") -> return 6
                contains("seven") -> return 7
                contains("eight") -> return 8
                contains("nine") -> return 9
                else -> return 0
            }
        }
    }


}