package task8;

import java.util.*;

public class DaysOfWeek {

    private List<String> getList() {
        return List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
    }


    public final List<String> getDaysOfWeek() {
        return this.getList();
    }

    public final Set<String> getTreeSet() {
        return new TreeSet<>(this.getList());
    }

    public final Set<String> getHashSet() {
        return new HashSet<>(this.getList());
    }

    public void printEverySecondElement(final Iterator<String> iterator) {
        int index = 0;
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (index % 2 == 0) {
                System.out.println(element);
            }
            index++;
        }
    }

}
