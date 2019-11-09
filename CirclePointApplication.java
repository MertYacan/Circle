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
public class CirclePointApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circle[] circles = new Circle[100];

        //Here we add some color options.
        Colors.addColor("Red");
        Colors.addColor("Green");
        Colors.addColor("Blue");
        Colors.addColor("Yellow");
        Colors.addColor("Purple");
        Colors.addColor("Cyan");
        Colors.addColor("Orange");
        //We can add more colors and the code will still work
        //Colors.addColor("Brown");
        //Colors.addColor("Black");
        //Colors.addColor("White");
        //Colors.addColor("Tan");
        //Colors.addColor("Pink");
        //....

        //Here we create our circles and display their properties.
        for (int i = 0; i < 100; i++) {
            //for the XXX format
            String nameNumber = String.format("%03d", i + 1);
            //Circle- + XXX format
            String name = "Circle-" + nameNumber;
            circles[i] = new Circle(new Point(Math.random() * 500, Math.random() * 500), Math.random() * 500, name, Colors.getRandomColor());
            System.out.println(circles[i].name + " is created at (" + (int) circles[i].x + "," + (int) circles[i].y
                    + ") with radius of " + (int) circles[i].r + " and is " + Colors.getColor(circles[i].colorNum));
        }

        //Here we find the total and average area.
        for (int i = 0; i < 100; i++) {
            double totalArea = 0;
            totalArea = circles[i].area() + totalArea;
            if (i == 99) {
                System.out.println("\nThe total area of circles is: " + (int) totalArea);
                System.out.println("The average area of circles is: " + (int) totalArea / 100 + "\n");
            }
        }

        //Here we find the number of circles for each color
        int[] circleColorNumber = new int[Colors.arrayLocation];
        for (int i = 0; i < 100; i++) {
            int tempColorNum;
            tempColorNum = circles[i].colorNum;
            circleColorNumber[tempColorNum]++;
        }
        //Here we display numbers of circles for each color
        for (int i = 1; i < Colors.arrayLocation; i++) {
            System.out.println("The number of circles with color of " + Colors.getColor(i) + " is; " + circleColorNumber[i]);
        }

        //Lets say we imported some colors but we dont know what is the colorNum of Red
        String tempColor = "Red";
        if (Colors.findColorNum(tempColor) == 0) {
            System.out.println("\nThe color " + tempColor + " cannot be found.");
        } else {
            Circle[] sorted = new Circle[circleColorNumber[Colors.findColorNum(tempColor)]];
            for (int i = 0, j = 0; i < 100; i++) {
                if (circles[i].colorNum == Colors.findColorNum(tempColor)) {
                    sorted[j] = circles[i];
                    j++;
                }
            }
            Circle temp;
            for (int i = 1; i < sorted.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (sorted[j].circumference() < sorted[j - 1].circumference()) {
                        temp = sorted[j];
                        sorted[j] = sorted[j - 1];
                        sorted[j - 1] = temp;
                    }
                }
            }
            System.out.println("\nRed colored circles sorted:");
            for (int i = 0; i < sorted.length; i++) {
                System.out.println(sorted[i].name + " has a radius of " + (int)sorted[i].r);
            }
        }

        //Do we have circles with color cingenepembesi?
        tempColor = "Cingenepembesi";
        if (Colors.findColorNum(tempColor) == 0) {
            System.out.println("\nThe color " + tempColor + " cannot be found.");
        } else {
            Circle[] sorted = new Circle[circleColorNumber[Colors.findColorNum(tempColor)]];
            for (int i = 0, j = 0; i < 100; i++) {
                if (circles[i].colorNum == Colors.findColorNum(tempColor)) {
                    sorted[j] = circles[i];
                    j++;
                }
            }
            Circle temp; //insertion sort
            for (int i = 1; i < sorted.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (sorted[j].circumference() < sorted[j - 1].circumference()) {
                        temp = sorted[j];
                        sorted[j] = sorted[j - 1];
                        sorted[j - 1] = temp;
                    }
                }
            }
            System.out.println("\n" + tempColor + " colored circles sorted:");
            for (int i = 0; i < sorted.length; i++) {
                System.out.println(sorted[i].name + " has a radius of " + (int)sorted[i].r);
            }
        }

        Point A = new Point(Math.random() * 500, Math.random() * 500);
        double distLowest = 9999;
        int distLowestCircleNum = 0;
        double distHighest = 0;
        int distHighestCircleNum = 0;
        for (int i = 0; i < 100; i++) {
            double tempDist;
            tempDist = Math.sqrt(Math.pow((A.x - circles[i].x), 2) + Math.pow((A.y - circles[i].y), 2));
            if (tempDist < distLowest) {
                distLowest = tempDist;
                distLowestCircleNum = i;
            }
            if (tempDist > distHighest) {
                distHighest = tempDist;
                distHighestCircleNum = i;
            }
        }
        System.out.println("\nThe farthest circle to the point (" + (int)A.x + "," + (int)A.y + ") is " + circles[distHighestCircleNum].name + " and its distance is: " + (int)distHighest);
        System.out.println("The closest circle to the point (" + (int)A.x + "," + (int)A.y + ") is " + circles[distLowestCircleNum].name + " and its distance is: " + (int)distLowest);

    }
}
