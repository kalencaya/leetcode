package cn.sliew.leetcode.tree

import cn.sliew.leetcode.Node

import scala.collection.mutable.ListBuffer

/**
  * 116.Populating Next Right Pointers in Each Node medium
  */
object PopulatingNextRightPointersinEachNode116ScalaExample {

    def connect(root: Node): Node = {
        if (root == null) {
            return root
        }

        val list: ListBuffer[Node] = new ListBuffer[Node]
        list += root
        list += null
        while (!list.isEmpty) {
            val node = list.remove(0)
            if (node != null) {
                if (node.left != null) {
                    list += node.left
                }
                if (node.right != null) {
                    list += node.right
                }
                node.next = list.head
            }
            if (list.size > 1 && list.head == null) {
                list += null
            }
        }
        root
    }

    def main(args: Array[String]): Unit = {
        val root = new Node(1)
        root.left = new Node(2)
        root.right = new Node(3)
        root.left.left = new Node(4)
        root.left.right = new Node(5)
        root.right.left = new Node(6)
        root.right.right = new Node(7)
        val result = connect(root)

    }
}
