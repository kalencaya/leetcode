package cn.sliew.leetcode.tree

import java.util

import scala.collection.mutable.ListBuffer

/**
  * 145. Binary Tree Postorder Traversal medium
  * tags: Stack, Tree
  */
object BinaryTreePostorderTraversal145ScalaExample {

    def postorderTraversal(root: TreeNode): List[Int] = {
        val result: ListBuffer[Int] = new ListBuffer[Int]()
        postorderTraverse(root, result)
        result.toList
    }

    private def postorderTraverse(root: TreeNode, result: ListBuffer[Int]): Unit = {
        if (root == null) {
            return
        }

        if (root.left != null) {
            postorderTraverse(root.left, result)
        }

        if (root.right != null) {
            postorderTraverse(root.right, result)
        }
        result += root.value
    }

    def postorderTraversal2(root: TreeNode): List[Int] = {
        val result: ListBuffer[Int] = new ListBuffer[Int]()
        val stack: util.Stack[TreeNode] = new util.Stack()
        var node: TreeNode = root
        var pre: TreeNode = null
        while (!stack.isEmpty || node != null) {
            while (node != null) {
                stack.push(node)
                node = node.left
            }
            node = stack.pop()
            if (node.right != null && pre != node.right) {
                stack.push(node)
                node = node.right
            } else {
                result += node.value
                pre = node
                node = null
            }
        }


        result.toList
    }

    def main(args: Array[String]): Unit = {
        val root = new TreeNode(1)
        root.right = new TreeNode(2)
        root.right.left = new TreeNode(3)
        val result = postorderTraversal2(root)
        println(result.mkString("[", ",", "]"))
    }
}
