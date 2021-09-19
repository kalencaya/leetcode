package cn.sliew.leetcode.contest.weekly259

/**
  * 5875. Final Value of Variable After Performing Operations easy
  */
object FinalValueofVariableAfterPerformingOperations5875ScalaExample {

    def finalValueAfterOperations(operations: Array[String]): Int = {
        val add = Set("++X", "X++")
        var x = 0
        for (operation <- operations) {
            if (add.contains(operation)) {
                x += 1
            } else {
                x -= 1
            }
        }
        x
    }

    def main(args: Array[String]): Unit = {
        val operations = Array("++X","++X","X++")
        val result = finalValueAfterOperations(operations)
        println(result)
    }

}
