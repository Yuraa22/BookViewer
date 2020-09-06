package practice.task.bookViewer.utility

object Utility {
    public fun checkIsbn(isbn: String): Boolean {
        var result = false
        var digitIsbn = isbn.replace("-", "")
        if (digitIsbn.length != 13 || !Regex("^\\d*$").matches(digitIsbn))
            return result

        var sum = 0
        var weight = 1

        for (i in 0 until digitIsbn.length - 1) {
            val digit = digitIsbn[i].toInt() - '0'.toInt()
            sum += digit * weight
            weight = 4 - weight
        }

        var lastDigit = digitIsbn[digitIsbn.length - 1].toInt() - '0'.toInt()

        var checkDigit = sum % 10

        if (checkDigit == 0) {
            if (lastDigit == 0)
                result = true
        } else if (10 - checkDigit == lastDigit)
            result = true

        return result
    }
}