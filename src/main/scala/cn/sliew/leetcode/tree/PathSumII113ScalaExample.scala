package cn.sliew.leetcode.tree

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.language.postfixOps

/**
  * 113. Path Sum II medium
  */
object PathSumII113ScalaExample {

    /**
      * 深度优先遍历
      */
    def pathSum(root: TreeNode, sum: Int): List[List[Int]] = {
        val result = new ListBuffer[List[Int]]
        val tmp = new ListBuffer[Int]
        dfs(root, sum, tmp, result)
        result.toList
    }

    private def dfs(root: TreeNode, sum: Int, list: ListBuffer[Int], listBuffer: ListBuffer[List[Int]]): Unit = {
        if (root == null) {
            return
        }
        if (root.left == null && root.right == null && sum == root.value) {
            list += root.value
            listBuffer += list.toList
        }

        if (root.left != null) {
            val ints = new ListBuffer[Int]
            list.copyToBuffer(ints)
            ints += root.value
            dfs(root.left, sum - root.value, ints, listBuffer)
        }

        if (root.right != null) {
            val ints = new ListBuffer[Int]
            list.copyToBuffer(ints)
            ints += root.value
            dfs(root.right, sum - root.value, ints, listBuffer)
        }
    }

    private def bdsWithQueue(root: TreeNode, sum: Int): List[List[Int]] = {
        if (root == null) {
            return List.empty
        }
        val result = new ListBuffer[List[Int]]
        val queue = new mutable.Queue[(TreeNode, Int, ListBuffer[Int])]()
        queue.enqueue((root, root.value, new ListBuffer[Int]() += root.value))
        while (!queue.isEmpty) {
            val option = queue.dequeue()
            if (option._1.left == null && option._1.right == null && option._2 == sum) {
                result += option._3.toList
            }
            if (option._1.left != null) {
                val ints = new ListBuffer[Int]
                option._3.copyToBuffer(ints)
                ints += option._1.left.value
                queue.enqueue((option._1.left, option._2 + option._1.left.value, ints))
            }
            if (option._1.right != null) {
                val ints = new ListBuffer[Int]
                option._3.copyToBuffer(ints)
                ints += option._1.right.value
                queue.enqueue((option._1.right, option._2 + option._1.right.value, ints))
            }
        }
        result.toList
    }

    private def dfsWithStack(root: TreeNode, sum: Int): List[List[Int]] = {
        if (root == null) {
            return List.empty
        }
        val result = new ListBuffer[List[Int]]
        val stack = new mutable.ArrayStack[(TreeNode, Int, ListBuffer[Int])]()
        stack.push((root, root.value, new ListBuffer[Int] += root.value))
        while (!stack.isEmpty) {
            val tuple = stack.pop()
            val node = tuple._1
            val value = tuple._2
            val list = tuple._3
            if (node.left == null && node.right == null && value == sum) {
                result += list.toList
            }
            if (node.right != null) {
                val ints = new ListBuffer[Int]
                list.copyToBuffer(ints)
                ints += node.right.value
                stack.push((node.right, value + node.right.value, ints))
            }
            if (node.left != null) {
                val ints = new ListBuffer[Int]
                list.copyToBuffer(ints)
                ints += node.left.value
                stack.push((node.left, value + node.left.value, ints))
            }
        }
        result.toList
    }

    def main(args: Array[String]): Unit = {
        val root = new TreeNode(5)
        root.left = new TreeNode(4)
        root.right = new TreeNode(8)
        root.left.left = new TreeNode(11)
        root.left.left.left = new TreeNode(7)
        root.left.left.right = new TreeNode(2)
        root.right.left = new TreeNode(13)
        root.right.right = new TreeNode(4)
        root.right.right.left = new TreeNode(5)
        root.right.right.right = new TreeNode(1)
        val sum = 22
        val result = dfsWithStack(root, sum)
        result.foreach(list => println(list.mkString(", ")))
    }
}
