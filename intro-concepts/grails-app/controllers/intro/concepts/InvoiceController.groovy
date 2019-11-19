package intro.concepts

class InvoiceController {

    def index() {
        Invoice invoice = Invoice.findById(params.long('id'),
            [fetch: [items:"join"]])
        respond(invoice: invoice)
    }

}
