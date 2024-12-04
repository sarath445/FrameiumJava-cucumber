package com.frameium.utilities.pdfutils;

import org.apache.commons.text.AlphabetConverter;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Datagenerationform {


    public static String PhonenumberGenerator(){
        //creating Random class.
        Random random = new Random();
        int firstdigit = random.nextInt(9) + 1;  //generates a number b/w 1 and 9
        long remainingdigits = (long)(random.nextDouble()*1_000_000_000L);

        String phonenumber  = firstdigit + String.format("%09d", remainingdigits );
        return  "+91" + phonenumber;
    }

//    public static String PhonenumberGenerator(){
//        StringBuilder phonenum = new StringBuilder("+91");
//        int firstdigit = ThreadLocalRandom.current().nextInt(5,9);
//        phonenum.append(firstdigit);
//        //Generating remain 9 digits.
//        for(int n=0; n<9; n++){
//           int digit =  ThreadLocalRandom.current().nextInt(0,9);
//           phonenum.append(digit);
//        }
//        return phonenum.toString();


    public static String RandomnameGenerator()throws InterruptedException{
        Thread.sleep(2000);
        int length = 10; //Length of the random names.
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  // alphabetic characters.
        Random random = new Random();
        StringBuilder formnames = new StringBuilder();
        for(int m=0; m<10; m++){
            int index = random.nextInt(alphabet.length()); //Get a random index.
            formnames.append(alphabet.charAt(index)); //appending/adding character to the index by using Stringbuilder name.
        }
        return formnames.toString();
    }

}
