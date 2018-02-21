package money

// Value Objectパターン
// Value Objectには、コンストラクタで設定した
// インスタンス変数の値が変わってはならないという制約がある
class Dollar(amount : Int, currency : String) : Money(amount, currency) {
    override fun times(multiplier : Int) : Money = Money.dollar(amount * multiplier)
}