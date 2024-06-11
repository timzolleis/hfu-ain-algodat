package task6;

import org.junit.jupiter.api.Test;
import task5.MergeSort;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {

    private final PaymentMethod[] money = {
            new USD_Coin(0.10), new EUR_Bill(20), new SFR_Bill(5),
            new SFR_Coin(0.50), new USD_Coin(0.50), new EUR_Bill(50),
            new USD_Bill(100), new USD_Coin(0.2), new USD_Coin(0.25)
    };


    @Test
    void printPaymentMethods() {
        PaymentMethod[] invalidPaymentMethods = Arrays.stream(money).filter(method -> !method.isValid()).toArray(PaymentMethod[]::new);
        PaymentMethod[] validPaymentMethods = Arrays.stream(money).filter(PaymentMethod::isValid).toArray(PaymentMethod[]::new);
        //Assertions
        assertEquals(2, invalidPaymentMethods.length);
        assertEquals(7, validPaymentMethods.length);

    }

    @Test
    void accumulateByCurrency() {
        final HashMap<String, Double> currencyMap = new HashMap<>();
        Arrays.stream(money).filter(PaymentMethod::isValid).forEach(m -> currencyMap.merge(m.getCurrency(), m.getValue(), Double::sum));
        //Assertions
        assertEquals(100.85, currencyMap.get("USD"));
        assertEquals(70.0, currencyMap.get("EUR"));
        assertEquals(0.5, currencyMap.get("SFR"));
    }


    @Test
    void accumulateWeight() {
        final Coin[] validCoins = Arrays.stream(money).filter(PaymentMethod::isValid).filter(element -> element instanceof Coin).toArray(Coin[]::new);
        final double totalWeight = Arrays.stream(validCoins).mapToDouble(Coin::getWeight).sum();
        assertEquals(21.48, totalWeight);
    }

    @Test
    void accumulateArea() {
        final Bill[] validBilds = Arrays.stream(money).filter(PaymentMethod::isValid).filter(element -> element instanceof Bill).toArray(Bill[]::new);
        final double totalArea = Arrays.stream(validBilds).mapToDouble(bill -> bill.getLength() * bill.getWidth()).sum();
        assertEquals(30704.9002, totalArea);
    }

    @Test
    void accumulateCoinHeight() {
        final Coin[] validCoins = Arrays.stream(money).filter(PaymentMethod::isValid).filter(element -> element instanceof Coin).toArray(Coin[]::new);
        final double totalHeight = Arrays.stream(validCoins).mapToDouble(Coin::getThickness).sum();
        assertEquals(6.5, totalHeight);
    }

    @Test
    void sortTest(){
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(money);
        System.out.println(Arrays.toString(money));
        assertEquals(0.1, money[0].getValue());
        assertEquals(0.2, money[1].getValue());
        assertEquals(0.25, money[2].getValue());
        assertEquals(0.5, money[3].getValue());
        assertEquals(0.5, money[4].getValue());
        assertEquals(5, money[5].getValue());
        assertEquals(20, money[6].getValue());
        assertEquals(50, money[7].getValue());
        assertEquals(100, money[8].getValue());

    }

}


