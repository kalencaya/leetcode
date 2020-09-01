package cn.sliew.leetcode.tree

import scala.collection.mutable

/**
  * 112. Path Sum easy
  */
object PathSum112ScalaExample {

    def hasPathSum(root: TreeNode, sum: Int): Boolean = {
        if (root == null) {
            return false
        }
        val resultMap = new mutable.HashMap[TreeNode, Int]()

        var current = List[TreeNode](root)
        resultMap.put(root, root.value)
        while (!current.isEmpty) {
            current.foreach(node => {
                if (node.left != null) {
                    resultMap.put(node.left, resultMap.getOrElse(node, 0) + node.left.value)
                }
                if (node.right != null) {
                    resultMap.put(node.right, resultMap.getOrElse(node, 0) + node.right.value)
                }
            })

            current = current.flatMap(node => node.right :: node.left :: Nil).filter(node => node != null)
        }

        resultMap.exists(entity => entity._1.left == null && entity._1.right == null && entity._2 == sum)
    }

    def main(args: Array[String]): Unit = {
    }

}
