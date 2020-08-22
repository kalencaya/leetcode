package cn.sliew.leetcode.sort

/**
  * 179. Largest Number medium
  * tags: Sort
  */
object LargestNumber179ScalaExample {

    def largestNumber(nums: Array[Int]): String = {
        val ints = nums.sortWith(compare)
        if (ints(0) == 0) {
            "0"
        } else {
            ints.mkString("")
        }
    }

    private def compare(a: Int, b: Int): Boolean = {
        val aStr: String = a.toString + b.toString
        val bStr: String = b.toString + a.toString
        aStr.compareTo(bStr) > 0
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(0, 0)
        val result = largestNumber(nums)
        println(result)
    }
}
