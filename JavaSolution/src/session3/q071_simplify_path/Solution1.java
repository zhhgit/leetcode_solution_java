package session3.q071_simplify_path;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args){
        String[] pathArr = {"/a/./b/../../c/","/../","/home/","/home//foo/","/.","/..."};
        for(String path:pathArr){
            System.out.println(simplifyPath(path));
        }
    }

    private static String simplifyPath(String path) {
        List<String> list = new LinkedList<>();
        String[] arr = path.split("/");
        for(int i = 0;i<arr.length;i++){
            if(arr[i].equals("..")){
                if(list.size() > 0){
                    list.remove(list.size()-1);
                }
            }
            else if(!arr[i].equals("") && !arr[i].equals(".")){
                list.add(arr[i]);
            }
        }
        return getPathFromList(list);
    }

    private static String getPathFromList(List<String> list){
        if(list.size() == 0){
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<list.size();i++){
            stringBuilder.append("/");
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();
    }
}
