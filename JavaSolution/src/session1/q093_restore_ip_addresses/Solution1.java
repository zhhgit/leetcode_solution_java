package session1.q093_restore_ip_addresses;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        String[] sArr ={"25525511135","11111","0000","010010"};
        for(String s:sArr){
            System.out.println(restoreIpAddresses(s));
        }
    }

    private static List<String> restoreIpAddresses(String s) {
        List<String> list = new LinkedList<>();
        LinkedList<Integer> tempList = new LinkedList();
        backTracking(list,tempList,s,s.length()-1,4);
        return list;
    }

    private static void backTracking(List<String> list,LinkedList<Integer> tempList,String s,int pos,int remain){
        int remainLen = (s.substring(0,pos+1)).length();
        if(3*remain<remainLen){
            return;
        }
        else if(remain==0 && pos==-1){
            storeString(list,tempList);
        }
        else{
            for(int i=0;i<3;i++){
                if(pos-i>=0){
                    if(i==0 || (i!=0 && s.charAt(pos-i)!='0')){
                        if(Integer.parseInt(s.substring(pos-i,pos+1))<=255){
                            int insertVal = Integer.parseInt(s.substring(pos-i,pos+1));
                            tempList.add(insertVal);
                            backTracking(list,tempList,s,pos-i-1,remain-1);
                            tempList.remove(tempList.size()-1);
                        }
                    }
                }
            }
        }
    }

    private static void storeString(List<String> list,LinkedList<Integer> tempList){
        StringBuffer sb = new StringBuffer();
        for(int i=3;i>0;i--){
            sb.append(String.valueOf(tempList.get(i)));
            sb.append(".");
        }
        sb.append(String.valueOf(tempList.get(0)));
        list.add(sb.toString());
    }
}
