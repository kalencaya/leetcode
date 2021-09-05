package cn.sliew.leetcode.contest.weekly257

import scala.collection.mutable
import scala.util.control.Breaks.{break, breakable}

object TheNumberofWeakCharactersintheGame5864ScalaExample {

    def numberOfWeakCharacters(properties: Array[Array[Int]]): Int = {
        var count = 0
        val map = new mutable.HashMap[Int, Int]()
        val sorted = properties.sortWith((character1, character2) => character1(0) > character2(0))

        for (i <- 0 until sorted.length) {
            var max = sorted(i)(1)
            for (j <- i + 1 until sorted.length; if sorted(i)(0) == sorted(j)(0)) {
                max = math.max(max, sorted(j)(1))
            }
            map += sorted(i)(0) -> max
        }

        for (i <- 0 until sorted.length) {
            breakable {
                for (entry <- map) {
                    if (sorted(i)(0) < entry._1 && sorted(i)(1) < entry._2) {
                        count += 1
                        break
                    }
                }
            }
        }


        map.foreach(entry => println(entry._1 + "=" + entry._2))
        count
    }

    def main(args: Array[String]): Unit = {
        val properties = Array(
            //            Array(3, 3),
            //            Array(2, 1),
            //            Array(2, 2),
            //            Array(1, 2)
            Array(7, 7),
            Array(1, 2),
            Array(9, 7),
            Array(7, 3),
            Array(3, 10),
            Array(9, 8),
            Array(8, 10),
            Array(4, 3),
            Array(1, 5),
            Array(1, 5)
        )

        val result = numberOfWeakCharacters(properties)
        println(result)
    }

}
