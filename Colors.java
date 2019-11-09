/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

/**
 *
 * @author Mert Yacan
 */
public class Colors {
    //I change the size of array by 5 everytime it's full, to improve performance
    //so i need one variable to find how many color options there are
    static int arrayLocation = 1;
    //and i need one variable to see the actual length of the array.
    static int arraySize = 1;
    static String Colors[] = new String[1];

    public static void addColor(String Color) {
        if(arraySize == Colors.length){
            String[] largerArray = new String[Colors.length + 5];
            System.arraycopy(Colors, 0, largerArray, 0, Colors.length);
            Colors = largerArray;
            arraySize = arraySize + 5;
        }
        Colors[arrayLocation++] = Color;
    }
    
    public static String getColor(int a){
        return Colors[a];
    }
    
    public static int getRandomColor(){
        return (int)((arrayLocation-1)*Math.random()+1);
    }
    
    public static int findColorNum(String Color){
        for(int i = 1; i < arrayLocation; i++){
            while(Colors[i].equals(Color)){
                return i;
            }
        }
        //return 0 means that the color cannot be found.
        return 0;
    }

}
