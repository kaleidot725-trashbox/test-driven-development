package money

import java.awt.event.MouseEvent

abstract class Money(amount : Int) {
    val amount : Int = amount

    companion object {
        fun dollar(amount : Int) : Dollar = Dollar(amount)
        fun franc(amount : Int) : Franc = Franc(amount)
    }

    override final fun equals(any : Any?) : Boolean {
        val money : Money = any as Money
        return (amount == money.amount) && (this::class.java == money::class.java)
    }

    abstract fun times(multiplier : Int) : Money
}