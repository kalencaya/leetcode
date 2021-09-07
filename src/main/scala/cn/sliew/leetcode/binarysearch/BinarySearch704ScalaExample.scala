package cn.sliew.leetcode.binarysearch

/**
  * 704. Binary Search
  */
object BinarySearch704ScalaExample {

    def search(nums: Array[Int], target: Int): Int = {
        binarySearch(0, nums.length - 1, nums, target)
    }

    private def binarySearch(start: Int, end: Int, nums: Array[Int], target: Int): Int = {
        if (start > `end`) {
            return -1
        }

        val middle = (start + `end`) / 2
        if (nums(middle) == target) {
            middle
        } else if (nums(middle) < target) {
            binarySearch(middle + 1, end, nums, target)
        } else {
            binarySearch(start, middle - 1, nums, target)
        }
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(-1, 0, 3, 5, 9, 12)
        val target = 9
        val result = search(nums, target)
        println(result)
    }
}
