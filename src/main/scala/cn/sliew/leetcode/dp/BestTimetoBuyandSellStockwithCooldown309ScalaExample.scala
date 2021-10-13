package cn.sliew.leetcode.dp

/**
  * 309. Best Time to Buy and Sell Stock with Cooldown medium
  */
object BestTimetoBuyandSellStockwithCooldown309ScalaExample {

    def maxProfit(prices: Array[Int]): Int = {
        if (prices.length == 1) {
            return 0
        }

        val mem = new Array[Int](prices.length)
        for (i <- 0 until mem.length) {
            mem(i) = -1
        }

        dfs(mem, None, 0, prices)


        mem(mem.length - 1)
    }

    private def dfs(mem: Array[Int], buy: Option[Int], current: Int, prices: Array[Int]): Int = {
        if (current >= prices.length) {
            return 0
        }
        if (mem(current) != -1) {
            return mem(current)
        }

        var profit = 0
        if (buy.isDefined) {
            val selled = dfs(mem, None, current + 2, prices) + (prices(current) - prices(buy.get))
            val notSelled = dfs(mem, buy, current + 1, prices)
            profit = math.max(selled, notSelled)
        } else {
            val buyed = dfs(mem, Some(current), current + 1, prices)
            val notBuyed = dfs(mem, None, current + 1, prices)
            profit = math.max(buyed, notBuyed)
        }

        mem(current) = profit
        profit
    }

    def main(args: Array[String]): Unit = {
        val prices = Array(1, 2, 3, 0, 2)
        val result = maxProfit(prices)
        println(result)
    }
}
