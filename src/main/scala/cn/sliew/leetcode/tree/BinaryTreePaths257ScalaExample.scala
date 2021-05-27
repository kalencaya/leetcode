package cn.sliew.leetcode.tree

/**
  * 257. Binary Tree Paths easy
  */
object BinaryTreePaths257ScalaExample {

    /**
      * 这是一个遍历，一旦遇到叶子节点则可以认为获得一个结果。
      */
    def binaryTreePaths(root: TreeNode): List[String] = {
        List()
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(1, 2, 3, null, 5)
        val root = TreeNode.build(nums)
        val result = binaryTreePaths(root)
        println(result.mkString(", "))
    }

}
