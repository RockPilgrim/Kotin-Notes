import java.lang.NullPointerException

fun main(args: Array<String>) {
    println("start main\n")

//    enumTest()
//    whenTest1()
//    whenTest2()
//    whenTest3()
//    classTest()
//    cycle1()
//    cycle2()
//    cycle3()
    dataTest()
}

fun dataTest() {
    val dataTest1 = DataTest("H")
    val dataTest2 = dataTest1.copy("Roll")
    val dataTest3 = dataTest2.copy()

    println(dataTest1.line)
    println(dataTest2.line)
    println(dataTest3.line)

    val (line) = dataTest1
    println("\n${line}")
}

fun cycle3() {
    val nums = 1..5  /// range
    for (i in nums) {
        println("i = ${i}")
    }

    print("i = ")
    for (i in nums step 2) {
        print("${i} ")
    }
    print("\ni = ")
    for (i in 10 downTo 1 step 3) {
        print("${i} ")
    }
    val num = 11
    print("\n${num in nums}")
}

fun cycle2() {
    var i = 0

    do {
        println("i = ${i}")
        i++
    }while (i<5)
}

fun cycle1() {
    var i = 0
    while (i < 5) {
        println("i = ${i}")
        i++
    }
}

fun classTest() {
    Test().print("Test print")
}

fun whenTest3() {
    val color1 = Color.BLACK
    val color2 = Color.WHITE

    var colors = setOf(color1, color2)
//    var colors = color2

    when (colors) {
        Color.WHITE ->
            println("white")
        setOf(Color.WHITE,Color.BLACK)->
            println("Gray")
    }
}

fun whenTest2() {
//    val color = Color.BLACK
    val color = Color.WHITE

    when {
        (8 < 2) ->
            println("8 more then 2")
        (color == Color.WHITE)->
            println("color is white")
    }

}

fun whenTest1() {
//    val color = Color.YOLO
//    val color = Color.BLUE
    val color = Color.WHITE
//    val color = Color.RED

    val result = when (color) {
        Color.BLUE ->
            "it's ${Color.BLUE.name}"
        Color.YOLO ->
            "it's ${color.name}"
        Color.BLACK, Color.WHITE ->
            "It's ${Color.BLACK} or ${Color.WHITE}"
        else -> "Nine"
    }
    println(result)
}

fun enumTest() {
    println(Color.BLUE.colorRGB)
    println(Color.BLUE.alpha)

    var color: Color = Color.RED
    println(color.name)
    println(Color.YOLO.alpha)
}

fun nullTest() {
    var d: String? = null
    try {
        println(d!!)
    } catch (e: NullPointerException) {
        println("Lol")
    }
    println("Lol")
}