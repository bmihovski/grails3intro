package intro.concepts

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.*
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
@Rollback
class InvoiceTransferSpec extends Specification {
    @Autowired
    AccountService accountService

    void "Transfer"() {
        setup:
            def from = new Account(name: "From", balance: 1_00).save()
            def to = new Account(name: "To", balance: 1_00).save()
        when:
            accountService.transfer(from.id, to.id, 50)
        then:
            from.balance == 50
            to.balance == 1_50
        and:
            Account.count == 2
    }

    void "did't polute"() {
        expect:
            Account.count == 0
    }
}
