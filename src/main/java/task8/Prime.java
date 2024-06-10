package task8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Prime {

    private final Set<Integer> integers = new TreeSet<>();
    private final List<Integer> foundPrimes = new ArrayList<>();

    public Prime(final int n) {
        for (int i = 2; i <= n; i++) {
            integers.add(i);
        }
    }

    public List<Integer> getPrimes() {
        while (!integers.isEmpty()) {
            getNextPrime();
        }
        return foundPrimes;
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


    private void getNextPrime() {
        final int prime = integers.iterator().next();
        integers.removeIf(i -> i % prime == 0);
        foundPrimes.add(prime);
    }


}
