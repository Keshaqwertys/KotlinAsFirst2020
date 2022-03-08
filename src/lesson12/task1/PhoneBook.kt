@file:Suppress("UNUSED_PARAMETER")

package lesson12.task1

/**
 * Класс "Телефонная книга".
 *
 * Общая сложность задания -- средняя, общая ценность в баллах -- 14.
 * Объект класса хранит список людей и номеров их телефонов,
 * при чём у каждого человека может быть более одного номера телефона.
 * Человек задаётся строкой вида "Фамилия Имя".
 * Телефон задаётся строкой из цифр, +, *, #, -.
 * Поддерживаемые методы: добавление / удаление человека,
 * добавление / удаление телефона для заданного человека,
 * поиск номера(ов) телефона по заданному имени человека,
 * поиск человека по заданному номеру телефона.
 *
 * Класс должен иметь конструктор по умолчанию (без параметров).
 */
class PhoneBook {

    private var start: Node? = null

    private class Node(
        val name: String,
        var phones: Set<String>,
        var next: Node?
    )

    private fun SearchName(name: String): Node? {
        var current = start
        while (current != null) {
            if (current.name == name)
                return current
            current = current.next
        }
        return null
    }

    private fun SearchPhone(phone: String): Node? {
        var current = start
        while (current != null) {
            if (phone in current.phones)
                return current
            current = current.next
        }
        return null
    }

    /**
     * Добавить человека.
     * Возвращает true, если человек был успешно добавлен,
     * и false, если человек с таким именем уже был в телефонной книге
     * (во втором случае телефонная книга не должна меняться).
     */
    fun addHuman(name: String): Boolean = if (SearchName(name) != null) false
    else {
        start = Node(name, setOf(), start)
        true
    }

    /**
     * Убрать человека.
     * Возвращает true, если человек был успешно удалён,
     * и false, если человек с таким именем отсутствовал в телефонной книге
     * (во втором случае телефонная книга не должна меняться).
     */
    fun removeHuman(name: String): Boolean = if (SearchName(name) == null) false
    else {
        if (start!!.name == name)
            start = start!!.next
        else {
            var current = start!!
            while (current.next!!.name != name)
                current = current.next!!
            current = Node(current.name, current.phones, current.next!!.next)
        }
        true
    }

    /**
     * Добавить номер телефона.
     * Возвращает true, если номер был успешно добавлен,
     * и false, если человек с таким именем отсутствовал в телефонной книге,
     * либо у него уже был такой номер телефона,
     * либо такой номер телефона зарегистрирован за другим человеком.
     */
    fun addPhone(name: String, phone: String): Boolean {
        val need = SearchName(name)
        return if (need == null || SearchPhone(phone) != null) false
        else {
            need.phones += phone
            true
        }
    }

    /**
     * Убрать номер телефона.
     * Возвращает true, если номер был успешно удалён,
     * и false, если человек с таким именем отсутствовал в телефонной книге
     * либо у него не было такого номера телефона.
     */
    fun removePhone(name: String, phone: String): Boolean {
        val need = SearchName(name)
        return if (need == null || phone !in need.phones) false
        else {
            need.phones -= phone
            true
        }
    }

    /**
     * Вернуть все номера телефона заданного человека.
     * Если этого человека нет в книге, вернуть пустой список
     */
    fun phones(name: String): Set<String> {
        val need = SearchName(name)
        return need?.phones ?: setOf<String>()
    }

    /**
     * Вернуть имя человека по заданному номеру телефона.
     * Если такого номера нет в книге, вернуть null.
     */
    fun humanByPhone(phone: String): String? = SearchPhone(phone)?.name

    /**
     * Две телефонные книги равны, если в них хранится одинаковый набор людей,
     * и каждому человеку соответствует одинаковый набор телефонов.
     * Порядок людей / порядок телефонов в книге не должен иметь значения.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) true
        if (other !is PhoneBook) return false

        var OtherCount = 0
        var current = other.start
        while (current != null) {
            if (current.phones != SearchName(current.name)?.phones)
                return false
            current = current.next
            OtherCount++
        }

        var OurCount = 0
        current = start
        while (current != null) {
            current = current.next
            OurCount++
        }
        return OurCount == OtherCount
    }
}