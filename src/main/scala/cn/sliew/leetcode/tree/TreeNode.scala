package cn.sliew.leetcode.tree

import scala.collection.mutable.ListBuffer

class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
}

object TreeNode {

    def build(ints: Array[Any]): TreeNode = {
        if (ints == null || ints.length == 0) {
            return null
        }
        val root: TreeNode = new TreeNode(ints(0).asInstanceOf[Int])
        val list: ListBuffer[TreeNode] = new ListBuffer[TreeNode]()
        list.append(root)
        var index = 1
        while (index < ints.length) {
            val node = list.remove(0)
            if (ints(index) != null) {
                node.left = new TreeNode(ints(index).asInstanceOf[Int])
                list.append(node.left)
            }
            index += 1
            if (index < ints.length) {
                if (ints(index) != null) {
                    node.right = new TreeNode(ints(index).asInstanceOf[Int])
                    list.append(node.right)
                }
                index += 1
            }
        }
        root
    }
}
