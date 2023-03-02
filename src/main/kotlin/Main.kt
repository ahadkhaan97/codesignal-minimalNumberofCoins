fun main() {
    print(solution(mutableListOf(1, 5, 10, 100), 239))
}

fun solution(coins: MutableList<Int>, price: Int): Int {
    var coinsCount = 0
    var spent = 0
    for (i in coins.size - 1 downTo 0) {
        val remainder = (price - spent) % coins[i]
        if (remainder == 0) {
            coinsCount += (price - spent) / coins[i]
            break
        }
        val currSpent = (price - spent - remainder) / coins[i]
        spent += ((price - spent) - remainder)
        coinsCount += currSpent
    }
    return coinsCount
}
