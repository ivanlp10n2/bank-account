package domain.account

class Money {
    static Money ZERO = Money.Factory.of(0l)

    private final BigDecimal amount

    private Money(BigDecimal amount){
        this.amount = amount
    }

    static class Factory {
        static Money of(double value){
            new Money(BigDecimal.valueOf(value))
        }
    }

    static Money add(Money a, Money b){
        Factory.of(a.amount.add(b.amount))
    }

    static Money subtract(Money a, Money b) {
        Factory.of(a.amount.subtract(b.amount))
    }

    Money plus(Money money){
        Factory.of(this.amount.add(money.amount))
    }

    Money minus(Money money){
        Factory.of(this.amount.subtract(money.amount))
    }

    Money negate(){
        Factory.of(this.amount.negate())
    }

    @Override
    String toString() {
        "\$ ${amount}"
    }
}
