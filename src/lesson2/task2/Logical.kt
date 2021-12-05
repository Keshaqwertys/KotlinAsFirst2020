@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая (2 балла)
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    val sumOne: Int = (number / 1000) + (number % 1000 / 100)
    val sumTwo: Int = (number % 100 / 10) + (number % 10)
    return sumOne == sumTwo
}

/**
 * Простая (2 балла)
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    val dangerOne = (x1 == x2) || (y1 == y2)
    val changeX = x1 - x2
    val changeY = y1 - y2
    val dangerTwo = (Math.abs(changeX) == Math.abs(changeY))
    return when {
        dangerOne || dangerTwo -> true
        else -> false
    }
}


/**
 * Простая (2 балла)
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    return when {
        (month in 1..7) && (month % 2 != 0) -> 31
        (month in 8..12) && (month % 2 == 0) -> 31
        month == 2 -> when {
            (year % 4 != 0) -> 28
            (year % 100 == 0) && (year % 400 != 0) -> 28
            else -> 29
        }
        else -> 30
    }
}

/**
 * Простая (2 балла)
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean {
    val distance = Math.sqrt(Math.pow((x1 - x2), 2.0) + Math.pow((y1 - y2), 2.0))
    return distance <= r2 - r1
}

/**
 * Средняя (3 балла)
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    val minRS = Math.min(r, s)
    val maxRS = Math.max(r, s)
    val maxABC = when {
        (a >= b) && (a >= c) -> a
        (b >= a) && (b >= c) -> b
        else -> c
    }
    val minABC = when {
        (a <= b) && (a <= c) -> a
        (b <= a) && (b <= c) -> b
        else -> c
    }
    val avgABC = when (minABC) {
        a -> Math.min(b, c)
        b -> Math.min(a, c)
        else -> Math.min(a, b)
    }
    val result = when {
        (minABC <= minRS) && (avgABC <= maxRS) -> true
        else -> false
    }
    return result
}
