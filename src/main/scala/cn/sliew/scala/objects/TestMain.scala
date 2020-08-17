package cn.sliew.scala.objects

object TestMain {

    def main(args: Array[String]): Unit = {
        val employee = new Employee("wangqi", 11, Some("hangzhou"))
        println(employee.name)
        println(employee.age)
        println(employee.address)
        employee.age = 13
        println(employee.age)
    }
}
