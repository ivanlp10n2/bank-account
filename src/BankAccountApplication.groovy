import application.MoneyDepositServiceTest

class BankAccountApplication {

    static void main(String[] args) {
        startDatabase()
        MoneyDepositServiceTest test = new MoneyDepositServiceTest()
        test.depositMoney()
    }


    static void startDatabase() {

    }
}
