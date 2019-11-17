package intro.concepts

class Invoice {

    String name

    static hasMany = [items: Item]

    static constraints = {
    }

    def getTotal() {
        items?.sum { it.amount }
    }
}
