package session3.q043_multiply_strings;

public class Solution1 {
    public static void main(String[] args){
        String str1 = "0";
        String str2 = "0";
        System.out.println(multiply(str1,str2));
    }

    private static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int[] arr = new int[len1 + len2];
        int[] formatArr = new int[len1 + len2];
        for(int i=0;i<arr.length;i++){
            int sum = 0;
            for(int j = 0;j<=i;j++){
                if(validIndex(len1,len2,j,i-j)){
                    char c1 = num1.charAt(len1 - 1 - j);
                    char c2 = num2.charAt(len2 - 1 - (i-j));
                    int c1Num = c1 - '0';
                    int c2Num = c2 - '0';
                    sum += c1Num * c2Num;
                }
            }
            arr[i] = sum;
        }
        int increase = 0;
        for(int i=0;i<arr.length;i++){
            int sum = increase + arr[i];
            if(sum >= 10){
                increase = sum / 10;
                formatArr[i] = sum % 10;
            }
            else{
                formatArr[i] = sum;
                increase = 0;
            }
        }
        return getResultFromArr(formatArr);
    }

    private static boolean validIndex(int len1,int len2,int i,int j){
        return (i>=0 && i<len1 && j>=0 && j<len2);
    }

    private static String getResultFromArr(int[] arr){
        StringBuilder stringBuilder = new StringBuilder();
        int len = arr.length;
        int index = len - 1;
        while (index >=0 && arr[index] == 0){
            index--;
        }
        while (index >= 0){
            stringBuilder.append(arr[index]);
            index--;
        }
        return stringBuilder.toString();
    }
}
