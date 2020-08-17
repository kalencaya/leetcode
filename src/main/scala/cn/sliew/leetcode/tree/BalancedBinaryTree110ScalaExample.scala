package cn.sliew.leetcode.tree

/**
  * 110. Balanced Binary Tree easy
  */
object BalancedBinaryTree110ScalaExample {

    def isBalanced(root: TreeNode): Boolean = {
        if (root == null) {
            return true
        }

        if (math.abs(height(root.left) - height(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right)
        }
        false
    }

    private def height(root: TreeNode): Int = root match {
        case null => 0
        case _ => 1 + math.max(height(root.left), height(root.right))
    }


    def main(args: Array[String]): Unit = {
        val nums = Array("3", "9", "20", "null", "null", "15", "7")
        val root = TreeNode.build(nums)
        val result = isBalanced(root)
        println(result)
    }

}
