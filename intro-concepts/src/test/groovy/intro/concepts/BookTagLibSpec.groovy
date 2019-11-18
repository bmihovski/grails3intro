package intro.concepts

import grails.testing.web.taglib.TagLibUnitTest
import spock.lang.Specification

class BookTagLibSpec extends Specification implements TagLibUnitTest<BookTagLib> {

    def setup() {
    }

    def cleanup() {
    }

    void "test price"() {
        expect:
            tagLib.price(price: 1_00).toString() == "<div class='price' data-price='100'/>\$1.00</div>"
            tagLib.price(price: 1_10).toString() == "<div class='price' data-price='110'/>\$1.10</div>"
            tagLib.price(price: 1_11).toString() == "<div class='price' data-price='111'/>\$1.11</div>"
            tagLib.price(price: 1_000_10).toString() == "<div class='price' data-price='100010'/>\$1,000.10</div>"
    }

    void "test display"() {
        given: "A book object"
            def book = [id: 1, title: "foo", price: 1_00]
        expect:
            tagLib.display(book: book).toString() == """<div class='book'>
            <h2>foo</h2>
            <div class='price' data-price='100'>\$1.00</div>
            <a href="/example/tagLibs/1">BUY</a>
            </div>
            """
    }
}
