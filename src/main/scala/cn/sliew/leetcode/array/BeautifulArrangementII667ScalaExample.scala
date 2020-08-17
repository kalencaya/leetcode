package cn.sliew.leetcode.array

import scala.collection.mutable

/**
  * 667. Beautiful Arrangement II medium
  */
object BeautifulArrangementII667ScalaExample {

    def constructArray(n: Int, k: Int): Array[Int] = {
        val nums: Array[Int] = (1 to n) toArray
        val permutations = permutaions(nums)
        uniqPerm(permutations, k)
    }

    def permutaions(nums: Array[Int]): Array[Array[Int]] = {
        val result = mutable.Buffer[Array[Int]]()
        permute(mutable.Buffer[Int](), nums, result)
        result.toArray
    }

    def permute(temp: mutable.Buffer[Int], nums: Array[Int], result: mutable.Buffer[Array[Int]]): Unit = {
        if (temp.length == nums.length) {
            result += temp.toArray
            return
        }
        for (num <- nums; if !temp.contains(num)) {
            temp += num
            permute(temp, nums, result)
            temp -= num
        }
    }

    def uniqPerm(permutations: Array[Array[Int]], k: Int): Array[Int] = {
        for (array <- permutations) {
            val set = mutable.Set[Int]()
            for (i <- 0 until array.length - 1) {
                set.add(math.abs(array(i) - array(i + 1)))
            }
            if (set.size == k) {
                return array
            }
        }
        null
    }


    def main(args: Array[String]): Unit = {
        val n = 5
        val k = 4
        val result = constructArray(n, k)
        println(result.mkString("[", ", ", "]"))
    }

}
