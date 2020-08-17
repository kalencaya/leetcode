package cn.sliew.ds.tree

/**
  * 03.给出在二叉树中搜索某个元素的算法
  *
  * 解题思路：检查根节点是否等于某个元素，然后递归检测左子树和右子树是否存在
  */
object Question03Example {

    def solution(node: TreeNode, num: Int): Boolean = {
        if (node == null) {
            return false
        }
        if (node.value == num) {
            return true
        }
        solution(node.left, num) || solution(node.right, num)
    }

    def main(args: Array[String]): Unit = {
        val root = new TreeNode(1)
        root.left = new TreeNode(2)
        root.right = new TreeNode(3)
        root.left.left = new TreeNode(4)
        root.left.right = new TreeNode(5)
        root.right.left = new TreeNode(6)
        root.right.right = new TreeNode(7)
        val result = solution(root, 3)
        println(result)
    }

}
