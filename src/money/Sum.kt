package money

class Sum(augend : Money, addend : Money) : Expression {
    val augend : Money = augend
    val addend : Money = addend

    override fun reduce(bank : Bank, to : String) : Money {
        val amount = augend.amount + addend.amount
        return Money(amount, to)
    }
}