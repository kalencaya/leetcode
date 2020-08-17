package cn.sliew.leetcode.tree

/**
  * 100. Same Tree easy
  */
object SameTree100ScalaExample {

    def isSameTree(p: TreeNode, q: TreeNode): Boolean = {

        if (p == null && q == null) {
            return true
        }

        if (p != null && q != null && p.value == q.value) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        }

        false
    }

    def main(args: Array[String]): Unit = {

    }

}
