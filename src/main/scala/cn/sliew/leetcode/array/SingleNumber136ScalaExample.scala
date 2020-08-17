package cn.sliew.leetcode.array

/**
  * 136.Single Number easy
  */
object SingleNumber136ScalaExample {

  def singleNumber(nums: Array[Int]): Int = {
    return nums.foldLeft(0)((num, result) => num ^ result)
  }

  def singleNumber2(nums: Array[Int]): Int = {
    return nums.distinct.sum * 2 - nums.sum
  }


  def main(args: Array[String]): Unit = {
    val nums = Array(-1)
    val result = singleNumber(nums)
    println(result)
  }

}
