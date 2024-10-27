import java.util.*;

public class LongestWordWithALLPrefix {
    
    static class Node{
        Node[] children;
        boolean endOfWord;

        public Node(){
            children=new Node[26];
            
            //assign chindren array as null
            for(int i=0;i<26;i++){
                children[i]=null;
            }

            //bydefault false hoga;
            endOfWord=false;
        }
    }
    static Node root=new Node();

    public static void Insertion(String word){

        Node curr=root;

        for(int i=0;i<word.length();i++){

            int idx=word.charAt(i)-'a';

            //root ka children at idx null hai to new Node create kr denge
            if(curr.children[idx]== null){
                // add new node
                curr.children[idx]=new Node();
            }

            //agar idx == word Length -1 hai mtlb word ka end char hai 
            if(i == word.length()-1){
                curr.children[idx].endOfWord=true;
            }

            // nhi  to root ko update kr denge 
            curr=curr.children[idx];
        }

    }

    static String ans=" ";

    static  void LongestWordPrefix(Node root,StringBuilder temp){

        if(root == null){
            return;
        }

        for(int i=0;i<26;i++){

            if(root.children[i] != null && root.children[i].endOfWord == true){

                temp.append((char)(i + 'a'));

                if(temp.length() > ans.length()){
                    ans= temp.toString();
                }

                LongestWordPrefix(root.children[i], temp);
                temp.deleteCharAt((temp.length()-1));
            }
        }
    }
    public static void main(String args[]){

        String words[]={"a","banana","app","appl","ap","apply"};

        for(int i=0;i<words.length;i++){
            Insertion(words[i]);
        }

        LongestWordPrefix(root,new StringBuilder(" "));
        System.out.println(ans);
    }

}
