package cn.sliew.leetcode.array

/**
  * 122. Best Time to Buy and Sell Stock II easy
  * tags: Array, Greedy
  */
object BestTimetoBuyandSellStockII122ScalaExample {

    def maxProfit(prices: Array[Int]): Int = {
        if (prices == null || prices.length <= 1) {
            return 0
        }
        if (prices.length == 2) {
            if (prices(0) >= prices(1)) {
                return 0
            } else {
                return prices(1) - prices(0)
            }
        }

        var valley = 0
        var peak = 0
        var index = 0
        var sum = 0
        while (index < prices.length - 1) {
            while (index < prices.length - 1 && prices(index) >= prices(index + 1)) {
                index += 1
            }
            valley = prices(index)
            while (index < prices.length - 1 && prices(index) < prices(index + 1)) {
                index += 1
            }
            peak = prices(index)
            sum += peak - valley
        }
        sum
    }

    def main(args: Array[String]): Unit = {
        val prices = Array(7, 1, 5, 3, 6, 4)
        val result = maxProfit(prices)
        println(result)
    }
}
