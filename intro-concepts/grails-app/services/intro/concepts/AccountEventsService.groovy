package intro.concepts

import reactor.spring.context.annotation.Consumer
import reactor.spring.context.annotation.Selector

@Consumer
class AccountEventsService {

    @Selector('intro.concepts.transfer.big')
    def sendEmail(map) {
        log.info "There was a large transfer, sending email to bigtransfer@irs.gov:" +
                "$map.fromId -> $map.toId : $map.amount"
    }

    @Selector('intro.concepts.transfer.big')
    void logApiCall(map) {
        log.info "There was a large transfer, Calling external API:" +
                "$map.fromId -> $map.toId : $map.amount"
    }

    @Selector('intro.concepts.transfer.failed')
    void transferFailed(map) {
        log.info "A transfer failed, sending email to ops@example.com: $map.fromId -> $map.toId : $map.amount"
    }
}
