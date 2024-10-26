import java.util.*;

public class StartPrefix {
    
    static class Node{
        Node children[];
        boolean endOfWord;

        Node(){
            children=new Node[26];
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            endOfWord=false;
        }
    }

    static Node root=new Node();

    static void insertion(String word){

        Node curr=root;

        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';

            if(curr.children[idx] == null){
                 
                curr.children[idx]=new Node();
            }

            if(i == word.length()-1){
                curr.children[idx].endOfWord=true;
            }

            //update root
            curr=curr.children[idx];
        }
    }

    static boolean SearchPrefix(String key){

        Node curr=root;

        for(int i=0;i<key.length();i++){

            int idx=key.charAt(i) - 'a';

            Node node=curr.children[idx];

            if(node == null){
                return false;

            }
            //update root
            curr=curr.children[idx];
        }
        return true;
    }

    public static void main(String args[]){

        String words[]={"apple","app","mango","man","woman"};

        for(int i=0;i<words.length;i++){
            insertion(words[i]);
        }

        String str1="app";
        String str2="moon";

        System.out.println(SearchPrefix(str1));
        System.out.print(SearchPrefix(str2));
    }

}
