package practices.performance;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public class Prc1 {

    public void doPrc(List aList) {

        if (aList instanceof RandomAccess) {
            for (int i = 0; i < aList.size(); i++) {
                System.out.println(aList.get(i));
            }
        } else {
            Iterator<?> iter = aList.iterator();
            while (iter.hasNext()) {
                System.out.println(iter.next());
            }

        }

    }


    public static void main(String[] args) {
        int loopTime = 50000;
        Integer i = 0;
        long startTime = System.currentTimeMillis();
        for (int j = 0; j < loopTime; j++) {
            String str = String.valueOf(i);
        }
        System.out.println("String.valueOf:" + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int j = 0; j < loopTime; j++) {
            String str = i.toString();
        }
        System.out.println("toString:" + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int j = 0; j < loopTime; j++) {
            String str = i + "";
        }
        System.out.println("i + \"\":" + (System.currentTimeMillis() - startTime) + "ms");


    }
}
