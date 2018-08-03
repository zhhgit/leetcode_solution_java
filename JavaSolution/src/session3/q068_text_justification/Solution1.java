package session3.q068_text_justification;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String[] words = {"Listen","to","many,","speak","to","a","few."};
        int maxWidth = 6;
        List<String> result = fullJustify(words,maxWidth);
        for (int i = 0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }

    private static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new LinkedList<>();
        List<String> tempList = new LinkedList<>();
        for (int i = 0;i<words.length;i++){
            if (ableToPut(tempList,words[i],maxWidth)){
                tempList.add(words[i]);
            }
            else {
                list.add(placeWords(tempList,maxWidth));
                tempList.clear();
                tempList.add(words[i]);
            }
        }
        if (tempList.size() > 0){
            list.add(placeLastLine(tempList,maxWidth));
        }
        return list;
    }

    // 确定了哪几个字符串放在一行后，放置到合适的位置
    private static String placeWords(List<String> tempList,int maxWidth){
        if (tempList.size() == 1){
            return placeSingleWord(tempList.get(0),maxWidth);
        }
        int allLen = 0;
        for (String item:tempList){
            allLen += item.length();
        }
        int spaceLeft = maxWidth - allLen;
        StringBuilder stringBuilder = new StringBuilder();
        int sameSpace = spaceLeft / (tempList.size() - 1);
        int addOneSpaceNum = spaceLeft % (tempList.size() - 1);
        for (int i = 0;i < tempList.size() - 1;i++){
            stringBuilder.append(tempList.get(i));
            for (int j = 0;j<sameSpace;j++){
                stringBuilder.append(" ");
            }
            if (i < addOneSpaceNum){
                stringBuilder.append(" ");
            }
        }
        stringBuilder.append(tempList.get(tempList.size() - 1));
        return stringBuilder.toString();
    }

    // 只有单个字符串
    private static String placeSingleWord(String word, int maxWidth){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(word);
        for (int i = 0;i<maxWidth - word.length();i++){
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    // 最后一行
    private static String placeLastLine(List<String> words,int maxWidth){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i<words.size() - 1;i++){
            stringBuilder.append(words.get(i) + " ");
        }
        stringBuilder.append(words.get(words.size() - 1));
        int spaceLeft = maxWidth - stringBuilder.length();
        for (int i = 0;i<spaceLeft;i++){
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    // 是否可以再放一个字符串到tempList中
    private static boolean ableToPut(List<String> tempList,String nextStr,int maxWidth){
        int allLen = 0;
        for (String item:tempList){
            allLen += item.length();
        }
        allLen += nextStr.length();
        int spaceLeft = maxWidth - allLen;
        return (spaceLeft >= tempList.size());
    }
}
