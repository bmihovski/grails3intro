package com.example

import grails.events.EventPublisher


class StripeService implements EventPublisher {

    def notifyWebHook(def payLoad) {
        def type = payLoad?.type ?: 'unknown'

        notify("stripe.${type}", payLoad)
    }
}
/* example usage
package app

import reactor.spring.context.annotation.Consumer
import reactor.spring.context.annotation.Selector

@Consumer
class StripeEventsConsumerService {
    @Selector('stripe.charge.succeeded')
    void sendBook(payload) {
        log.info "Emailing book to ${payload.data.object.metadata.emailAddress}"
        /// ... Do something more interesting than log statements
    }

    @Selector('stripe.charge.failed')
    void sendPaymentFailedEmail(payload) {
        log.info "Charge Failed for ${payload.data.object.metadata.emailAddress} - reason ${payload.data.object.failure_message}"
        /// ... Do something more interesting than log statements
    }
}*/
