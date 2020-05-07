package subtask4
import java.util.*

class SquareDecomposer {

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        //Given a positive integral number n, return a strictly increasing sequence (array) of numbers, so that the sum of the squares is equal to n².
        val resStack = emptyList<Long>().toMutableList()
        resStack.add(number.toLong())
        var goal : Long = 0
        while (resStack.isNotEmpty()) {
            val current :Long = resStack[resStack.lastIndex];
            resStack.removeAt(resStack.lastIndex);
            goal += current * current;
            for (i in (current - 1) downTo 0) {
                val iMul:Long = (i * i)
                if (goal - iMul >= 0) {
                    resStack.add(i)
                    goal -= iMul
                }
                if (goal == 0L) {
                    val results = Array(resStack.size) { i -> resStack[i].toInt() }
                    Arrays.sort(results)
                    return results
                }
            }
        }
        return null
    }
}
