package cn.sliew.leetcode.greedy

/**
  * 134. Gas Station
  */
object GasStation134ScalaExample {

    def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
        if (gas.length == 1 && gas(0) >= cost(0)) {
            return 0
        }
        for (index <- 0 until gas.length) {
            val result = circuit(gas, cost, index)
            if (result != -1) {
                return result
            }
        }
        -1
    }

    private def circuit(gas: Array[Int], cost: Array[Int], index: Int): Int = {
        var start = index
        var tank = gas(start)
        do {
            if (tank > cost(start)) {
                tank -= cost(start)
                start = (start + 1) % gas.length
                tank += gas(start)
            } else {
                return -1
            }
        } while ((start + 1) % gas.length != index)
        if (tank >= cost(start)) {
            index
        } else {
            -1
        }
    }

    def main(args: Array[String]): Unit = {
        val gas = Array(1, 2, 3, 4, 5)
        val cost = Array(3, 4, 5, 1, 2)
        val result = canCompleteCircuit(gas, cost)
        println(result)
    }

}
