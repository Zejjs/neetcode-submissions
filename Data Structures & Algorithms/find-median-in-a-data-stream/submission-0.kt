class MedianFinder {

    val highHalf = PriorityQueue<Int>()
    val lowHalf = PriorityQueue<Int>(Comparator.reverseOrder())

    fun addNum(num: Int) {
        if (lowHalf.isEmpty() || num <= lowHalf.peek()) {
            lowHalf.add(num)
        } else {
            highHalf.add(num)
        }
        
        if (lowHalf.size > highHalf.size + 1) {
            highHalf.add(lowHalf.poll())
        } else if (highHalf.size > lowHalf.size) {
            lowHalf.add(highHalf.poll())
        }
    }

    fun findMedian(): Double {
        return if (lowHalf.size == highHalf.size) {
            (lowHalf.peek().toDouble() + highHalf.peek().toDouble()) / 2.0
        } else {
            lowHalf.peek().toDouble()
        }
    }
}
