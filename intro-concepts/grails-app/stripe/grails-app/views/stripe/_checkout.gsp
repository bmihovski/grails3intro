<form action="${attrs.callBackUrl}" method="post">
    <script
        class="stripe-button"
        src="https://checkout.stripe.com/checkout.js"
        data-key="${stripePublicKey}"
        data-amount="${attrs.amount}"
        data-name="${attrs.name}"
        data-description="${attrs.description ?: ''}"
        data-image="${image}"
        data-locale="auto"
        data-zip-code="${verifyZip}">
    </script>
</form>