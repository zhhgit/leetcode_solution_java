package q278_first_bad_version;

public class Solution1 {
    private static boolean[] versions = {true,true,false,false,false};

    public static void main(String[] args){
        System.out.println(firstBadVersion(versions.length));
    }

    private static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            //注意，当left和right都很大时，和可能溢出
            int middle = left + (right - left) / 2;
            if(!isBadVersion(middle)){
                left = middle + 1;
            }
            else{
                right = middle;
            }
        }
        return  left;
    }

    private static boolean isBadVersion(int version){
        return !versions[version-1];
    }
}
