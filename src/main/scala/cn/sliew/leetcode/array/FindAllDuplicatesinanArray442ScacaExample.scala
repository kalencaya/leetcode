package cn.sliew.leetcode.array

import scala.collection.mutable.ListBuffer

/**
  * 442 Find All Duplicates in an Array medium
  */
object FindAllDuplicatesinanArray442ScacaExample {
  def findDuplicates(nums: Array[Int]): List[Int] = {
    val result = new ListBuffer[Int]()
    for (i <- 0 until nums.length){
      val num = nums(i)
      val index = math.abs(num) - 1
      if (nums(index) < 0){
        result += math.abs(num)
      } else {
        nums(index) = -nums(index)
      }
    }
    return result.toList
  }


  def main(args: Array[String]): Unit = {
    val nums: Array[Int] = Array(4, 3, 2, 7, 8, 2, 3, 1)
    val result = findDuplicates(nums)
    println(result.mkString(", "))
  }

}
