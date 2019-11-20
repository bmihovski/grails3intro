package intro.concepts

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration

@Integration
@Rollback
class PersonRestSpec extends RestSpec {

    void "Create a person"() {
        setup: "Create a person via GORM"
            new Person(firstName: "Eric", lastName: "Helgeson").save()
        when: "Create a person via the API"
            def response = rest.post("${baseUrl}/example/save") {
                accept('application/json')
                json('{"firstName":"Foo", "lastName":"Bar", "emailAddress":"test@test.com"}')
            }
        then: "API call success"
            response.status == 200
            response.json.firstName == "Foo"
        and:
            Person.count == 2

    }
}
