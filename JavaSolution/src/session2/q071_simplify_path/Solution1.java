package session2.q071_simplify_path;

import java.util.LinkedList;

public class Solution1 {
    public static void main(String[] args){
        String[] paths = {"/home//foo/","/home/","/a/./b/../../c/","/../","/","/..."};
        for(String path:paths){
            System.out.println(simplifyPath(path));
        }
    }

    private static String simplifyPath(String path) {
        LinkedList<String> linkedList = new LinkedList<>();
        String[] pathArr = path.split("/");
        for(int i=0;i<pathArr.length;i++){
            if(pathArr[i].equals( "..") && linkedList.size() > 0){
                linkedList.remove(linkedList.size() -1);
            }
            else if(!pathArr[i].equals("") && !pathArr[i].equals(".") && !pathArr[i].equals("..") && !pathArr[i].equals( "/")){
                linkedList.add(pathArr[i]);
            }
        }
        return getRetStr(linkedList);
    }

    private static String getRetStr(LinkedList<String> linkedList){
        StringBuffer sb = new StringBuffer();
        if(linkedList.size() == 0){
            return "/";
        }
        for(int i=0;i<linkedList.size();i++){
            sb.append('/');
            sb.append(linkedList.get(i));
        }
        return sb.toString();
    }
}