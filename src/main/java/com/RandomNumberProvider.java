package com;
import java.util.Random;
public class RandomNumberProvider {
    static Random randNumberGeneratingObject= null;
    public static Random getRandomNumberObject(){
        if(randNumberGeneratingObject == null){
            randNumberGeneratingObject = new Random();
        }
        return randNumberGeneratingObject;
     }

}
