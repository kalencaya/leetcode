package cn.sliew.ds.tree

import scala.collection.mutable.ListBuffer

/**
  * 02.用非递归的方式实现查找二叉树中的最大元素
  *
  * 解题思路：遍历二叉树中的所有元素即可。注意这里的树不是二叉搜索树
  */
object Question02Example {

    def solution(root: TreeNode): Int = {
        if (root == null) {
            return Int.MinValue
        }
        val list = new ListBuffer[TreeNode]()
        list.append(root)
        var max = Int.MinValue
        while (!list.isEmpty) {
            val node = list.remove(0)
            max = math.max(max, node.value)
            if (node.left != null) {
                list.append(node.left)
            }
            if (node.right != null) {
                list.append(node.right)
            }
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
