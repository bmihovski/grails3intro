package intro.concepts

class ExampleController {

    def index() {
        def myMap = [name: "Olivier", id: 123]
        respond myMap
    }

    def hello() {
        def myMap = [greeting: "Hello name: ${params.name ?: 'word'}"]
        respond myMap
    }

    def save(Person person) {
        if (! person.save()) {
            respond person.errors
        }
    }

}
