package cn.sliew.leetcode.tree

import scala.collection.mutable

/**
  * 230. Kth Smallest Element in a BST medium
  * tags: Binary Search, Tree
  */
object KthSmallestElementinaBST230ScalaExample {

    val map: mutable.HashMap[TreeNode, Int] = new mutable.HashMap()

    def kthSmallest(root: TreeNode, k: Int): Int = {
        if (root == null || k < 1) {
            return Int.MinValue
        }
        if (size(root) < k) {
            return Int.MinValue
        }
        if (size(root.left) >= k) {
            return kthSmallest(root.left, k)
        }
        if (size(root.left) == k - 1) {
            return root.value
        }
        if (size(root.left) < k - 1) {
            return kthSmallest(root.right, k - size(root.left) - 1)
        }
        Int.MinValue
    }

    private def size(root: TreeNode): Int = {
        if (root == null) {
            return 0
        }
        var option = map.get(root)
        if (option.isEmpty) {
            map.put(root, size(root.left) + size(root.right) + 1)
            option = map.get(root)
        }
        option.get
    }

    def main(args: Array[String]): Unit = {
        val ints: Array[Any] = Array(3,1,4,null,2)
        val root = TreeNode.build(ints)
        val k = 1
        val result = kthSmallest(root, k)
        println(result)
    }



}
