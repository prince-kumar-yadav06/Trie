import java.util.*;

public class CountUniqueSubString {
    
    static class Node{

        Node children[];
        boolean EndOfWord;

        Node(){

            children=new Node[26];
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            EndOfWord=false;
        }
    }

    static Node root=new Node();

    static void Insert(String str){

        Node curr=root;

        for(int i=0;i<str.length();i++){

            int idx=str.charAt(i)- 'a';

            if(curr.children[idx] == null){
                curr.children[idx]=new Node();
            }

            if(i == str.length()-1){
                curr.children[idx].EndOfWord=true;
            }
            
            curr=curr.children[idx];
        }

    }

    
    //stp 1 create find suffix
    static int  CountSubstring(Node root){

      if(root ==  null){
        return 0;
      }

      int count=0;
       

        for(int i=0;i<26;i++){

            if(root.children[i] != null){
                count += CountSubstring(root.children[i]);
            }
        }
        return count +1;

    }
    public static void main(String args[]){

        String str="ababa";

        for(int i=0;i<str.length();i++){

            String curr=str.substring(i);

            Insert(curr);
        }

        System.out.println(CountSubstring(root));
    }
}
