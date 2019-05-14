fun main () {
    var elem: Array<String> = arrayOf("1","2","3","4","5","6","7","8","9","10","11","12")
    var helper = PaginationHelp(5,elem)
    println(helper.itemCount())
    println(helper.pageCount())

    println(helper.pageItemCount(2))
    println(helper.pageItemCount(15))
    println(helper.pageItemCount(0))

    println(helper.pageIndex(1))
    println(helper.pageIndex(11))
    println(helper.pageIndex(100))
}

class PaginationHelp(
    var elementsPerPage: Int,
    var elements: Array<String>) {

    fun itemCount(): Int {
        return if (elements == null) 0 else elements.size
    }

    fun pageCount(): Int {
        if (elements == null)
            return 0
        return if (elements.size % elementsPerPage == 0) elements.size / elementsPerPage else elements.size / elementsPerPage + 1
    }

    fun pageItemCount(pageIndex: Int): Int {
        if (pageIndex < 0 || pageIndex > this.pageCount() - 1)
            return -1
        return if (pageIndex < this.pageCount() - 1) elementsPerPage else elements.size % elementsPerPage
    }

    fun pageIndex(itemIndex: Int): Int {
        return if (itemIndex < 0 || itemIndex > elements.size - 1) -1 else itemIndex / elementsPerPage
    }
}