package task8;

import java.util.ArrayList;
import java.util.List;

public class Prime {

    private final List<Integer> integers = new ArrayList<>();
    private final List<Integer> foundPrimes = new ArrayList<>();

    public Prime(final int n) {
        for (int i = 2; i <= n; i++) {
            integers.add(i);
        }
    }

    public List<Integer> getPrimes() {
        final List<Integer> primes = new ArrayList<>();
        while (!integers.isEmpty()) {
            primes.add(getNextPrime());
        }
        return primes;
    }

    public List<Integer[]> getPrimePairs() {
        if (foundPrimes.isEmpty()) {
            getPrimes();
        }
        final List<Integer[]> primePairs = new ArrayList<>();
        //Iterate through found primes, and check if the difference between the current prime and the previous prime is 2
        for (int i = 1; i < foundPrimes.size(); i++) {
            if (foundPrimes.get(i) - foundPrimes.get(i - 1) == 2) {
                //If the difference is 2, add the pair to the list
                Integer[] pair = {foundPrimes.get(i - 1), foundPrimes.get(i)};
                primePairs.add(pair);
            }
        }
        return primePairs;
    }


    private int getNextPrime() {
        final int prime = integers.getFirst();
        integers.removeIf(i -> i % prime == 0);
        foundPrimes.add(prime);
        return prime;
    }


}
