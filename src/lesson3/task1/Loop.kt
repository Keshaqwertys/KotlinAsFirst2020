@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.sqrt

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var number = abs(n)
    var i: Int = 0
    do {
        i = i + 1
        number = number / 10
    } while (number > 0)
    return i

}

/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var k:Int = 2
    var n1: Int = 1
    var n2: Int = 1
    var sum: Int = 0
    if (n <= 2) return 1
    while (n > k) {
        k += 1
        sum = n1 + n2
        n1 = n2
        n2 = sum
    }
    return sum
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var i:Int = 1
    while (i < n){
        i += 1
        if (n % i == 0) break
    }
    val minD:Int = i
    return minD
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var i: Int = 0
    var maxD: Int = 0
    while(i < n){
        i += 1
        if (i == n) break
        if (n % i == 0) maxD = i
        else maxD = maxD
    }
    return maxD
}

/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var i: Int = 0
    var xD = x
    while (xD != 1) {
        i += 1
        if (xD % 2 == 0) xD = xD / 2
        else xD = 3 * xD + 1
    }
return i
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var i: Int = 0
    while (true){
        i += 1
        if ((i % m == 0) and (i % n == 0)) break
    }
    return i
}

/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var i: Int = 1
    var result: Boolean = true
    val maxMN = Math.max(m,n)
    while (i < maxMN){
        i += 1
        if ((m % i == 0) and (n % i == 0))
        {
            result = false
            break
        }
        else result = true
        }
    return result
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean = TODO()

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var revNum = 0
    var number = n
    while (number > 0){
        revNum = revNum * 10 + number % 10
        number = number / 10
    }
    return revNum
}

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var number: Int = n
    var revNum: Int = 0
    while (number > 0){
        revNum = revNum * 10 + number % 10
        number = number / 10
    }
    if (revNum == n) return true
    else return false
}

/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var result:Boolean = false
    var number: Int = n
    var numeral = number % 10
    number /= 10
    while(number > 0) {
        if (number % 10 != numeral) result = true
        number /= 10
    }
    if (result == true) return true
    else return false
}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double {
    var xC = abs(x) % (2 * PI)
    if (x < 0) xC = xC * (-1)
    var i: Double = 2.0
    var f: Double = 1.0
    var factorial: Double = 1.0
    var sqr = xC * xC
    var result: Double = 0.0
    var promResult: Double = xC
    while(abs(promResult) >= eps){
        result = result + promResult * f
        f = f * (-1.0)
        factorial = factorial * (i * (i + 1.0))
        promResult = ((xC * sqr) / factorial)
        sqr = sqr * (xC * xC)
        i += 2.0
    }
    return result
}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double {
    var xC = abs(x) % (2 * PI)
    if (x < 0) xC = xC * (-1)
    var i: Double = 2.0
    var f: Double = 1.0
    var factorial: Double = 1.0
    var sqr = xC * xC
    var result: Double = 0.0
    var promResult: Double = 1.0
    while(abs(promResult) >= eps){
        result = result + promResult * f
        f = f * (-1.0)
        factorial = factorial * (i * (i - 1.0))
        promResult = (sqr / factorial)
        sqr = sqr * (xC * xC)
        i += 2.0
    }
    return result
}

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var result: Int = 0
    var i: Int = 0
    var j: Int = 0
    var k: Int = 0
    var d: Int
    var sum: Int = 0
    var preSum: Int = 0
    var range: Int
    var need: Int
    while (sum < n){
        i = i + 1
        k = i * i
        d = k
        j = 0
        while (d > 0){
            d = d / 10
            j += 1
        }
        preSum = sum
        sum = sum + j
    }
    range = sum - preSum
    need = n - preSum
    if (range == need) result = k % 10
    else while (range > need){
        k = k / 10
        result = k % 10
        range = range - 1
    }
    return result
}

/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var result: Int = 0
    var n: Int = n
    var j: Int = 0
    var k: Int = 0
    var d: Int
    var sum: Int = 0
    var preSum: Int = 0
    var range: Int
    var need: Int
    var fib1 = 1
    var fib2 = 1
    if (n <= 2) {
        sum = 2
        preSum = 1
        n = 4
        k = 1
    }
    else {
        while (sum < (n - 2)){
            k = fib1 + fib2
            fib1 = fib2
            fib2 = k
            d = k
            j = 0
            while (d > 0){
                d = d / 10
                j += 1
            }
            preSum = sum
            sum = sum + j
        }
    }
    range = sum - preSum
    need = (n - 2) - preSum
    if (range == need) result = k % 10
    else while (range > need){
        k = k / 10
        result = k % 10
        range = range - 1
    }
    return result
}
