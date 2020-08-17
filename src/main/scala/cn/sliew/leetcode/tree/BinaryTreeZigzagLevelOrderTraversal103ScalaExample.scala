package cn.sliew.leetcode.tree

import scala.collection.mutable.ListBuffer
import scala.language.postfixOps

/**
  * 103. Binary Tree Zigzag Level Order Traversal medium
  */
object BinaryTreeZigzagLevelOrderTraversal103ScalaExample {

    def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
        val result = new ListBuffer[List[Int]]
        if (root == null) {
            return result.toList
        }

        val nodes = new ListBuffer[ListBuffer[TreeNode]]
        var current = new ListBuffer[TreeNode]
        var next = new ListBuffer[TreeNode]
        current += root
        while (!current.isEmpty) {
            for (node <- current) {
                if (node.left != null) {
                    next += node.left
                }
                if (node.right != null) {
                    next += node.right
                }
            }
            nodes += current
            current = next
            next = new ListBuffer[TreeNode]
        }

        var level = 1
        for (levels <- nodes) {
            if (level % 2 == 0) {
                result += levels.reverse.map(_.value).toList
            } else {
                result += levels.map(_.value).toList
            }
            level += 1
        }
        result.toList

    }

    def main(args: Array[String]): Unit = {
        val root = new TreeNode(3)
        root.left = new TreeNode(9)
        root.right = new TreeNode(20)
        root.right.left = new TreeNode(15)
        root.right.right = new TreeNode(7)
        val list = zigzagLevelOrder(root)
        println(list.mkString("[", ", ", "]"))


        val root2 = new TreeNode(1)
        root2.left = new TreeNode(2)
        root2.right = new TreeNode(3)
        root2.left.left = new TreeNode(4)
        root2.right.right = new TreeNode(5)
        val list2 = zigzagLevelOrder(root2)
        println(list2.mkString("[", ", ", "]"))

        val list3 = zigzagLevelOrder(null)
        println(list3)
    }

}
