package session2.q093_restore_ip_addresses;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String[] strs = {"010010","25525511135"};
        for(String s:strs){
            System.out.println(restoreIpAddresses(s));
        }
    }

    private static List<String> restoreIpAddresses(String s) {
        List<String> lists = new LinkedList<>();
        List<Integer> tempList = new LinkedList<>();
        List<List<Integer>> tempListContainer = new LinkedList<>();
        int len = s.length();
        if(len > 12 || len < 4){
            return lists;
        }
        getEachNum(s,1,tempList,tempListContainer);
        for(int i=0;i<tempListContainer.size();i++){
            lists.add(getIpStr(tempListContainer.get(i)));
        }
        return lists;
    }

    //获得第num个IP段
    private static void getEachNum(String s,int num,List<Integer> tempList,List<List<Integer>> tempListContainer){
        if(tempList.size() == 4 && s.equals("")){
            List<Integer> addList = new LinkedList<>(tempList);
            tempListContainer.add(addList);
            return;
        }
        if(tempList.size() == 4 && !s.equals("")){
            return;
        }
        int len = s.length();
        int remainMin = (4-num);
        int remainMax = (4-num) * 3;
        for(int i=0;i<3;i++){
            int strEnd = (i+1) > s.length() ? s.length() : i+1;
            String str = s.substring(0,strEnd);
            if(!isPureNum(str)){
                continue;
            }
            int ip = Integer.parseInt(str);
            int remainLen = len-(i+1);
            if(validIp(ip) && remainLen >= remainMin && remainLen <= remainMax){
                tempList.add(ip);
                getEachNum(s.substring(i+1),num+1,tempList,tempListContainer);
                if(tempList.size() > 0){
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }

    //是否有效IP地址
    private static boolean validIp(int num){
        return num >= 0 && num <= 255;
    }

    //字符串是绝对的数字，不存在021等情况
    private static boolean isPureNum(String str){
        int num = Integer.parseInt(str);
        String convertStr = Integer.toString(num);
        return convertStr.equals(str);
    }

    //将list转化为字符串
    private static String getIpStr(List<Integer> nums){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<nums.size();i++){
            sb.append(nums.get(i));
            sb.append(".");
        }
        String ret = sb.toString();
        return ret.substring(0,ret.length()-1);
    }
}