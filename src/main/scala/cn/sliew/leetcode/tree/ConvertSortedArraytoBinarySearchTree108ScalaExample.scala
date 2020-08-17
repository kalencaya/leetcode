package cn.sliew.leetcode.tree

/**
  * 108. Convert Sorted Array to Binary Search Tree easy
  */
object ConvertSortedArraytoBinarySearchTree108ScalaExample {

    def sortedArrayToBST(nums: Array[Int]): TreeNode = {
        var root: TreeNode = null
        for (num <- nums) {
            root = insert(root, num)
        }
        root
    }

    private def insert(root: TreeNode, num: Int): TreeNode = {
        var node = root
        if (node == null) {
            return new TreeNode(num)
        }

        if (node.value < num) {
            node.right = insert(node.right, num)
            if (height(node.right) - height(node.left) >= 2) {
                if (node.right.value < num) {
                    node = rotateLeft(node)
                } else if (node.right.value > num) {
                    node.right = rotateRight(node.right)
                    node = rotateLeft(node)
                }
            }
        } else {
            node.left = insert(node.left, num)
            if (height(node.left) - height(node.right) >= 2) {
                if (node.left.value > num) {
                    node = rotateRight(node)
                } else if (node.left.value < num) {
                    node.left = rotateLeft(node.left)
                    node = rotateRight(node)
                }
            }
        }
        node
    }

    private def height(root: TreeNode): Int = root match {
        case null => 0
        case _ => 1 + math.max(height(root.left), height(root.right))
    }

    private def rotateLeft(root: TreeNode) : TreeNode = {
        val z = root.right
        root.right = z.left
        z.left = root
        z
    }

    private def rotateRight(root: TreeNode): TreeNode = {
        val z = root.left
        root.left = z.right
        z.right = root
        z
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(-10, -3, 0, 5, 9)
        val result = sortedArrayToBST(nums)
        val list = BinaryTreeLevelOrderTraversal102ScalaExample.levelOrder(result)
        println(list)
    }

}
