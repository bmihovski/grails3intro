package intro.concepts

import javax.transaction.Transactional

class AccountController {

    def accountService

    @Transactional(readOnly=true)
    def index() {
        render Account.list()
    }

    def show() {
        render accountService.get(params.long('id'))
    }

    def transfer() {
        def result = accountService.transfer(params.long('accountIdFrom'),
            params.long('accountIdTo'), params.int('ammount'))
        render result
    }
}
