public class TrieInsertion {
    
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

    public static void Insertion(String word){  // T.C=O(L)  L=length of keyword

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

    // search key in trie function
    public static boolean SearchKey(String key){  //T.C=O(L)  L=length of keyword

        Node curr=root;

        for(int i=0;i<key.length();i++){

            int idx=key.charAt(i)-'a';
            Node node=curr.children[idx];

            // agar character nhi to return kr denge false
            if(node == null){
                return false;
            }

            // agar word exist krta hai pr khatam nhi hua hai
            if( i == key.length()-1 && node.endOfWord == false){
                return false;
            }

            curr=curr.children[idx];
        }
        return true;
    }

    public static void main(String args[]){

        String words[]={"the","a","there","their","any"};

        for(int i=0;i<words.length;i++){
            Insertion(words[i]);
        }

        System.out.println(SearchKey("ther"));
        System.out.println(SearchKey("the"));
        System.out.println(SearchKey("any"));
    }
}
