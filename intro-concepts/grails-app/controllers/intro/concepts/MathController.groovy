package intro.concepts

class MathController {
    def mathService

    def add(AddCommand addCommand) {
        def result

        if (addCommand.validate()) {
            result = [
                    answer: mathService.add(addCommand.lhs, addCommand.rhs)
                            ]
        } else {
            result = [
                    error: addCommand.errors
            ]
        }

        respond result
    }
}

class AddCommand {
    Integer lhs
    Integer rhs
}
