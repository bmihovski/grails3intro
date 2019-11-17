package intro.concepts

class PasswordController {

    def update(PasswordCommand passwordCommand) {
        if (passwordCommand.validate()) {
            // Call a method to have and save password
            passwordCommand.person.changePass(passwordCommand.password)
        } else {
            response.status = 400
            respond passwordCommand.errors
        }
    }
}

// Class in the same file as the Controller
class PasswordCommand {
    Person person
    String password
    String retypePassword

    static constraints = {
        password minSize: 8
        retypePassword validator: { value, command ->
            if (command.password != command.retypePassword) {
                return 'passwordCommand.retypePassword.error.mismatch'
            }
        }
    }

}
