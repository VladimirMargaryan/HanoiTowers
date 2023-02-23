package com.mobiledev.hanoitowers

fun main(args: Array<String>) {
    hanoiTower(3)
}

fun hanoiTower(n: Int) {
    val stack = mutableListOf<Pair<Int, Pair<Int, Int>>>()
    stack.add(Pair(n, Pair(1, 3)))

    while (stack.isNotEmpty()) {
        val pair = stack.removeAt(stack.lastIndex)
        val disksNumber = pair.first
        val fromPeg = pair.second.first
        val toPeg = pair.second.second

        when (disksNumber) {
            1 -> {
                println("Moved disk 1 from $fromPeg peg into $toPeg peg")
            }
            else -> {
                val auxPeg = 6 - fromPeg - toPeg
                stack.add(Pair(disksNumber - 1, Pair(fromPeg, auxPeg)))
                stack.add(Pair(1, Pair(fromPeg, toPeg)))
                stack.add(Pair(disksNumber - 1, Pair(auxPeg, toPeg)))
            }
        }
    }
}