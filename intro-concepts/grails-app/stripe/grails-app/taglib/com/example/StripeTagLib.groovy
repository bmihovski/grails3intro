package com.example

class StripeTagLib {
    static defaultEncodeAs = [taglib:'none']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace = 'stripe'
    /**
     * Renders a stripe checkout form
     *
     * attr amount REQUIRED The amount of the items in *cents*
     * attr name REQUIRED The name of the item
     * attr description REQUIRED The description of the item
     * attr image An image of the item
     * attr verifyZip require zip-code verification. Default 'true'
     * attr callBackUrl the url the form will submit to after payment
     */
    def checkout = { attr ->
        String stripePublicKey = grailsApplication.config.stripe.publicKey
        String image = attrs?.image ?: grailsApplication.config.stripe.defaultImage
        String callBackUrl = attrs?.callBackUrl ?: grailsApplication.config.stripe.defaultCallBackUrl
        String verifyZip = attrs?.veryZip == null ? true : attrs?.veryZip

        out << render(template: "/stripe/checkout",
            model: [
                    attrs: attrs,
                    image: image,
                    verifyZip: verifyZip,
                    callBackUrl: callBackUrl,
                    stripePublicKey: stripePublicKey
            ])
    }
}
