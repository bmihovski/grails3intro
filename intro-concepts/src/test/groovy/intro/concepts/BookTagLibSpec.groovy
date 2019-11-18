package intro.concepts

import grails.testing.web.taglib.TagLibUnitTest
import spock.lang.Specification

class BookTagLibSpec extends Specification implements TagLibUnitTest<BookTagLib> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
