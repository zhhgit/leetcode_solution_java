package session3.q022_generate_parentheses;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        int n = 4;
        System.out.println(generateParenthesis(n));
    }

    private static List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        if(n == 0){
            return list;
        }
        List<Character> tempList = new LinkedList<>();
        generate(n,0,0,list,tempList);
        return list;
    }

    private static void generate(int n,int left,int right,List<String> list,List<Character> tempList){
        if(left == n && right == n && tempList.size() == 2 * n){
            String addStr = getStrFromList(tempList);
            if(!list.contains(addStr)){
                list.add(addStr);
            }
        }
        else {
            if(left < n){
                tempList.add('(');
                generate(n,left+1,right,list,tempList);
                if(tempList.size() > 0){
                    tempList.remove(tempList.size()-1);
                }
            }
            if(right < left){
                tempList.add(')');
                generate(n,left,right+1,list,tempList);
                if(tempList.size() > 0){
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }

    private static String getStrFromList(List<Character> list){
        StringBuilder sb = new StringBuilder();
        for(Character c:list){
            sb.append(c);
        }
        return sb.toString();
    }
}
