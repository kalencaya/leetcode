package cn.sliew.leetcode.contest.weekly257

import scala.util.control.Breaks.{break, breakable}

object TheNumberofWeakCharactersintheGame5864ScalaExample {

    def numberOfWeakCharacters(properties: Array[Array[Int]]): Int = {
        var count = 0
        val sorted = properties.sortBy(character => character(0))
        for (i <- 0 until sorted.length - 1) {
            breakable {
                for (j <- i + 1 until sorted.length; if sorted(i)(0) != sorted(j)(0)) {
                    if (sorted(j)(1) > sorted(i)(1)) {
                        count += 1
                        break
                    }
                }
            }
        }
        count
    }

    def main(args: Array[String]): Unit = {
        val properties = Array(
            Array(1, 1),
            Array(2, 1),
            Array(2, 2),
            Array(1, 2)
        )

        val result = numberOfWeakCharacters(properties)
        println(result)
    }

}
