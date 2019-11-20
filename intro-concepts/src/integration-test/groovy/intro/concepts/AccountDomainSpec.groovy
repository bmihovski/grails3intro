package intro.concepts

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
@Rollback
class AccountDomainSpec extends Specification {

    void "An account with name and balance saves"() {
        expect:
            Account.count == 0
            new Account(name: "Savings", balance: 1_00).save()
            Account.count == 1
    }

    void "The account created previously is rolled back"() {
        expect:
            Account.count == 0
    }
}
