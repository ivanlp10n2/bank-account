import test.DollarsDepositServiceTest

class BankAccountApplication {

    static void main(String[] args) {
        startDatabase()
        DollarsDepositServiceTest test = new DollarsDepositServiceTest()
        test.depositMoney()
    }


    static void startDatabase() {

    }
}
