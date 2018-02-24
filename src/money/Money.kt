package money

import java.awt.event.MouseEvent
class Money(amount : Int, currency : String) : Expression {
    val amount : Int = amount
    val currency : String = currency

    companion object {
        fun dollar(amount : Int) : Money = Money(amount, "USD")
        fun franc(amount : Int) : Money = Money(amount, "CHF")
    }

    override fun equals(any : Any?) : Boolean {
        val money : Money = any as Money
        return (amount == money.amount) && (this.currency == money.currency)
    }

    fun times(multiplier : Int) : Expression = Money(amount * multiplier, currency)
    fun plus(append : Money) : Sum = Sum(this, append)
    override fun reduce(to : String) : Money = this
}