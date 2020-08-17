package cn.sliew.leetcode.tree

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * 94.Binary Tree Inorder Traversal medium
  * Definition for a binary tree node.
  * class TreeNode(var _value: Int) {
  *   var value: Int = _value
  *   var left: TreeNode = null
  *   var right: TreeNode = null
  * }
  */
object BinaryTreeInorderTraversal94ScalaExample {

    def inorderTraversal(root: TreeNode): List[Int] = {
        val result = new ListBuffer[Int]()
        inorder(root, result)
        result.toList
    }

    def inorder(root: TreeNode, result: ListBuffer[Int]): Unit = {
        if (root == null) {
            return
        }
        inorder(root.left, result)
        result += root.value
        inorder(root.right, result)
    }

    def inorderIteratively(root: TreeNode): List[Int] = {
        val result = new ListBuffer[Int]()
        val stack = new mutable.ArrayStack[TreeNode]()
        var current = root
        while (current != null || !stack.isEmpty) {
            while (current != null) {
                stack.push(current)
                current = current.left
            }
            current = stack.pop()
            result += current.value
            current = current.right
        }
        result.toList
    }

    def main(args: Array[String]): Unit = {
        val root = new TreeNode(1)
        root.right = new TreeNode(2)
        root.right.left = new TreeNode(3)
        val result = inorderIteratively(root)
        println(result.mkString(", "))
    }
}
