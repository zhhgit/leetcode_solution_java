package algorithm1.sortAndSearch;

public class FirstBadVersion {

    private static boolean[] nums = {false,false,false,true,true};

    public static void main(String[] args) {
        int len = nums.length;
        System.out.println(firstBadVersion(len));
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right){
            // 推荐
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean isBadVersion(int version){
        return nums[version - 1];
    }
}
