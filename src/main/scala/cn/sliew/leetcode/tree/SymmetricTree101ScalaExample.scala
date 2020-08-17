package cn.sliew.leetcode.tree

/**
  * 101.Symmetric Tree easy
  */
object SymmetricTree101ScalaExample {

    def isSymmetric(root: TreeNode): Boolean = {
        root == null || isSymmetric(root.left, root.right)
    }

    def isSymmetric(left: TreeNode, right: TreeNode): Boolean = (left, right) match {
        case (null, null) => true
        case (null, _) => false
        case (_, null) => false
        case (left, right) => if (left.value == right.value) isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)
        else false
    }

    def main(args: Array[String]): Unit = {

    }

}
