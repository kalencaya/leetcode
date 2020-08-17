package cn.sliew.leetcode.array

object FindtheDuplicateNumber287ScalaExample {
  def findDuplicate(nums: Array[Int]): Int = {
    var tortoise: Int = nums(0)
    var hare: Int = nums(0)

    do {
      tortoise = nums(tortoise)
      hare = nums(nums(hare))
    } while (tortoise != hare)

    var ptr1: Int = nums(0)
    var ptr2: Int = tortoise
    while (ptr1 != ptr2){
      ptr1 = nums(ptr1)
      ptr2 = nums(ptr2)
    }

    ptr1
  }

  def main(args: Array[String]): Unit = {
    val nums: Array[Int] = Array(1, 3, 4, 2, 2)
    val result: Int = findDuplicate(nums)
    println(result)
  }

}
