package cn.sliew.leetcode.array

/**
  * 509.Fibonacci Number easy
  */
object FibonacciNumber509ScalaExample {

  def fib(N: Int): Int = {
    if (N == 0){
      return 0
    }
    if (N == 1){
      return 1
    }

    return fib(N - 1) + fib(N - 2)
  }

  def fib2(N : Int): Int = {
    if (N <= 1){
      return N
    }
    return memoize(N)
  }

  private def memoize(N: Int): Int = {
    val cache: Array[Int] = new Array(N + 1)
    cache(0) = 0 //如果不赋值，默认为0，这个调用可以避免
    cache(1) = 1

    for(i <- 2 to N){
      cache(i) = cache(i - 1) + cache(i - 2)
    }

    return cache(N)
  }

  def fib4(N: Int): Int = {
    if (N == 0){
      return 0
    }
    if (N == 1){
      return 1
    }
    if (N == 2){
      return 1
    }
    var current = 0
    var pre1 = 1
    var pre2 = 1
    for (i <- 3 to N){
      current = pre1 + pre2
      pre2 = pre1
      pre1 = current
    }

    return current
  }


  def main(args: Array[String]): Unit = {
    val N = 4;
    val result = fib4(N)
    println(result)
  }
}
