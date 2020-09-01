package cn.sliew.leetcode.tree

import scala.collection.mutable.ListBuffer
import scala.language.postfixOps

/**
  * 107. Binary Tree Level Order Traversal II easy
  */
object BinaryTreeLevelOrderTraversalII107ScalaExample {

    def levelOrderBottom(root: TreeNode): List[List[Int]] = {
        val result = new ListBuffer[List[Int]]
        if (root == null) {
            return result.toList
        }
        var current = List[TreeNode](root)
        while (!current.isEmpty) {
            result += current.map(_.value)
            current = current.flatMap(node => node.left :: node.right :: Nil).filter(node => node != null)
        }
        result.reverse.toList
    }

    def main(args: Array[String]): Unit = {
    }

}
