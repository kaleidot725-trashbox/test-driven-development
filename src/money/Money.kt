package money

import java.awt.event.MouseEvent

abstract class Money(amount : Int, currency : String) {
    val amount : Int = amount
    val currency : String = currency

    companion object {
        fun dollar(amount : Int) : Dollar = Dollar(amount, "USD")
        fun franc(amount : Int) : Franc = Franc(amount, "CHF")
    }

    override final fun equals(any : Any?) : Boolean {
        val money : Money = any as Money
        return (amount == money.amount) && (this::class.java == money::class.java)
    }

    abstract fun times(multiplier : Int) : Money
}