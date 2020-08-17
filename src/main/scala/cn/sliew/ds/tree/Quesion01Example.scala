package cn.sliew.ds.tree

/**
  * 01.给出查找二叉树中的最大元素的算法
  */
object Quesion01Example {

    def solution(root: TreeNode): Int = {
        if (root == null) {
            return Int.MinValue
        }
        var max = root.value
        if (root.left != null) {
            max = math.max(max, solution(root.left))
        }
        if (root.right != null) {
            max = math.max(max, solution(root.right))
        }
        max
    }

    def main(args: Array[String]): Unit = {
        val root = new TreeNode(1)
        root.left = new TreeNode(2)
        root.right = new TreeNode(3)
        root.left.left = new TreeNode(4)
        root.left.right = new TreeNode(5)
        root.right.left = new TreeNode(6)
        root.right.right = new TreeNode(7)
        val result = solution(root)
        println(result)
    }

}
