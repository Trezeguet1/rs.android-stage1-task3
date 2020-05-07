package subtask2
import kotlin.math.roundToInt

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        //[6, 4] would return 2
        //[4, 4] would return 1
        //[4, 2] would return null

            var x :Int = 1
            val m = array[0]
            val n = array[1]
            for (i in 1..n) {
                x = (x * (n + 1 - i) / i)
                if (x == m){
                    return i
                }
            }
            return null
    }
}
