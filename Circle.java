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
public class Circle {
    
    //Here we declare three double variables; 
    //two for the center coordinates of the circle and one for radius
    double x;
    double y;
    double r;
    String name;
    int colorNum;
    
    public Circle(Point b, double r){
        this.x = b.x;
        this.y = b.y;
        this.r = r;
    }
    
    public Circle(Point b, double r, String name, int colorNum){
        this.x = b.x;
        this.y = b.y;
        this.r = r;
        this.name = name;
        this.colorNum = colorNum;
    }
    
    //A public behaviour for calculating circumference
    public double circumference(){
        return (2 * r * Math.PI);
    }
    
    //A public behaviour for calculating area
    public double area(){
        return (Math.pow(r, 2) * Math.PI);
    }
    
    
    //Checking whether the point(x, y) inside the circle.
    //Basicly, creating a right triangle and calculating hypotenuse
    //if hypotenuse is bigger than radius then the point is not
    //inside the circle.
    /**
    *                  .
    *             .         .
    *           .             .
    *          . Circle center .      Point a.x - Circle center x
    *         .        O ______ ._________
    *          .        \      .          |
    *           .           \ .           |
    *             .         .   \         | Circle center y - Point a.y
    *                  .            \     |
    *                       distance    \ |
    *                                     • Point a
    * 
    */
    public boolean isitinside(Point a){
        //the difference between the center point x,y and the point a's x,y values are
        //the sides of right triangle and the distance between the circle center
        //and point is the hypotenuse.
        double xa = x - a.x;
        double ya = y - a.y;
        return Math.sqrt(xa*xa + ya*ya) <= r;
    }    
    
}
