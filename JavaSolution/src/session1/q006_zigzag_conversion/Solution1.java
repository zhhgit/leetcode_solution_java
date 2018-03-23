package session1.q006_zigzag_conversion;

public class Solution1 {
    public static void main(String[] args)
    {
        String inputStr = "PAYPALISHIRING";
        int row = 3;
        System.out.println(convert(inputStr,row));
    }

    public static String convert(String s, int numRows) {
        char[] sArray = s.toCharArray();
        String output = "";
        StringBuffer total = new StringBuffer();
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i=0;i<sb.length ;i++){
            sb[i] = new StringBuffer();
        }
        int i = 0;
        int j;
        int len = sArray.length;
        while(i < len){
            for(j = 0; (j<=numRows-1)&&(i<len) ; j++){
                sb[j].append(sArray[i]);
                i++;
            }
            for(j = numRows-2; (j > 0)&&(i < len); j--){
                sb[j].append(sArray[i]);
                i++;
            }
        }
        for (j = 0; j< numRows; j++){
            total.append(sb[j]);
        }
        output = total.toString();
        return output;
    }
}
