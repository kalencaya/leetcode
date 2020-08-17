package cn.sliew.leetcode.array

/**
  * 137.Single Number II medium
  */
object SingleNumberII137ScalaExample {

  def singleNumber(nums: Array[Int]): Int = {
    var result = 0
    for (num <- nums){
      result = (~result) ^ num
    }
    return result
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(2, 2, 3, 2)
    val result = singleNumber(nums)
    println(result)
//    test
  }

  def test = {
    val a = 10;
    val b = 10;
    println((~a) & (~a) & (~b))
  }
}
