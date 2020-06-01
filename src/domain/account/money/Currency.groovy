package domain.account.money

enum Currency {
    DEFAULT, USD

    final private Currency currency

    private Currency(Currency currency){
        this.currency = currency
    }

    static class Factory{
        static Currency dollar(){
            return new Currency(Currency.USD)
        }
    }

}