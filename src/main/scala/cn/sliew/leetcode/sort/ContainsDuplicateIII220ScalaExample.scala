package cn.sliew.leetcode.sort

/**
  * 220. Contains Duplicate III medium
  * tags: Sort, OrderedMap
  */
object ContainsDuplicateIII220ScalaExample {

    def containsNearbyAlmostDuplicate(nums: Array[Int], k: Int, t: Int): Boolean = {
        if (nums == null || nums.length <= 1) {
            return false
        }
        for (i <- 0 until nums.length - 1; j <- i + 1 until nums.length; if (j - i) <= k) {
            if (math.abs(nums(i).toLong - nums(j).toLong) <= t) {
                return true
            }
        }
        false
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(-1,2147483647)
        val k = 1
        val t = 2147483647
        val result = containsNearbyAlmostDuplicate(nums, k, t)
        println(result)
    }

}
