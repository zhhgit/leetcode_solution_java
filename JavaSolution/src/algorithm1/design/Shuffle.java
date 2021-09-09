package algorithm1.design;

import java.util.Arrays;

public class Shuffle {

    private static int[] origin;

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Shuffle shuffle = new Shuffle(nums);
        System.out.println(Arrays.toString(shuffle.shuffle()));
        System.out.println(Arrays.toString(shuffle.reset()));
        System.out.println(Arrays.toString(shuffle.shuffle()));
    }

    public Shuffle(int[] nums) {
        origin = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public static int[] reset() {
        return origin;
    }

    /** Returns a random shuffling of the array. */
    public static int[] shuffle() {
        int len = origin.length;
        boolean[] flag = new boolean[len];
        int[] ret = new int[len];
        int randomPos;
        int i = 0;
        while (i < len){
            do{
                randomPos = (int) Math.floor(Math.random() * len);
                if (!flag[randomPos]){
                    ret[i++] = origin[randomPos];
                    flag[randomPos] = true;
                }
            }
            while (!flag[randomPos]);
        }
        return ret;
    }
}
