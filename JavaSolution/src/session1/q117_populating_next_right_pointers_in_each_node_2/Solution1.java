package session1.q117_populating_next_right_pointers_in_each_node_2;

import session1.common.*;
import java.util.LinkedList;

public class Solution1 {
    public static void main(String[] args){

    }

    public void connect(TreeLinkNode root) {
        LinkedList<TreeLinkNode> currList = new LinkedList<>();
        LinkedList<TreeLinkNode> nextList = new LinkedList<>();
        TreeLinkNode temp;
        if(root != null){
            currList.add(root);
            while (!currList.isEmpty()){
                for(int i=0;i< currList.size();i++){
                    if(currList.get(i).left!=null){
                        nextList.add(currList.get(i).left);
                    }
                    if(currList.get(i).right!=null){
                        nextList.add(currList.get(i).right);
                    }
                    if(i!=currList.size()-1){
                        currList.get(i).next = currList.get(i+1);
                    }
                    else{
                        currList.get(i).next = null;
                    }
                }
                currList.clear();
                currList = new LinkedList<TreeLinkNode>(nextList);
                nextList.clear();
            }
        }
    }
}
