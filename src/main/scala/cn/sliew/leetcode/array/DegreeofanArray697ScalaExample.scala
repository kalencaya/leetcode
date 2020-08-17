package cn.sliew.leetcode.array

/**
  * 697. Degree of an Array easy
  */
object DegreeofanArray697ScalaExample {
    def findShortestSubArray(nums: Array[Int]): Int = {
        if (nums == null || nums.length == 0) {
            return 0
        }
        if (nums.length == 1) {
            return 1
        }
        val min = nums.min
        val max = nums.max
        val bucket: Array[(Int, Int, Int)] = new Array(max - min + 1)
        for ((num, index) <- nums.zipWithIndex) {
            val tuple = bucket(num - min)
            if (tuple == null) {
                bucket(num - min) = (1, index, index)
            } else {
                val newTuple = Tuple3.apply(tuple._1 + 1, tuple._2, index)
                bucket(num - min) = newTuple
            }
        }
        var longest = 1
        var maxSub = 1
        for ((count, first, last) <- bucket) {
            if (count > longest) {
                maxSub = last - first + 1
                longest = count
            } else if (count == longest) {
                maxSub = math.min(maxSub, last - first + 1)
            }
        }
        maxSub
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(1, 2, 2, 3, 1, 4, 2)
        val result = findShortestSubArray(nums)
        print(result)
    }
}
