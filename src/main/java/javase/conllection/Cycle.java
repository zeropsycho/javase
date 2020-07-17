package javase.conllection;

import java.util.ArrayList;
import java.util.Iterator;

/**
    *循环遍历
 * */


public class Cycle {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(10);

        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }

        Iterator iterator = arrayList.listIterator();
        /*while (iterator.hasNext()) {
            Object a = iterator.next();
            if (("1").equals(a.toString())) {
                iterator.remove();
                continue;
            }
            System.out.println(a);
        }*/

        /**
         * while to for
         */
        for (Iterator iteratora = arrayList.listIterator(); iteratora.hasNext();) {
            System.out.println(iteratora.next());
        }
    }
}
