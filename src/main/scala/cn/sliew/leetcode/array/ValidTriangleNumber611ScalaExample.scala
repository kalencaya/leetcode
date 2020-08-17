package cn.sliew.leetcode.array

/**
  * 611.Valid Triangle Number medium
  */
object ValidTriangleNumber611ScalaExample {

    def triangleNumber(nums: Array[Int]): Int = {
        var result = 0
        val sorted = nums.sorted
        for (i <- 0 until sorted.length - 2; j <- i until sorted.length - 1; k <- j until sorted.length; if i != j && j != k) {
            if (sorted(i) + sorted(j) > sorted(k)) {
                result += 1
            }
        }
        result
    }

    def main(args: Array[String]): Unit = {
        val nums: Array[Int] = Array(2, 2, 3, 4)
        val result = triangleNumber(nums)
        println(result)
    }

}
