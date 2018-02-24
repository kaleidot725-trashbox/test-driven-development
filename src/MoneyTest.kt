import money.Bank
import money.Expression
import org.junit.jupiter.api.Test
import money.Money
import money.Sum
import java.util.*
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

    @Test
    fun testPlusReturnsSum() {
        val five : Money = Money.dollar(5)
        val result : Expression = five.plus(five)
        val sum : Sum = result as Sum
        assertEquals(five, sum.augend)
        assertEquals(five, sum.addend)
    }

    @Test
    fun testReduceSum() {
        val sum : Expression = Sum(Money.dollar(3), Money.dollar(4))
        val bank : Bank = Bank()
        val result : Money = bank.reduce(sum, "USD")
        assertEquals(Money.dollar(7), result)
    }

    @Test
    fun testReduceMoney(){
        val bank : Bank = Bank()
        val result : Money = bank.reduce(Money.dollar(1), "USD")
        assertEquals(Money.dollar(1), result)
    }

    @Test
    fun testReduceMoneyDifferentCurrency(){
        val bank : Bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result : Money = bank.reduce(Money.franc(2), "USD")
        assertEquals(Money.dollar(1), result)
    }

    @Test
    fun testArrayEquals() {
        assertEquals(arrayListOf("abc"), arrayListOf("abc"))
    }

    @Test
    fun testIdentityRate(){
        assertEquals(1, Bank().rate("USD", "USD"))
    }
}