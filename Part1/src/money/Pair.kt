package money

class Pair(from : String, to : String) {
    val from : String = from
    val to : String = to

    override fun equals(any : Any?) : Boolean {
        val pair : Pair = any as Pair
        return from.equals(pair.from) && to.equals(pair.to)
    }

    override fun hashCode() : Int {
        return 0
    }
}