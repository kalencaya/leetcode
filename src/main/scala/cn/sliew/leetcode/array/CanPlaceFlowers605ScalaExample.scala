package cn.sliew.leetcode.array

/**
  * 605.Can Place Flowers easy
  */
object CanPlaceFlowers605ScalaExample {

    def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
        if (flowerbed.length == 1 && n == 1 && flowerbed(0) == 0) {
            return true
        }
        var index = 0
        for (i <- flowerbed.indices; if index < n && flowerbed(i) == 0) {
            if ((i == 0 || flowerbed(i - 1) == 0)
                && (i == flowerbed.length - 1 || flowerbed(i + 1) == 0)) {
                flowerbed(i) = 1
                index += 1
            }
        }
        index == n
    }

    /**
      * count代表2个1之间0的长度，则每段连续的0可以放置的花为(count - 1) / 2
      * 对于开头和结尾，它的两端只有1个1，此时对于连续的0，它需要的计算公式为 count / 2
      * 那么就需要在for循环中判断是否是头部或尾部节点，替换使用计算公式。
      * 但是通过将count初始值设置为1，巧妙地避免了这个问题。
      */
    def canPlaceFlowers2(flowerbed: Array[Int], n: Int): Boolean = {
        var count = 1
        var result = 0
        for (i <- flowerbed.indices) {
            if (flowerbed(i) == 0) {
                count += 1
            } else {
                count += 1
                result += (count - 1) / 2
            }
        }
        if (count != 0) {
            result += count / 2
        }
        result >= n
    }

    def main(args: Array[String]): Unit = {
        val flowerbed: Array[Int] = Array(0, 0, 1, 0, 0)
        val n = 1
        val result = canPlaceFlowers2(flowerbed, n)
        println(result)
    }

}
