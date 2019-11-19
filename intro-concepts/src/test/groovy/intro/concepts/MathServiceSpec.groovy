package intro.concepts

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class MathServiceSpec extends Specification implements ServiceUnitTest<MathService>{

    @Unroll
    void "Add: #lhs + #rhs = #answer"() {
        expect:
            answer == service.add(lhs, rhs)
        where:
            lhs | rhs | answer
            4   | 3   |  7
            5.00| 14.0|  19.0
            "a" | "b" | "ab"
    }
}
