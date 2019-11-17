package intro.concepts

import grails.testing.gorm.DomainUnitTest
import org.junit.Ignore
import spock.lang.Specification

class PersonSpec extends Specification implements DomainUnitTest<Person> {

    def setup() {
    }

    def cleanup() {
    }

    void "Dynamic Filters Examples"() {
        expect:"examples to be valid"
            // Find all of the people that name start with Eric
            Person.findAllByFirstNameIlike("Eric%")
            // Find all inactive People
            Person.findAllByActive(false)
            // Paginate through all active Person, 10 at time
            Person.findAllByActive(true, [max: 10, sort: "lastName", order: "desc", offset: 20])
            // Find all active people named Eric
            Person.findAllByActiveAndFirstName(true, "Eric")
            // Find one person with the name Eric Hegelson
            Person.findByFirstNameAndLastName("Eric", "Hegelson")
    }

    void "Where queries examples "() {
        given: "A first name Eric"
            def firstName = "Eric"
        expect: "a list of people with first name Eric (case sensitive)"
            Person.where {
                firstName =~ firstName
            }.count() == 101
        and: "Paginate through People, if a first name is given, search by it. (case sensitive)"
            Person.where {
                if (firstName) {
                    firstName =~ firstName
                }
            }.max(10).offset(100).list().size() == 1
    }

    void "Criteria examples"() {
        expect: "Examples to be valid"
            def firstName = "Eric"
            // A list of all people with name Eric
            Person.withCriteria {
                eq('firstName', 'Eric')
            }

            // Paginate through People, if a first name is given, search by it. (case insensitive)
            Person.withCriteria(max: 10, offset: 100) {
                if (firstName) {
                    ilike('firstName', firstName)
                }
            }
    }

    @Ignore("findAll can't be used in unit tests")
    void "HQL examples"() {
        expect: "Examples to be valid"
            Person.findAll("from Person as p where p.firstName like 'Eric%'")
    }
}
