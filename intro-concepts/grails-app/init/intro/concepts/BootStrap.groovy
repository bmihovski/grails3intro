package intro.concepts

class BootStrap {

    def init = { servletContext ->
        def person = new Person (firstName: "Eric",
                lastName: "Helgenson")
        person.firstName = "Bob"
        assert !person.active
        person.save(flush: true)
        Person.findByFirstName("Bob")

    }
    def destroy = {
    }
}
