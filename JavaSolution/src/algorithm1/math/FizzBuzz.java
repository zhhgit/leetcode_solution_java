package algorithm1.math;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        int n = 15;
        List<String> ret = fizzBuzz(n);
        System.out.println(ret.toString());
    }

    public static List<String> fizzBuzz(int n) {
        String fizz = "Fizz";
        String buzz = "Buzz";
        String fizzbuzz = fizz + buzz;
        List<String> ret = new ArrayList<>();
        for (int i = 1; i<= n; i++){
            if ((i % 3 == 0) && (i % 5 == 0)){
                ret.add(fizzbuzz);
            }
            else if (i % 3 == 0){
                ret.add(fizz);
            }
            else if (i % 5 == 0){
                ret.add(buzz);
            }
            else {
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }
}
