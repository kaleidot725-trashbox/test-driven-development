package money

// Value Objectパターン
// Value Objectには、コンストラクタで設定した
// インスタンス変数の値が変わってはならないという制約がある
class Dollar(amount : Int) : Money(amount) {
    override fun times(multiplier : Int) : Money {
        return Dollar(amount * multiplier)
    }
}