package com.empanada.estebanquito

import com.empanada.estebanquito.application.model.DepositRequest
import com.empanada.estebanquito.application.model.Dollars
import com.empanada.estebanquito.application.service.DepositService
import com.empanada.estebanquito.application.service.GetClientDetailsImpl
import com.empanada.estebanquito.application.usecase.DepositUseCase
import com.empanada.estebanquito.application.usecase.GetClientDetails
import org.junit.experimental.categories.Category
import spock.lang.Specification

@Category(UnitTest.class)
class DollarsDepositServiceSpec extends Specification{

    private DepositUseCase useCase
    private GetClientDetails queryDetails

    def setup (){
        useCase = new DepositService()
        queryDetails = new GetClientDetailsImpl()
    }

    def 'An existing client deposits money in his account'() {
        setup: "An existing client with id 'francisco' with 100 USD in his account"
        new ClientTestHelper().createAndSaveClientWithDollar(clientName, startBalance)

        when: "Deposits 10 USD in his account"
        def request = DepositRequest .of(clientName, moneyToDeposit)
        useCase.cashDeposit( request )

        then: "Balance of his account is 110 USD"
        queryDetails.getBalance(clientName) == finalBalance

        where:
        clientName   | startBalance     | moneyToDeposit    | finalBalance
        "francisco"  | new Dollars(100) | new Dollars(10)   | new Dollars(110)
    }
}
