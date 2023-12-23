package solutions

import utils.FileReader
import java.util.Stack

class Day1 {
    private val input: List<String> = FileReader().getAllLines("day1.txt")
    private var totalValue: Int = 0;
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
        return totalValue;
    }
}