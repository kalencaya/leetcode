package cn.sliew.leetcode.array

import scala.collection.mutable.ListBuffer

/**
  * 414. Third Maximum Number easy
  */
object ThirdMaximumNumber414ScalaExample {

  def thirdMax(nums: Array[Int]): Int = {
    val temp = new ListBuffer[Int]()
    for (num <- nums){
      add(temp, num);
    }
    if (temp.length < 3) temp(0) else temp(2)
  }

  def add(temp: ListBuffer[Int], num: Int): Unit = {
    //它应该是一个最小堆，容量只有4
    if (temp.length < 1){
      temp += num
      return
    }
    if (temp.length == 3 && temp(2) > num){
      return
    }

    for (i <- temp.length - 1 to (0, -1)){
      if (temp(i) == num){
        return
      } else if (temp(i) < num) {
        temp.insert(i, num)
        if (temp.length > 3){
          temp.remove(temp.length - 1)
        }
        return
      }
    }
    for (i <- 0 until temp.length){

    }
    temp += num
  }

  def main(args: Array[String]): Unit = {
    val nums: Array[Int] = Array(2, 2, 3, 1)
    val result: Int = thirdMax(nums)
    println(result)
  }
}
