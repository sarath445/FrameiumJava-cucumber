package com.frameium.pageobject.Automationexercise;

import org.testng.annotations.Test;

import java.util.*;

public class Practise {
    public static void main( String[]args){

        //creating Hashmap to store fields and their values
        HashMap<Integer, String>hashMap = new HashMap<Integer, String>();
        hashMap.put(1, "Captain");
        hashMap.put(2, "gladiator");
        System.out.println("hashmap :" + hashMap + "\n" );
        //enteryset - for fetching the diff values in Map by get as key and value
        //iterating key and values and pair receivin/store the key and values
        for(Map.Entry<Integer,String> pair: hashMap.entrySet()){
            Integer currentKey = pair.getKey();
            String currentvalue = pair.getValue();
            System.out.println(currentKey+" : "+ currentvalue);

        }
        //keyset
        for(Integer key:hashMap.keySet()){
            Integer currentkey = key;
            String currentvalue = hashMap.get(currentkey);
            System.out.println(currentkey +" : " + currentvalue);

        }
        //getting corresponding value of key.
        System.out.println(hashMap.get(2));


    }
    @Test
    public static void Setmethod(){
        Set<String> names = new HashSet<>();
        names.add("smith");
        names.add("root");
        names.add("philips");
        names.add("head");
        names.add("stubbs");

        List<String> namelist = new ArrayList<>();
        namelist.add("hay");
        namelist.add("kerr");
        namelist.add("dev");
        namelist.add("hay");
        System.out.println(namelist);

        Set<String> nameset = new HashSet<>(namelist);
        System.out.println(nameset);


      //names.forEach(System.out::println);
        Iterator<String> namesIterator = names.iterator();
        while (namesIterator.hasNext()){
            System.out.println(namesIterator.next());
        }

        //System.out.println(names);
    }
}
