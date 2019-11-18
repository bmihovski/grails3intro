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

    def tagLibs() {
        def bookList = [ books: [
                [id: 1, title: "Groovy in Action", price: 29_99],
                [id: 2, title: "Java 8 in Action", price: 24_99]
        ]]
        respond bookList
    }

}
