package cn.sliew.leetcode.tree

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * 144. Binary Tree Preorder Traversal medium
  */
object BinaryTreePreorderTraversal144ScalaExample {

    def preorderTraversal(root: TreeNode): List[Int] = {
        val result = new ListBuffer[Int]()
        preorder(root, result)
        result.toList
    }

    def preorder(root: TreeNode, list: ListBuffer[Int]): Unit = {
        if (root == null) {
            return
        }
        list += root.value
        preorder(root.left, list)
        preorder(root.right, list)
    }

    def preorderTraversalIterative(root: TreeNode): List[Int] = {
        val result = new ListBuffer[Int]()
        val stack = new mutable.Stack[TreeNode]()

        var node = root
        while (node != null) {
            result += node.value
            if (node.right != null) {
                stack.push(node.right)
            }
            node = node.left
            if (node == null && !stack.isEmpty) {
                node = stack.pop()
            }
        }
        result.toList
    }



    def main(args: Array[String]): Unit = {
        val nums: Array[String] = Array("1", "null", "2", "3")
        val root = new TreeNode(1)
        root.right = new TreeNode(2)
        root.right.left = new TreeNode(3)
        val result = preorderTraversalIterative(root)
        println(result.mkString(", "))
    }

}
