import com.barran.algorithm.matchstr.SundayMatcher;
import com.barran.algorithm.sort.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        testSort();

//        testMatch();
    }

    private static void testSort() {
        int[] array = new int[]{2, 1, 5, 9, 6, 8, 7, 3, 4, 7, 5};
//        new CountSort().sort(array);
//        new SelectSort().sort(array);
//        new ShellSort().sort(array);
        new NonRecursiveQuickSort().sort(array);

        System.out.println(Arrays.toString(array));
    }

    private static void testMatch() {
        String content = "abddaccdabcdabbdabbcabacadbdcbcdbabd";
        String pattern = "abcd";

       int index = new SundayMatcher().match(content, pattern);
//       int index = new KMPMatcher().match(content, pattern);
        System.out.println(index);
    }
}
