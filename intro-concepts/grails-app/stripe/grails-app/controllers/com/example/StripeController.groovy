package com.example

import com.stripe.Stripe
import com.stripe.model.Charge

class StripeController {

    def stripeService

    def charge() {
        Stripe.apiKey = grailsApplication.config.stripe.apiKey
        String token = params.stripeToken

        Map chargeParams = [
                amount: params.int('amount'),
                currency: 'usd',
                description: params.item,
                source: token,
                metadata: [:]
        ]

        def charge
        try {
            charge = Charge.create(chargeParams)
        } catch (e) {
            log.error '{}', e
        }

        if (charge?.id) {
            forward action: 'thankYou'
        } else {
            forward action: 'error'
        }
    }

    def thankYou() {
        render 'Thank you for your purchase!'
    }

    def error() {
        render 'Payment failed!'
    }

    def webHook() {
        if (request.JSON) {
            stripeService.notifyWebHook request.JSON
        }
        render ''
    }
}
