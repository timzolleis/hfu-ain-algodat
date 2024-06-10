package task8;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrimeTest {

    @Test
    void getPrimes() {
        final Prime prime = new Prime(1000);
        final List<Integer> primes = prime.getPrimes();
        primes.forEach(primeNumber -> assertTrue(isPrime(primeNumber)));
        assertEquals(168, primes.size());
    }

    @Test
    void getPrimePairs() {
        final Prime prime = new Prime(1000);
        final List<Integer[]> primePairs = prime.getPrimePairs();
        assertEquals(35, primePairs.size());
        primePairs.forEach(pair -> assertEquals(2, pair[1] - pair[0]));
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}