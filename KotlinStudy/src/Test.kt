class Test : AbstractTest(), ITest {

    override var d: Double = 4.0
        get() = field

    init {
        show()
        lol()
        r
    }

    fun print(line: String) {
        println(line)
    }

    override fun overRide() {
        println(r)
    }


}