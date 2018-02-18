package money

// Value Objectパターン
// Value Objectには、コンストラクタで設定した
// インスタンス変数の値が変わってはならないという制約がある
class Franc(amount : Int) {
    private val amount : Int = amount

    fun times(multiplier : Int) : Franc {
        return Franc(amount * multiplier)
    }

    override fun equals(any : Any?) : Boolean {
        val dollar : Franc = any as Franc
        return amount == dollar.amount
    }
}