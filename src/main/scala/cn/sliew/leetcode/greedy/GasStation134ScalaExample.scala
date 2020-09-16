package cn.sliew.leetcode.greedy

/**
  * 134. Gas Station medium
  * tags: Greedy
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

    /**
      * int start = gas.size()-1;
      * int end = 0;
      * int sum = gas[start] - cost[start];
      * while (start > end) {
      * if (sum >= 0) {
      * sum += gas[end] - cost[end];
      * ++end;
      * }
      * else {
      * --start;
      * sum += gas[start] - cost[start];
      * }
      * }
      * return sum >= 0 ? start : -1;
      *
      */
    def canCompleteCircuitGreedy(gas: Array[Int], cost: Array[Int]): Int = {
        var start = 0
        var end = gas.length - 1
        var tank = gas(end) - cost(end)
        while (end > start) {
            if (tank >= 0) {
                tank += gas(start) - gas(start)
                start += 1
            } else {
                end -= 1
                tank += gas(end) - gas(end)
            }
        }
        if (tank > 0) {
            end
        } else {
            -1
        }
    }

    def main(args: Array[String]): Unit = {
        val gas = Array(1, 2, 3, 4, 5)
        val cost = Array(3, 4, 5, 1, 2)
        val result = canCompleteCircuitGreedy(gas, cost)
        println(result)
    }

}
