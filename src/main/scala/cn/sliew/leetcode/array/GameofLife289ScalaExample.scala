package cn.sliew.leetcode.array

/**
  * 289 Game of Life medium
  */
object GameofLife289ScalaExample {

  def gameOfLife(board: Array[Array[Int]]): Unit = {
      val result: Array[Array[Int]] = Array.ofDim(board.length, board(0).length)
      for (i <- 0 until board.length; j <- 0 until board(i).length){
        result(i)(j) = board(i)(j)
      }

      for (i <- 0 until board.length; j <- 0 until board(i).length){
        val nums = countLive(result, i, j)
        if (result(i)(j) == 0){
          if (nums == 3)(
            board(i)(j) = 1
          )
        } else {
          if (nums < 2 || nums > 3){
            board(i)(j) = 0
          }
        }
      }

  }

  def countLive(board: Array[Array[Int]], i: Int, j: Int): Int = {
    var nums: Int = 0
    if (i > 0 && board(i - 1)(j) == 1){ //左
      nums += 1
    }
    if (i < board.length - 1 && board(i + 1)(j) == 1){ //右
      nums += 1
    }
    if (j > 0 && board(i)(j - 1) == 1){ //上
      nums += 1
    }
    if (j < board(i).length - 1 && board(i)(j + 1) == 1){ //下
      nums += 1
    }

    if (i > 0 && j > 0 && board(i - 1)(j - 1) == 1){ //左上
      nums += 1
    }
    if (i > 0 && j < board(i).length - 1 && board(i - 1)(j + 1) == 1){
      nums += 1
    }
    if (i < board.length - 1 && j > 0 && board(i + 1)(j - 1) == 1){
      nums += 1
    }
    if (i < board.length - 1 && j < board(i).length - 1 && board(i + 1)(j + 1) == 1){
      nums += 1
    }
    return nums
  }

  def main(args: Array[String]): Unit = {
    val board: Array[Array[Int]] = Array(
      Array(0, 1, 0),
      Array(0, 0, 1),
      Array(1, 1, 1),
      Array(0, 0, 0)
    )
    gameOfLife(board)
    board.foreach(a => println(a.mkString(", ")))
  }

}
