package intro.concepts

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional
import org.springframework.transaction.annotation.Propagation


class ReportService {

    @ReadOnly
    def dailyBalanceReport() {
        Account.where {
            balance > 1_000_000_00
        }.list().each { Account account ->
            giveReward(account)
        }
    }

    @Transactional(propagation = Propagation.MANDATORY)
    def giveReward(Account account) {
        account.balance += 1
        account.save()
    }
}
