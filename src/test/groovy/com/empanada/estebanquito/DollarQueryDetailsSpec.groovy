package com.empanada.estebanquito

import com.empanada.estebanquito.application.model.Dollars
import com.empanada.estebanquito.application.service.GetClientDetailsImpl
import com.empanada.estebanquito.application.usecase.GetClientDetails
import org.junit.experimental.categories.Category
import spock.lang.Specification

@Category(UnitTest.class)
class DollarQueryDetailsSpec extends Specification{
    GetClientDetails clientDetailsUseCase

    def setup(){
        clientDetailsUseCase = new GetClientDetailsImpl()
    }

    void 'Save new client and query its balance'(){
        setup: 'Save new client'
        new ClientTestHelper().createAndSaveClientWithDollar(clientName, startBalance)

        expect: 'Check its balance is the same as we saved'
        clientDetailsUseCase.getBalance(clientName) == startBalance

        where:
        clientName  | startBalance
        "dummy"     | new Dollars(50)
        "foo"       | new Dollars(10)
        "John"      | new Dollars(-10)
        "Jane"      | new Dollars(0)
    }
}
