package money

class Bank() {
    private val rates: MutableMap<Pair, Int> = mutableMapOf()

    fun reduce(source : Expression, to : String) : Money {
        return source.reduce(this, to)
    }

    fun addRate(from : String, to : String, rate : Int) {
        rates.put(Pair(from, to), rate)
    }

    fun rate(from : String, to : String) : Int {
        if (from.equals(to)) return 1
        return rates.getValue(Pair(from, to))
    }
}