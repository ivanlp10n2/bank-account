package domain.account.money

class Money {
    static Money ZERO = Money.dollar(0)

    private final BigDecimal amount
    private final Currency currency

    private Money(Currency currency, BigDecimal amount){
        this.currency = currency
        this.amount = amount
    }

    static Money of(Money money){
        assert money.currency in Currency.values()
        new Money(money.currency, money.amount)
    }
    static Money dollar(double value){
        new Money(Currency.USD, BigDecimal.valueOf(value))
    }

    Money plus(Money money){
        dollar(this.amount.add(money.amount))
    }

    Money minus(Money money){
        dollar(this.amount.subtract(money.amount))
    }

    Money negate(){
        dollar(this.amount.negate())
    }

    @Override
    String toString() {
        "\$ ${amount}"
    }

    enum Currency {
        USD,
        DEFAULT,
    }
}


