package cn.sliew.leetcode.array

/**
  * 565. Array Nesting medium
  */
object ArrayNesting565ScalaExample {

    /**
      * 超时
      */
    def arrayNesting(nums: Array[Int]): Int = {
        var longest = 0
        val set = collection.mutable.HashSet[Int]()
        for (i <- nums.indices) {
            if (set.add(nums(i))) {
                var temp = nums(i)
                while (set.add(nums(temp))) {
                    temp = nums(temp)
                }
            }
            longest = math.max(longest, set.size)
            set.clear()
        }

        longest
    }

    /**
      * 记录已经处理过的循环
      */
    def arrayNesting2(nums: Array[Int]): Int = {
        var longest = 0
        val visited: Array[Boolean] = new Array[Boolean](nums.length)
        for (i <- nums.indices) {
            var count = 0
            if (!visited(i)) {
                var next = nums(i)
                do {
                    next = nums(next)
                    count += 1
                    visited(next) = true
                } while (next != nums(i))
                longest = math.max(longest, count)
            }
        }

        longest
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(5, 4, 0, 3, 1, 6, 2)
        val result = arrayNesting2(nums)
        println(result)
    }
}
