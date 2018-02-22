import money.Bank
import money.Expression
import org.junit.jupiter.api.Test
import money.Money
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MoneyTest {
    @Test
    fun testMultiplication() {
        val five: Money = Money.dollar(5)
        assertEquals(Money.dollar(10), five.times(2))
        assertEquals(Money.dollar(15), five.times(3))
    }

    @Test
    fun testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)))
        assertFalse(Money.dollar(5).equals(Money.dollar(6)))
        assertFalse(Money.dollar(5).equals(Money.franc(5)))
    }

    @Test
    fun testCurrency() {
        assertEquals("USD", Money.dollar(1).currency)
        assertEquals("CHF", Money.franc(1).currency)
    }

    @Test
    fun testSimpleAddition(){
        val five : Money = Money.dollar(5)
        val sum : Expression = five.plus(five)
        val bank : Bank = Bank()
        val reduced : Money = bank.reduce(sum, "USD")
        assertEquals(Money.dollar(10), reduced)
    }
}