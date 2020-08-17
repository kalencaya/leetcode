package cn.sliew.leetcode.array

import scala.collection.mutable.ListBuffer

/**
  * 448 Find All Numbers Disappeared in an Array easy
  */
object FindAllNumbersDisappearedinanArray448ScalaExample {

  def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
    val result = new ListBuffer[Int]()
    for (i <- 0 until nums.length){
      val num = nums(i)
      val index = math.abs(num) - 1
      if (nums(index) > 0){
        nums(index) = -nums(index)
      }
    }

    for (i <- 0 until nums.length){
      if (nums(i) > 0){
        result += (i + 1)
      }
    }
    return result.toList
  }

  def main(args: Array[String]): Unit = {
    val nums: Array[Int] = Array(4,3,2,7,8,2,3,1)
    val result = findDisappearedNumbers(nums)
    println(result.mkString(", "))
  }
}
