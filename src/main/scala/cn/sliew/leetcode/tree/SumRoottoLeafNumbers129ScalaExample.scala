package cn.sliew.leetcode.tree

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * 129. Sum Root to Leaf Numbers medium
  */
object SumRoottoLeafNumbers129ScalaExample {
    def sumNumbers(root: TreeNode): Int = {
        if (root == null) {
            return 0
        }
        val map = new mutable.HashMap[TreeNode, String]
        val list: ListBuffer[TreeNode] = new ListBuffer[TreeNode]
        list += root
        map.put(root, root.value.toString)
        var result: Int = 0
        while (!list.isEmpty) {
            val node = list.remove(0)
            val value = map.get(node).get
            if (node.left == null && node.right == null) {
                result += value.toInt
            }
            if (node.left != null) {
                list += node.left
                map.put(node.left, value + node.left.value)
            }
            if (node.right != null) {
                list += node.right
                map.put(node.right, value + node.right.value)
            }
        }
        result
    }

    def main(args: Array[String]): Unit = {
        val root: TreeNode = new TreeNode(1)
        root.left = new TreeNode(2)
        root.right = new TreeNode(3)
        val result = sumNumbers(root)
        println(result)
    }
}
