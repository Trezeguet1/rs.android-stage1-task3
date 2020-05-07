package subtask1
import kotlin.math.abs

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {

        //Input array [4, 0, 5, 20] should return "4x^3 + 5x + 20".

            if (numbers.isEmpty()) {
                return null
            }
            val maxInd = numbers.size
            val sb = StringBuilder()
            sb.append("");
            for (index in numbers.indices) {
                val sign = if (numbers[index] >= 0) "+" else "-"
                val abs :String = if (abs(numbers[index]) == 1) "" else (abs(numbers[index])).toString()
                if (numbers[index] == 0) {
                    continue
                }
                when {
                    maxInd - index - 1 > 1 -> {
                        sb.append(" ").append(sign).append(" ").append(abs).append("x^")
                            .append(maxInd - index - 1)
                    }
                    maxInd - index - 1 == 1 -> {
                        sb.append(" ").append(sign).append(" ").append(abs).append("x")
                    }
                    else -> { //(maxInd - index - 1 == 0)
                        sb.append(" ").append(sign).append(" ").append(abs)
                    }
                }
            }
            var result = sb.toString();
            result = if (result.startsWith(" +")){
                result.substring(3)
            } else {
                result.substring(1)
            }

            return result
    }
}
