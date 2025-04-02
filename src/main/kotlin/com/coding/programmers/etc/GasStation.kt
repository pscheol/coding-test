package com.coding.programmers.etc


fun main() {
    val sol = GasStation()
    println(sol.solution(intArrayOf(2, 8, 4, 3, 2), 7, 11, 3)) // Output: 8
    println(sol.solution(intArrayOf(5), 4, 0, 3)) // Output: -1
}


class GasStation {
    private lateinit var busyDispensers: BooleanArray
    private lateinit var dispenserCapacity: IntArray
    private lateinit var dispenserAvailability: BooleanArray

    private lateinit var timeAvailable: IntArray
    private lateinit var timeDispensers: IntArray

    private lateinit var cars: IntArray

    private var minTimeSpent = 0
    private val nextAvailableTimes = mutableListOf<Int>()

    fun solution(A: IntArray, X: Int, Y: Int, Z: Int): Int {

        // Initializing variables
        init(A, X, Y, Z)

        // While we have cars in the line...
        while (cars.isNotEmpty()) {
            val carDemand = cars.first()

            // Get the next available fuel dispenser
            val numDispenser = getNextAvailableDispenser(carDemand)

            // If we got the dispenser for the car, we remove it from the line.
            if (numDispenser >= 0) {
                cars = cars.drop(1).toIntArray()  // Remove the first element
            } else {

                // Verify the minimum next available time that some dispensers will be available
                minTimeSpent = nextAvailableTimes.minOrNull() ?: 0

                // Remove the minTimeSpent from the list
                nextAvailableTimes.removeAll { it == minTimeSpent }

                // Update which dispensers will be available next
                busyDispensers = BooleanArray(3) { index -> timeAvailable[index] > minTimeSpent }
            }

            // If by chance there are no dispensers available, the function should finish with -1
            if (!dispenserAvailability.any { it }) return -1
        }

        // Return the maximum amount of time a car remained in the queue.
        return timeDispensers.maxOrNull() ?: 0
    }

    private fun getNextAvailableDispenser(fuelDemand: Int): Int {

        for (i in 0..2) {
            // Verify if the dispenser is available and has enough capacity
            if (!busyDispensers[i] && dispenserCapacity[i] >= fuelDemand) {
                busyDispensers[i] = true
                dispenserCapacity[i] -= fuelDemand
                timeAvailable[i] += fuelDemand
                timeDispensers[i] = minTimeSpent
                nextAvailableTimes.add(minTimeSpent + fuelDemand)
                return i
            } else if (!busyDispensers[i] && dispenserCapacity[i] < fuelDemand) {
                dispenserAvailability[i] = false
            }
        }
        return -1
    }

    private fun init(A: IntArray, X: Int, Y: Int, Z: Int) {
        cars = A
        busyDispensers = BooleanArray(3) { false }
        dispenserAvailability = BooleanArray(3) { true }

        dispenserCapacity = intArrayOf(X, Y, Z)
        timeAvailable = intArrayOf(0, 0, 0)
        timeDispensers = intArrayOf(0, 0, 0)

        minTimeSpent = 0
        nextAvailableTimes.clear()
    }
}