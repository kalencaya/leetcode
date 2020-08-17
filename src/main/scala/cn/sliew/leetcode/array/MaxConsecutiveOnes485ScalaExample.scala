package cn.sliew.leetcode.array

/**
  * 485.Max Consecutive Ones easy
  */
object MaxConsecutiveOnes485ScalaExample {

  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    val n = nums.length
    var max: Int = 0
    var count: Int = 0
    for (i <- 0 until n){
      if (nums(i) == 1){
        count += 1
      } else {
        max = math.max(max, count)
        count = 0
      }
    }
    return math.max(max, count)
  }

  def main(args: Array[String]): Unit = {
    val nums: Array[Int] = Array(1, 1, 0, 1, 1, 1)
    val result = findMaxConsecutiveOnes(nums)
    println(result)
  }
}
