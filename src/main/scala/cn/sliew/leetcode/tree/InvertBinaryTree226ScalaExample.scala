package cn.sliew.leetcode.tree

import scala.collection.mutable.ListBuffer

/**
  * 226. Invert Binary Tree easy
  * tags: Tree
  */
object InvertBinaryTree226ScalaExample {

    def invertTree(root: TreeNode): TreeNode = {
        if (root == null) {
            return root
        }
        val list: ListBuffer[Any] = new ListBuffer[Any]()
        val temp: ListBuffer[TreeNode] = new ListBuffer[TreeNode]()
        temp.append(root)
        while (!temp.isEmpty && temp.find(_ != null).isDefined) {
            val node = temp.remove(0)
            if (node != null) {
                temp.append(node.right, node.left)
                list.append(node.value)
            } else {
                list.append(null)
            }
        }
        TreeNode.build(list.toArray)
    }


    def main(args: Array[String]): Unit = {
        val ints: Array[Any] = Array(1, 4, 3, 2)
        val root = TreeNode.build(ints)
        val result = invertTree(root)
        val list = BinaryTreeLevelOrderTraversal102ScalaExample.levelOrder(result)
        println(list.mkString("[", ", ", "]"))
    }
}
