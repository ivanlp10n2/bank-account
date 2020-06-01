package domain.account.money

class Money {
    static Money ZERO = Money.Factory.of(0l)

    private final BigDecimal amount
    private final Currency currency

    private Money(Currency currency, BigDecimal amount){
        this.currency = currency
        this.amount = amount
    }

    static class Factory {
        static Money of(Money money){
            new Money(money.currency, money.amount)
        }
        static Money dollar(double value){
            new Money(Currency.Factory.dollar(), BigDecimal.valueOf(value))
        }
    }

    static Money add(Money a, Money b){
        Factory.dollar(a.amount.add(b.amount))
    }

    static Money subtract(Money a, Money b) {
        Factory.dollar(a.amount.subtract(b.amount))
    }

    Money plus(Money money){
        Factory.dollar(this.amount.add(money.amount))
    }

    Money minus(Money money){
        Factory.dollar(this.amount.subtract(money.amount))
    }

    Money negate(){
        Factory.dollar(this.amount.negate())
    }

    @Override
    String toString() {
        "\$ ${amount}"
    }
}
