fun countPrimes(n: Int): Int {
    //use sieve of eratosthenes
    if (n < 3) {
        return 0
    }
    var primeCount = 0
    var sieve = IntArray(n + 1) { 1 }
    for (num in 2 until n) {
        if (sieve[num] == 1) {
            //this is prime number
            for (j in num * 2 until n step num) {
                sieve[j] = 0
            }
            ++primeCount
        }
    }
    return primeCount
}


fun main() {
    print(countPrimes(5000000))
}