package cn.sliew.leetcode.array

/**
  * 566. Reshape the Matrix easy
  */
object ReshapetheMatrix566ScalaExample {

    def matrixReshape(nums: Array[Array[Int]], r: Int, c: Int): Array[Array[Int]] = {
        val count = nums.length * nums(0).length
        if (r * c != count || r > count || c > count) {
            return nums
        }

        val result: Array[Array[Int]] = Array.ofDim(r, c)
        var index: Int = 0
        var row = 0
        var column = 0
        for (i <- 0 until nums.length; j <- 0 until nums(i).length) {
            row = index / c
            column = index % c
            result(row)(column) = nums(i)(j)
            index += 1
        }
        result
    }

    def main(args: Array[String]): Unit = {
        val nums: Array[Array[Int]] = Array(
            Array(1, 2),
            Array(3, 4)
        )
        val r = 1
        val c = 4
        val result = matrixReshape(nums, r, c)
        result.foreach(arr => println(arr.mkString(", ")))
    }

}
