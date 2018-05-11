package session3.q093_restore_ip_addresses;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String[] sArr = {"010010","25525511135"};
        for(String s:sArr){
            System.out.println(restoreIpAddresses(s));
        }
    }

    private static List<String> restoreIpAddresses(String s) {
        List<String> list = new LinkedList<>();
        int len = s.length();
        if(len == 0 || len > 12){
            return list;
        }
        List<String> tempList = new LinkedList<>();
        backTracking(list,tempList,s,0);
        return list;
    }

    private static void backTracking(List<String> list,List<String> tempList,String s,int pos){
        int len = s.length();
        if(pos >= len){
            if(tempList.size() == 4){
                list.add(listToStr(tempList));
            }
        }
        else{
            for(int i = 1;i <= 3;i++){
                if(pos + i <= len){
                    String tempStr = s.substring(pos,pos + i);
                    if(validIpAddress(tempStr)){
                        tempList.add(tempStr);
                        backTracking(list,tempList,s,pos + i);
                        if(tempList.size() > 0){
                            tempList.remove(tempList.size() - 1);
                        }
                    }
                }

            }
        }
    }

    private static String listToStr(List<String> list){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<list.size();i++){
            stringBuilder.append(list.get(i));
            if(i != list.size()-1){
                stringBuilder.append(".");
            }
        }
        return stringBuilder.toString();
    }

    private static boolean validIpAddress(String s){
        if(s.length() > 3){
            return false;
        }
        int i = Integer.parseInt(s);
        return (i <= 255 && i >= 0) && s.equals(i + "");
    }
}