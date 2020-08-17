package cn.sliew.leetcode.tree

/**
  * 98. Validate Binary Search Tree medium
  */
object ValidateBinarySearchTree98ScalaExample {

    def isValidBST(root: TreeNode): Boolean = {
        if (root == null) {
            return true
        }
        checkSubTree(root, None, None)
    }


    def checkSubTree(root: TreeNode, lower: Option[Int], upper: Option[Int]): Boolean = {
        if (root == null) {
            return true
        }

        if (lower.isDefined && lower.get >= root.value) return false
        if (upper.isDefined && upper.get <= root.value) return false

        if (!checkSubTree(root.left, lower, Option.apply(root.value))) return false
        if (!checkSubTree(root.right, Option.apply(root.value), upper)) return false

        true
    }


    def main(args: Array[String]): Unit = {
        val root1 = new TreeNode(2)
        root1.left = new TreeNode(1)
        root1.right = new TreeNode(3)

        val bool1 = isValidBST(root1)
        println(bool1)

        val root2 = new TreeNode(10)
        root2.left = new TreeNode(5)
        root2.right = new TreeNode(15)
        root2.right.left = new TreeNode(6)
        root2.right.right = new TreeNode(20)
        val bool2 = isValidBST(root2)
        println(bool2)

        val root3 = new TreeNode(2147483647)
        val bool3 = isValidBST(root3)
        println(bool3)
    }
}
