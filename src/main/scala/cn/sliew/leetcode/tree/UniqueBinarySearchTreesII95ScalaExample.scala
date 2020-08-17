package cn.sliew.leetcode.tree

import scala.collection.mutable.ListBuffer
import scala.language.postfixOps

/**
  * 95. Unique Binary Search Trees II medium
  */
object UniqueBinarySearchTreesII95ScalaExample {

    def generateTrees(n: Int): List[TreeNode] = {
        if (n == 0) {
            return List()
        }
        g((1 to n) toArray)
    }

    def g(nums: Array[Int]): List[TreeNode] = {
        if (nums == null || nums.length == 0) {
            return List(null)
        }
        if (nums.length == 1) {
            return List(new TreeNode(nums(0)))
        }
        nums.flatMap(f(_, nums)).toList
    }

    def f(i: Int, nums: Array[Int]): List[TreeNode] = {
        val result = new ListBuffer[TreeNode]()
        for(left <- g(nums.filter(_ < i)); right <- g(nums.filter(_ > i))){
            val root = new TreeNode(i)
            root.left = left
            root.right = right
            result += root
        }
        result.toList
    }


    def main(args: Array[String]): Unit = {
        val n = 1
        val result = generateTrees(n)
        result.foreach(root => {
            println(BinaryTreeInorderTraversal94ScalaExample.inorderTraversal(root))
        })
    }

}
