package cn.sliew.leetcode.tree

import scala.collection.mutable

/**
  * 173. Binary Search Tree Iterator medium
  * tags: Stack, Tree, Design
  */
object BinarySearchTreeIterator173ScalaExample {

    /**
      * 利用二叉搜索树的findKth实现这个功能
      */
    class BSTIterator(_root: TreeNode) {

        var root = _root

        var kth = 1

        val map: mutable.HashMap[TreeNode, Int] = new mutable.HashMap()

        /** @return the next smallest number */
        def next(): Int = {
            val result = findKth(root, kth)
            kth += 1
            result
        }

        private def findKth(root: TreeNode, kth: Int): Int = {
            if (root == null || kth < 1) {
                return Int.MinValue
            }
            if (size(root) < kth) {
                return Int.MinValue
            }
            if (size(root.left) >= kth) {
                return findKth(root.left, kth)
            }
            if (size(root.left) == kth - 1) {
                return root.value
            }
            if (size(root.left) < kth - 1) {
                return findKth(root.right, kth - size(root.left) - 1)
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

        /** @return whether we have a next smallest number */
        def hasNext(): Boolean = {
            size(root) >= kth
        }

    }


}
