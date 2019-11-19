package intro.concepts

import grails.plugin.json.view.test.JsonViewTest
import grails.testing.gorm.DataTest
import spock.lang.Specification

class InvoiceGsonSpec extends Specification implements JsonViewTest, DataTest {

    def setup() {
        mockDomain(Invoice)
        mockDomain(Item)
    }

    void "invoice with items"() {
        given: "an invoice with two items"
            def invoice = new Invoice(name: "foobar")
            invoice.addToItems(new Item(amount: 1_00))
            invoice.addToItems(new Item(amount: 3_00))

        when: "render json template"
            def result = render(template: "/invoice/invoice",
                model: [invoice: invoice])

        then: "json is correct"
            with(result.json) {
                name == 'foobar'
                total == 400
                items.size() == 2
            }
    }

    void "list view"() {
        given: "A list of invoices"
            List<Invoice> invoices = [
                    new Invoice(name: "first").save(),
                    new Invoice(name: "second").save()
            ]
        when: "list view is rendered"
            def result = render(view: "/invoice/list.gson", model: [invoices: invoices])

        then: "json contains two objects"
            result.json.size() == 2
    }
}
