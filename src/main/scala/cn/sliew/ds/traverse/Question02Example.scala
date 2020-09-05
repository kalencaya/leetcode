package cn.sliew.ds.traverse

/**
  * 递归判断数组是否有序
  */
object Question02Example {

    def solution(nums: Array[Int]): Boolean = {
        if (nums.length == 1) {
            return true
        }
        arraySorted(nums, nums.length)
    }

    def arraySorted(nums: Array[Int], index: Int) : Boolean = {
        if (index < 2) {
            return true
        }
        if (nums(index - 1) <= nums(index - 2)) {
            false
        } else {
            arraySorted(nums, index - 1)
        }
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(1, 2, 3, 5, 4)
        val result = solution(nums)
        println(result)
    }

}
