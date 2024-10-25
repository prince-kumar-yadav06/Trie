import java.util.*;

public class WordBreak {
    
static class Node{

    Node[] children;
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
static void insertio(String word){

    Node curr=root;

    for(int i=0;i<word.length();i++){

        int idx=word.charAt(i)- 'a';

        if(curr.children[idx] == null){

            curr.children[idx]=new Node();
        }

        if(i == word.length()-1){
            curr.children[idx].endOfWord=true;
        }

        curr=curr.children[idx];
    }

}

static boolean search(String key){

    Node curr=root;

    for(int i=0;i<key.length();i++){

        int idx=key.charAt(i)- 'a';

        Node node=curr.children[idx];

        if(node == null){
            return false;
        }
        if(i == key.length()-1 && node.endOfWord == false){
            return false;
        }
        
        // update root node
        curr=curr.children[idx];
    }
    return true;
}

// function to solve word break
static boolean WordBreak(String key){

    //base case
    if(key.length() == 0){
        return true;
    }

    // i=1 bcqz substring take i-1 index so i=1 then in substring only 0 index string store hoga
    for(int i=1;i<=key.length();i++){

        String firstPart=key.substring(0,i);
        String scndPart=key.substring(i);

        if(search(firstPart) && WordBreak(scndPart)){
            return true;
        }
    }
    return false;
}

public static void main(String args[]){

    String[] words={"i","like","sam","samsung","mobile","ice"};

    String key="ice";

    //insert words in trie
    for(int i=0;i<words.length;i++){
        insertio(words[i]);
    }

    // word break functio call
    System.out.println(WordBreak(key));
}
}
