package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (year != other.year) {
            return year.compareTo(other.year)
        } else if (month != other.month) {
            return month.compareTo(other.month)
        } else {
            return dayOfMonth.compareTo(other.dayOfMonth)
        }
    }
}

operator fun DateRange.iterator() = object : Iterator<MyDate> {
    var index = start

    override fun hasNext(): Boolean = index <= endInclusive

    override fun next(): MyDate {
        val oldIndex = index
        index = index.nextDay()
        return oldIndex
    }

}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) {
    operator fun contains(d: MyDate): Boolean = d >= start && d <= endInclusive
}
