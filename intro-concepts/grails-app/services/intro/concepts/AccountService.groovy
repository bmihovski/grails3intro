package intro.concepts

import grails.gorm.transactions.Transactional

@Transactional
class AccountService {

    def transfer(Long fromId, Long toId, Integer amount) {
        Boolean transfer = false
        Account from = Account.get(fromId)
        Account to = Account.get(toId)

        from.balance -= amount
        to.balance += amount
        if (from.save() && to.save()) {
            transfer = true
            if (amount > 9_999_99) {
                def map = [fromId:fromId, toId:toId, amount:amount]
                notify('intro.concepts.transfer.big', map)
            }
        } else {
            def map = [fromId:fromId, toId:toId, amount:amount]
            notify('intro.concepts.transfer.failed', map)
            transactionStatus.setRollbackOnly()
        }
        return [transfer: transfer]
    }

    @Transactional(readOnly = true)
    def get(Long id) {
        return Account.get(id)
    }

}
