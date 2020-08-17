package cn.sliew.leetcode.hashtable

import scala.collection.mutable.ArrayBuffer

/**
  * 350. Intersection of Two Arrays II easy
  * tags: Hash Table, Two Pointers, Binary Search, Sort
  */
object IntersectionofTwoArraysII350ScalaExample {

    def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return Array()
        }
        val result = new ArrayBuffer[Int]()
        val sorted1 = nums1.sorted
        val sorted2 = nums2.sorted
        var index1 = 0
        var index2 = 0
        while (index1 < sorted1.length && index2 < sorted2.length) {
            if (sorted1(index1) == sorted2(index2)) {
                result += sorted1(index1)
                index1 += 1
                index2 += 1
            } else if (sorted1(index1) > sorted2(index2)) {
                index2 += 1
            } else if (sorted1(index1) < sorted2(index2)) {
                index1 += 1
            }
        }
        result.toArray
    }

    def main(args: Array[String]): Unit = {
        val nums1 = Array(-2147483648,1,2,3)
        val nums2 = Array(1,-2147483648,-2147483648)
        val result = intersect(nums1, nums2)
        println(result.mkString("[", ",", "]"))
    }

}
