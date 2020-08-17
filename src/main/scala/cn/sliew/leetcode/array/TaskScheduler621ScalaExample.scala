package cn.sliew.leetcode.array

import scala.collection.mutable

/**
  * 621. Task Scheduler medium
  */
object TaskScheduler621ScalaExample {

    def leastInterval(tasks: Array[Char], n: Int): Int = {
        val map = new mutable.LinkedHashMap[Char, Int]()
        for (t <- tasks) {
            val c = map.get(t) match {
                case Some(count) => count
                case None => 0
            }
            map.put(t, c + 1)
        }
        val array = map.values.toArray
        val max = array.max
        val count = array.count(c => c == max)

        //A X X A X X A 框架需要 (max - 1) * n 个空格，
        //加上 A 本身的长度 max
        //加上需要在 A X X A X X A框架后加上的字母如 A B X A B X A B，因为count包括max，所以需要减去
        math.max(tasks.length, (max - 1) * n + max + count - 1)
    }

    def main(args: Array[String]): Unit = {
        val tasks: Array[Char] = Array('A', 'A', 'A', 'B', 'B', 'B')
        val n = 0
        val result = leastInterval(tasks, n)
        println(result)
    }

}
