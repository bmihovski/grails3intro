package intro.concepts

class Person {

    String firstName
    String lastName
    Boolean active = false
    String emailAddress

    static constraints = {
        emailAddress nullable: false, email: true, unique: true
    }

    String toString() {
        firstName + " " + lastName
    }
}
