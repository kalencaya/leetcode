package cn.sliew.leetcode.array

/**
  * 532.K-diff Pairs in an Array easy
  */
object KdiffPairsinanArray532ScalaExample {

  def findPairs(nums: Array[Int], k: Int): Int = {
    val copy = nums.sorted
    val n = nums.length
    var count = 0
    var i = 0
    var j = 0
    while (i < n){
      //对j去重
      j = math.max(j, i + 1)
      while (j < n && copy(j) - copy(i) < k){
        j += 1
      }
      if (j < n && copy(j) - copy(i) == k){
        count += 1
      }
      //对i去重
      while (i < n - 1 && copy(i) == copy(i + 1)){
        i += 1
      }

      i += 1
    }
    return count
  }

  def main(args: Array[String]): Unit = {
    val nums: Array[Int] = Array(1, 1, 1, 1, 1)
    val k: Int = 0
    val result = findPairs(nums, k)
    println(result)
  }
}
