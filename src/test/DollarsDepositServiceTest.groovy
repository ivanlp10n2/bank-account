package test

import application.model.DepositRequest
import application.model.Money
import application.service.DepositService
import application.service.GetClientDetailsImpl
import application.usecase.DepositUseCase
import application.usecase.GetClientDetails
import groovy.test.GroovyTestCase

class MoneyDepositServiceTest extends GroovyTestCase{

    private final DepositUseCase useCase
    private final GetClientDetails queryClientDetails

    MoneyDepositServiceTest(){
        useCase = new DepositService()
        queryClientDetails = new GetClientDetailsImpl()
        startup()
    }

    void startup(){
        new ClientHelper().createClientWithDollar(  name: "francisco",
                                                    amount: 100)
    }

    void depositMoney() {
        DepositRequest request = DepositRequest .of(clientId: "francisco",
                                                    money:    new Money( amount: 10,)
                                                    )

        useCase.cashDeposit(request)

        print queryClientDetails.getBalance()
    }
}
