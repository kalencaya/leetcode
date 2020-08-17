package cn.sliew.leetcode.hashtable

import scala.collection.mutable

/**
  * 349. Intersection of Two Arrays easy
  *
  * tags: Hash Table, Two Pointers, Binary Search, Sort
  */
object IntersectionofTwoArrays349ScalaExample {

    def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return Array()
        }
        val set = new mutable.HashSet[Int]()
        val sorted1 = nums1.sorted
        val sorted2 = nums2.sorted
        var index1 = 0
        var index2 = 0
        while (index1 < sorted1.length && index2 < sorted2.length) {
            val comparable = sorted1(index1) - sorted2(index2)
            if (comparable == 0) {
                set.add(sorted1(index1))
                index1 += 1
                index2 += 1
            } else if (comparable > 0) {
                index2 += 1
            } else if (comparable < 0) {
                index1 += 1
            }
        }
        set.toArray
    }

    def main(args: Array[String]): Unit = {
        val nums1 = Array(1, 2, 2, 1)
        val nums2 = Array(2, 2)
        val result = intersection(nums1, nums2)
        println(result.mkString("[", ",", "]"))
    }

}
