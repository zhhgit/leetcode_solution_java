package session1.q071_simplify_path;

import java.util.*;

public class Solution1 {
    public static void main(String[] args){
        String[] strArr = {"/home//foo/","/home/","/a/./b/../../c/","/../","/"};
        for(int i=0;i<strArr.length;i++){
            System.out.println(simplifyPath(strArr[i]));
        }
    }

    private static String simplifyPath(String path) {
        StringBuffer sb = new StringBuffer();
        List<String> list = new LinkedList<>();
        String[] eachArr = path.split("/");
        HashSet<String> hs = new HashSet<>(Arrays.asList(".",".."));
        for(int i=0;i<eachArr.length;i++){
            if((!hs.contains(eachArr[i])) && (!eachArr[i].equals(""))){
                list.add(eachArr[i]);
            }
            else if((eachArr[i].equals("..")) && (list.size() > 0)){
                list.remove(list.size()-1);
            }
        }
        if(list.size()==0){
            sb.append("/");
            return sb.toString();
        }
        else{
            for(int i=0;i<list.size();i++){
                sb.append("/");
                sb.append(list.get(i));
            }
            return sb.toString();
        }
    }
}
