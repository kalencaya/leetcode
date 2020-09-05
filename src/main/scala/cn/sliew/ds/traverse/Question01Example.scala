package cn.sliew.ds.traverse

/**
  * 汉诺塔问题
  * 有一摞从小到大排列的盘子位于柱子A上，将盘子从A柱子移动到B柱子上，移动期间必须保证下面的
  * 盘子必须大于上面的盘子。还有个柱子C作为辅助
  * 解题思路：
  * 如果盘子数量为1，则直接将盘子从A移动到B
  * 如果盘子数量n大于1，则移动n-1个盘子到柱子C，然后移动最下面的盘子到柱子B
  * ......
  * 当盘子数量为1时，直接移动盘子到B
  */
object Question01Example {

    def solution(n: Int, from: Char, to: Char, aux: Char): Unit = {
        if (n == 1) {
            println("Move disk 1 from peg: " + from + " to peg: " + to)
            return
        }

        solution(n - 1, from, aux, to)
        println("Move disk from peg: " + from + " to peg: " + to)
        solution(n -1, aux, to, from)
    }

    def main(args: Array[String]): Unit = {
        solution(10, 'A', 'B', 'C')
    }


}
