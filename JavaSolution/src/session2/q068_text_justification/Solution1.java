package session2.q068_text_justification;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 60;
        System.out.println(fullJustify(words,maxWidth));
    }

    private static int pos = 0;

    public static List<String> fullJustify(String[] words, int maxWidth) {
        int len =  words.length;
        List<String> list = new LinkedList<>();
        while (pos < len){
            getEachStr(words,maxWidth,list);
        }
        return list;
    }

    //获取每一行的list，并将List<String>转换为String
    private static void getEachStr(String[] words,int maxWidth,List<String> list){
        int i = pos;
        int len = words.length;
        List<String> temp = new LinkedList<>();
        int count = 0;
        int strLen = 0;
        while (i < len && strLen + words[i].length() + count <= maxWidth){
            String word = words[i];
            temp.add(word);
            count++;
            strLen += word.length();
            i++;
        }
        pos = i;
        if(pos == len){
            list.add(getLastStr(temp,maxWidth));
        }
        else{
            list.add(getNormalStr(temp,maxWidth));
        }
    }

    //普通行
    private static String getNormalStr(List<String> list,int maxWidth){
        StringBuffer stringBuffer = new StringBuffer();
        int len = list.size();
        if(len == 1){
            stringBuffer.append(list.get(0));
            for(int i=0;i<maxWidth-list.get(0).length();i++){
                stringBuffer.append(" ");
            }
        }
        else{
            int spanLen = maxWidth - strLen(list);
            int spanCount = list.size() - 1;
            int remain = spanLen % spanCount;
            int each = spanLen / spanCount;
            String averageSpan = getSpan(each);
            for(int i = 0;i<list.size();i++){
                stringBuffer.append(list.get(i));
                if(i != list.size()-1){
                    stringBuffer.append(averageSpan);
                    if(i < remain){
                        stringBuffer.append(" ");
                    }
                }
            }
        }
        return stringBuffer.toString();
    }

    //最后一行
    private static String getLastStr(List<String> list,int maxWidth){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i<list.size();i++){
            stringBuffer.append(list.get(i));
            if(i != list.size()-1){
                stringBuffer.append(" ");
            }
        }
        stringBuffer.append(getSpan(maxWidth - stringBuffer.length()));
        return stringBuffer.toString();
    }

    //获取list中所有字符串的总长度
    private static int strLen(List<String> list){
        int len = 0;
        for(int i = 0;i<list.size();i++){
            len += list.get(i).length();
        }
        return len;
    }

    //长度为span的空白字符串
    private static String getSpan(int span){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<span;i++){
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
