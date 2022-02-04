fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var buyingPrice = Int.MAX_VALUE
    for (currentStockPrice in prices) {
        maxProfit = kotlin.math.max(currentStockPrice - buyingPrice, maxProfit)
        buyingPrice = kotlin.math.min(buyingPrice, currentStockPrice)
    }
    return maxProfit
}

fun main() {
    print(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
}