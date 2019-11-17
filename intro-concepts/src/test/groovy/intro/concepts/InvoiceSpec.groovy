package intro.concepts

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class InvoiceSpec extends Specification implements DomainUnitTest<Invoice> {

    def testInvoice // Just holder to make examples better

    def setup() {
        def invoice = new Invoice(name: "Invoice1").save()

        def widget = new Item(name: "Widget", amount: 1000)
        def bar = new Item(name: "Bar", amount: 500)

        invoice.addToItems(widget)
        invoice.addToItems(bar)

        testInvoice = invoice
    }

    def cleanup() {
    }

    void "Totals"() {
        given:
            def invoice = testInvoice
        expect: "To return total"
            invoice.total == 1500

    }
}
