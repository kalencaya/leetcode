package cn.sliew.leetcode.tree

class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
}

object TreeNode {

    def build(nums: Array[String]): TreeNode = {
        val buffer = nums.toBuffer
        buffer.insert(0, "null")
        var index = 1
        val root = new TreeNode(Integer.parseInt(nums(index)))
        while (index < nums.length) {
            var leftIndex = 2 * index
            var rightIndex = 2 * index + 1
            if (leftIndex < nums.length && buffer(leftIndex) != "null") {
                root.left = new TreeNode(Integer.parseInt(buffer(leftIndex)))
            }
            if (rightIndex < nums.length && buffer(rightIndex) != "null") {
                root.right = new TreeNode(Integer.parseInt(buffer(rightIndex)))
            }
        }
        root
    }
}
