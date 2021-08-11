package cn.sliew.leetcode.backtrack

class CombinationIterator(_characters: String, _combinationLength: Int) {

    private val chars = _characters
    private val length = _combinationLength

    private val subStrs: Iterator[String] = null

    def next(): String = {
        subStrs.next()
    }

    def hasNext(): Boolean = {
        subStrs.hasNext
    }
}

/**
  * 1286. Iterator for Combination medium
  */
object IteratorforCombination1286ScalaExample {

    def main(args: Array[String]): Unit = {
        val iterator = new CombinationIterator("", 2)
        while (iterator.hasNext()) {
            println(iterator.next())
        }
    }

}
