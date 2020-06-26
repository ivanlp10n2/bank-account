package com.empanada.estebanquito

import com.empanada.estebanquito.application.model.DepositRequest
import com.empanada.estebanquito.application.model.Dollars
import com.empanada.estebanquito.application.service.DepositService
import com.empanada.estebanquito.application.service.GetClientDetailsImpl
import com.empanada.estebanquito.application.usecase.DepositUseCase
import com.empanada.estebanquito.application.usecase.GetClientDetails
import com.empanada.estebanquito.domain.client.account.money.Money
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
        setup:
        new ClientTestHelper().createAndSaveClientWithDollar("francisco", 100)

        when:
        def request = DepositRequest .of("francisco", new Dollars(10))
        useCase.cashDeposit( request )

        then:
        queryDetails.getBalance("francisco") == Money.dollar(110)


    }
}
