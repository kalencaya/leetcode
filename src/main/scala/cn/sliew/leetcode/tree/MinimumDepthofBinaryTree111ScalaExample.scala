package cn.sliew.leetcode.tree

/**
  * 111. Minimum Depth of Binary Tree easy
  */
object MinimumDepthofBinaryTree111ScalaExample {

    def minDepth(root: TreeNode): Int = root match {
        case null => 0
        case _ => {
            if (root.left != null && root.right != null) {
                1 + math.min(minDepth(root.left), minDepth(root.right))
            } else if (root.left != null && root.right == null) {
                1 + minDepth(root.left)
            } else if(root.left == null && root.right != null) {
                1 + minDepth(root.right)
            } else {
                1
            }
        }
    }

    def main(args: Array[String]): Unit = {
    }

}
