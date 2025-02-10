package opgave03;

import opgave03.models.ArrayListRing;
import opgave03.models.Ring;

public class Opgave03 {
    public static void main(String[] args) {

        Ring<String> ring = new ArrayListRing<>();

        ring.add("A");
        ring.add("B");
        ring.add("C");

        System.out.println("Current: " + ring.getCurrentItem()); // C
        ring.advance();
        System.out.println("Current: " + ring.getCurrentItem()); // A

        ring.removeItem("B");
        System.out.println("Size after remvoving B: " + ring.size()); //2

        ring.removeCurrentItem();
        System.out.println("New current after removing C: " + ring.getCurrentItem());
    }
}
