package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {

}

// Randoms의 APi의 pickUniqueNumbersInRange 사용법 (.pickNumberInRange 사용하여 구현해야되서 주석 처리)
// fun getRandomNumbers(randomStartNumber: Int, randomEndNumber: Int, randomsLength: Int): List<Int> {
//    return Randoms.pickUniqueNumbersInRange(randomStartNumber, randomEndNumber, randomsLength)
// }

fun getRandomNumbers(randomStartNumber: Int = 1, randomEndNumber: Int = 9, randomsLength: Int = 3): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < randomsLength) {
        val randomNumber = Randoms.pickNumberInRange(randomStartNumber, randomEndNumber)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun readInputString(): String {
    return Console.readLine()

}

fun validateInputString(
    inputNumbers: String,
    stringLengthToSpecify: Int = 3,
    inputStartNumber: Int = 1,
    inputEndNumber: Int = 9
): MutableList<Int> {
    val verifiedNumbers = mutableListOf<Int>()
    val inputNumbers = inputNumbers.toCharArray()
    inputNumbers.map { number ->
        requireNotNull(number.digitToIntOrNull()) { "잘못된 값이 입력되어 애플리케이션이 종료됩니다." }
        require(
            (inputStartNumber..inputEndNumber).contains(number.digitToInt())
        ) { "입력 가능한 수 외에 다른수가 입력되아 애플리케이션이 종료됩니다." }
        verifiedNumbers.add(number.digitToInt())
    }
    require(inputNumbers.size == stringLengthToSpecify) { "한자릿수 ${stringLengthToSpecify}개를 입력하지 않아 애플리케이션이 종료됩니다." }
    require(inputNumbers.distinct().size == stringLengthToSpecify) { "중복된 숫자가 입력되어 애플리케이션이 종료됩니다." }

    return verifiedNumbers
}






