package cn.sliew.leetcode.tree

import scala.collection.mutable.ListBuffer

/**
  * 199. Binary Tree Right Side View medium
  * tags: Tree, Depth-first-Search, Breadth-first-Search
  */
object BinaryTreeRightSideView199ScalaExample {

    def rightSideView(root: TreeNode): List[Int] = {
        val list : ListBuffer[Int] = new ListBuffer[Int]()
        if (root == null) {
            return list.toList
        }
        val temp : ListBuffer[TreeNode] = new ListBuffer[TreeNode]()
        temp.append(root, null)
        while (!temp.isEmpty) {
            val node = temp.remove(0)

            if (node != null) {
                if (node.left != null) {
                    temp.append(node.left)
                }
                if (node.right != null) {
                    temp.append(node.right)
                }
            }

            if (!temp.isEmpty) {
                if (node == null) {
                    temp.append(null)
                } else {
                    if (temp.head == null) {
                        list.append(node.value)
                    }
                }

            }
        }
        list.toList
    }


    def main(args: Array[String]): Unit = {
        val input: Array[Any] = Array()
        val root = TreeNode.build(input)
        val result = rightSideView(root)
        println(result.mkString("[", ",", "]"))
    }


}
