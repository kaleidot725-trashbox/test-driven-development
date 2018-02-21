package money

open class Money(amount : Int) {
    val amount : Int = amount

    override final fun equals(any : Any?) : Boolean {
        val money : Money = any as Money
        return amount == money.amount
    }
}