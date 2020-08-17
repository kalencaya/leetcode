package cn.sliew.leetcode.array

/**
  * 561. Array Partition I easy
  */
object ArrayPartitionI561ScalaExample {

  def arrayPairSum(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    var sum = 0
    for (i <- 0 until (sorted.length, 2)) {
      sum = sum + sorted(i)
    }
    return sum
  }

  /**
    * 使用计数排序优化
    * 数字的取值范围是-10000 - 10000。因此需要建立一个数组大小为10000 - （-10000) + 1大小的排序桶来统计
    * 确定数组元素在排序桶的位置为Array(i) - (-10000)。不停累加
    */

  def arrayPairSum2(nums: Array[Int]): Int = {
    val min = -10000;
    val max = 10000;
    val sortCount: Array[Int] = new Array[Int](max - min + 1);
    for (num <- nums) {
      sortCount(num - min) = sortCount(num - min) + 1
    }

    var sum = 0
    var odd: Boolean = true
    for (i <- 0 until sortCount.length) {
      while (sortCount(i) > 0) {
        if (odd) {
          sum = sum + i + min
        }

        odd = !odd
        sortCount(i) = sortCount(i) - 1
      }
    }
    return sum
  }

  def arrayPairSum3(nums: Array[Int]): Int = {
    scala.util.Sorting.quickSort(nums)
    var sum = 0
    var i = nums.length - 2
    while (i >= 0) {
      sum += nums(i)
      i -= 2
    }
    return sum
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(1, 4, 3, 2)
    val result = arrayPairSum2(nums)
    println(result)
  }

}
