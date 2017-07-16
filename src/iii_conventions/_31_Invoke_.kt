package iii_conventions

import util.TODO


class Invokable {
    var countInvocations = 0

    operator fun invoke() : Invokable {
        countInvocations++
        return this
    }

    fun getNumberOfInvocations() = countInvocations
}

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change class Invokable to count the number of invocations (round brackets).
        Uncomment the commented code - it should return 4.
    """,
    references = { invokable: Invokable -> })

fun task31(invokable: Invokable): Int {
    return invokable()()()().getNumberOfInvocations()
}
