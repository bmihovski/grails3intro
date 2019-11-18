package intro.concepts

class BookTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace = "book"
    /**
     * @attr price REQUIRED price of the book in cents
     */
    def price = { attrs ->
        out << "<div class='price' data-price='${attrs.price}'>"
        out << g.formatNumber(
                number: attrs.price?.div(100),
                type: "currency",
                currencyCode: "USD")
        out << "</div>"
    }

    def display = { attrs ->
        out << render(template: "/common/bookTagLib")
    }
}
