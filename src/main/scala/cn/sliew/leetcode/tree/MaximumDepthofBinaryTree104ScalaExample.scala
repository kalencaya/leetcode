package cn.sliew.leetcode.tree

/**
  * 104. Maximum Depth of Binary Tree easy
  */
object MaximumDepthofBinaryTree104ScalaExample {

    def maxDepth(root: TreeNode): Int = root match {
        case null => 0
        case _ => 1 + math.max(maxDepth(root.left), maxDepth(root.right))
    }

    def main(args: Array[String]): Unit = {

    }

}
