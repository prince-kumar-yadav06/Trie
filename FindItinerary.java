import java.util.*;

public class FindItinerary {
    
    public static  String getStart(HashMap<String,String> dataset){

        //create Hashmap

        //store all data in another map in reverse form mean kes is value
        //value is key
        HashMap<String,String> revmap=new HashMap();

        // store reverse of dataset 
        for(String key: dataset.keySet()){
            revmap.put(dataset.get(key),key);

        }
        for(String key: dataset.keySet()){
            if(!revmap.containsKey(key)){
                return key;
            }
        }

 return null;

    }

    public static void main(String args[]){

        HashMap<String,String> map=new HashMap<>();

        map.put("chennai","bengaluru");
        map.put("mumbai","delhi");
        map.put("goa","chennai");
        map.put("delhi","goa");

        String start=getStart(map);

        System.out.print(start);
        for(String key : map.keySet()){
            System.out.print("->"+map.get(start));
            start=map.get(start);
        }
        System.out.println();
    }
}
