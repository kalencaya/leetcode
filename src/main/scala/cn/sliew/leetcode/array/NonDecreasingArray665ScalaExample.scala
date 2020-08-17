package cn.sliew.leetcode.array

/**
  * 665.Non-decreasing Array easy
  */
object NonDecreasingArray665ScalaExample {

    def checkPossibility(nums: Array[Int]): Boolean = {
        for (i <- nums.indices) {
            if (i < nums.length - 1 && nums(i) > nums(i + 1)) {
                if (i == 0) {
                    nums(i) = Int.MinValue
                    return isSorted(nums)
                } else {
                    val backNums = moveBack(nums, i)
                    val forthNums = moveForth(nums, i)
                    return isSorted(backNums) || isSorted(forthNums)
                }
            }
        }
        true
    }

    def moveBack(nums: Array[Int], i: Int): Array[Int] = {
        val copy: Array[Int] = new Array(nums.length)
        nums.copyToArray(copy)
        var j = i
        while (j < copy.length - 1 && copy(j) > copy(j + 1)) {
            val temp = copy(j)
            copy(j) = copy(j + 1)
            copy(j + 1) = temp
            j += 1
        }
        return copy
    }

    def moveForth(nums: Array[Int], i: Int): Array[Int] = {
        val copy: Array[Int] = new Array(nums.length)
        nums.copyToArray(copy)
        var j = i
        while (j >= 0 && copy(j) > copy(j + 1)) {
            val temp = copy(j)
            copy(j) = copy(j + 1)
            copy(j + 1) = temp
            j -= 1
        }
        return copy
    }

    def isSorted(nums: Array[Int]): Boolean = {
        for (i <- nums.indices) {
            if (i < nums.length - 1 && nums(i) > nums(i + 1)) {
                return false
            }
        }
        true
    }

    def checkPossibility2(nums: Array[Int]): Boolean = {

        true
    }

    def main(args: Array[String]): Unit = {
        val nums: Array[Int] = Array(2, 3, 3, 2, 4)
        val result = checkPossibility2(nums)
        println(result)
    }
}
