package intro.concepts

import grails.events.bus.EventBus
import grails.test.hibernate.HibernateSpec
import grails.testing.services.ServiceUnitTest

class AccountServiceSpec extends HibernateSpec implements ServiceUnitTest<AccountService>{

    def setup() {
    }

    def cleanup() {
    }

    void "transferEventsExample large transfer"() {
        setup: "Two accounts with large balances"
        def to = new Account(name: "to", balance: 19_999_99).save()
        def from = new Account(name: "from", balance: 19_999_99).save()
        service.setTargetEventBus(Mock(EventBus))

        when: "Send large Transfer"
        service.transferEventsExample(from.id, to.id, 11_000_01)

        then: "transfer.big notification is sent"
        1 * service.eventBus.notify('intro.concepts.transfer.big', _) // <1>
    }

    void "transferEventsExample small transfer"() {
        setup: "Two accounts with large balances"
            def to = new Account(name: "to", balance: 19_999_99).save()
            def from = new Account(name: "from", balance: 1919_999_99).save()
            service.setTargetEventBus(Mock(EventBus))
        when: "Send large transfer"
            service.transferEventsExample(from.id, to.id, 50)
        then: "transfer.big notification is sent"
            0 * service.eventBus.notify('intro.concepts.transfer.big', _)
    }
}
