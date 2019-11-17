package intro.concepts

class ExampleController {

    def index() {
        def myMap = [name: "Olivier", id: 123]
        respond myMap
    }
}
