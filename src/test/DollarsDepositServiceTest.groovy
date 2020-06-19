package test

import application.model.DepositRequest
import application.model.Dollars
import application.service.DepositService
import application.service.GetClientDetailsImpl
import application.usecase.DepositUseCase
import application.usecase.GetClientDetails
import groovy.test.GroovyTestCase

class DollarsDepositServiceTest extends GroovyTestCase{

    private final DepositUseCase useCase
    private final GetClientDetails queryClientDetails

    DollarsDepositServiceTest(){
        useCase = new DepositService()
        queryClientDetails = new GetClientDetailsImpl()
        startup()
    }

    void startup(){
        new ClientTestHelper().createClientWithDollar("francisco", 100)
    }

    void depositMoney() {
        DepositRequest request = DepositRequest .of("francisco", new Dollars(10) )

        useCase.cashDeposit(request)

        print queryClientDetails.getBalance("francaisco")
    }
}
