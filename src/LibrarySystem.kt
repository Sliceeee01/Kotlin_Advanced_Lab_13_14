class Library<T> {
    private val items = mutableListOf<T>()

    fun add(item: T) {
        items.add(item)
    }

    fun remove(item: T): Boolean {
        return items.remove(item)
    }

    fun getAll(): List<T> {
        return items.toList()
    }

    fun getCount(): Int {
        return items.size
    }
}

data class Book(
    val title: String,
    val author: String,
    val year: Int,
    val isbn: String
)

data class Magazine(
    val title: String,
    val issue: Int,
    val month: String
)

data class DVD(
    val title: String,
    val director: String,
    val duration: Int
)

sealed class LibraryItem {
    data class BookItem(val book: Book) : LibraryItem()
    data class MagazineItem(val magazine: Magazine) : LibraryItem()
    data class DVDItem(val dvd: DVD) : LibraryItem()
}

fun filterByYear(books: List<Book>, year: Int): List<Book> {
    return books.filter { it.year == year }
}

fun sortByTitle(items: List<LibraryItem>): List<LibraryItem> {
    return items.sortedBy {
        when (it) {
            is LibraryItem.BookItem -> it.book.title
            is LibraryItem.MagazineItem -> it.magazine.title
            is LibraryItem.DVDItem -> it.dvd.title
        }
    }
}

fun groupByAuthor(books: List<Book>): Map<String, List<Book>> {
    return books.groupBy { it.author }
}

fun calculateTotalDuration(items: List<LibraryItem>): Int {
    return items.fold(0) { total, item ->
        when (item) {
            is LibraryItem.DVDItem -> total + item.dvd.duration
            else -> total
        }
    }
}

fun main() {
    val book1 = Book("Война и мир", "Толстой", 1869, "123456")
    val book2 = Book("Преступление и наказание", "Достоевский", 1866, "234567")
    val book3 = Book("Анна Каренина", "Толстой", 1877, "345678")
    val book4 = Book("Мастер и Маргарита", "Булгаков", 1967, "456789")

    val magazine1 = Magazine("Наука и жизнь", 2024, "Январь")
    val magazine2 = Magazine("Вокруг света", 2024, "Февраль")

    val dvd1 = DVD("Побег из Шоушенка", "Дарабонт", 142)
    val dvd2 = DVD("Крестный отец", "Коппола", 175)

    val bookLibrary = Library<Book>()
    bookLibrary.add(book1)
    bookLibrary.add(book2)
    bookLibrary.add(book3)
    println("Книг в библиотеке: ${bookLibrary.getCount()}")

    val items = listOf(
        LibraryItem.BookItem(book1),
        LibraryItem.BookItem(book2),
        LibraryItem.BookItem(book3),
        LibraryItem.BookItem(book4),
        LibraryItem.MagazineItem(magazine1),
        LibraryItem.MagazineItem(magazine2),
        LibraryItem.DVDItem(dvd1),
        LibraryItem.DVDItem(dvd2)
    )

    println("\n filterByYear ")
    val books = listOf(book1, book2, book3, book4)
    val oldBooks = filterByYear(books, 1866)
    oldBooks.forEach { println("${it.title} - ${it.year}") }

    println("\n sortByTitle ")
    val sorted = sortByTitle(items)
    sorted.forEach {
        when (it) {
            is LibraryItem.BookItem -> println("Книга: ${it.book.title}")
            is LibraryItem.MagazineItem -> println("Журнал: ${it.magazine.title}")
            is LibraryItem.DVDItem -> println("DVD: ${it.dvd.title}")
        }
    }

    println("\n groupByAuthor")
    val byAuthor = groupByAuthor(books)
    byAuthor.forEach { (author, authorBooks) ->
        println("$author: ${authorBooks.map { it.title }}")
    }

    println("\n calculateTotalDuration")
    val total = calculateTotalDuration(items)
    println("Общая продолжительность DVD: $total минут")
}