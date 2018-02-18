package money

// Value Objectパターン
// Value Objectには、コンストラクタで設定した
// インスタンス変数の値が変わってはならないという制約がある
class Dollar(amount : Int) {
    private val amount : Int = amount

    fun times(multiplier : Int) : Dollar {
        return Dollar(amount * multiplier)
    }

    override fun equals(any : Any?) : Boolean {
        val dollar : Dollar = any as Dollar
        return amount == dollar.amount
    }
}