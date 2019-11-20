package intro.concepts

import geb.spock.GebSpec
import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
@Rollback
class ExampleSpec extends GebSpec {

    void "Test Example index page"() {
        when: "The example page is loaded"
            go '/example/index'
        then: "The body is correct"
            $("body").text() == "Model: Olivier 123"
    }
}
