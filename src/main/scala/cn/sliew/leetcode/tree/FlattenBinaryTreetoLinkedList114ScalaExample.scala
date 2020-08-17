package cn.sliew.leetcode.tree

/**
  * 114.Flatten Binary Tree to Linked List medium
  */
object FlattenBinaryTreetoLinkedList114ScalaExample {

    def flatten(root: TreeNode): Unit = {
        flatten(root, null)
    }

    private def flatten(root: TreeNode, pre: TreeNode): TreeNode = {
        var prev = pre
        if (root == null) {
            return prev
        }
        prev = flatten(root.right, prev)
        prev = flatten(root.left, prev)
        root.right = prev
        root.left = null
        prev = root
        prev
    }


    def main(args: Array[String]): Unit = {
        val root = new TreeNode(1)
        root.left = new TreeNode(2)
        root.left.left = new TreeNode(3)
        root.left.right = new TreeNode(4)
        root.right = new TreeNode(5)
        root.right.right = new TreeNode(6)
        flatten(root)
        println(root.value)
    }

}
