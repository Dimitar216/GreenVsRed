package GreenVsRed;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class GridUtility {

    protected static int greenCounter = 0;

    public static int getGreenCounter() {
        return greenCounter;
    }

    /**
     * This method fills a 2D array with elements that are randomly chosen between 0 and 1.
     * @param array the array that is being filled.
     * @param x the array's width.
     * @param y the array's height.
     */
    protected static void filler(String[][] array,int x,int y){
        for(int row=0;row<x;row++){
            for (int col=0;col<y;col++){
                int random = ThreadLocalRandom.current().nextInt(0,2);
                if (random == 1){
                    array[row][col] ="1";
                } else {
                    array[row][col] ="0";
                }
            }
        }
    }

    /**
     * A method that prints a 2D array.
     * @param array the array that will be printed.
     */
    protected static void render(String[][] array){
        System.out.println(Arrays.deepToString(array).replace("], ", "\n").replace("[[", " ").replace("]]", "").replace("["," ").replace(",",""));
    }

    /**
     * A method that both checks what color should a position be in the next generation.Swap it's color and keep count how much has a requested
     * position turned green.
     * @param xCoord the width coordinate of the current position being checked.
     * @param yCoord the height coordinate of the current position being checked.
     * @param grid the array where a coordinate is being checked.
     * @param width the width of the array.
     * @param height the height of the array.
     * @param consoleX the requested width coordinate of the element that is being kept tracked of how much times it will become green.
     * @param consoleY the requested height coordinate of the element that is being kept tracked of how much times it will become green.
     * @param switchArr an array that helps with swapping between generations.
     */
    protected static void cellColorCalculatorAndSwapper(int xCoord, int yCoord, String[][] grid,int width,int height,int consoleX,int consoleY,String[][] switchArr) {
        if (grid[xCoord][yCoord].equals("0")) {
            int transformationCounter = 0;
            if(width>xCoord-1&&height>yCoord-1&&xCoord-1>=0&&yCoord-1>=0) {
                if (grid[xCoord - 1][yCoord - 1].equals("1")) {
                    transformationCounter++;
                }
            }
            if(width>xCoord-1&&height>yCoord&&xCoord-1>=0) {
                if (grid[xCoord - 1][yCoord].equals("1")) {
                    transformationCounter++;
                }
            }
            if(width>xCoord&&height>yCoord-1&&yCoord-1>=0) {
                if (grid[xCoord][yCoord - 1].equals("1")) {
                    transformationCounter++;
                }
            }
            if(width>xCoord+1&&height>yCoord+1) {
                if (grid[xCoord + 1][yCoord + 1].equals("1")) {
                    transformationCounter++;
                }
            }
            if(width>xCoord+1&&height>yCoord) {
                if (grid[xCoord + 1][yCoord].equals("1")) {
                    transformationCounter++;
                }
            }
            if(width>xCoord&&height>yCoord+1) {
                if (grid[xCoord][yCoord + 1].equals("1")) {
                    transformationCounter++;
                }
            }
            if(width>xCoord-1&&height>yCoord+1&&xCoord-1>=0) {
                if (grid[xCoord - 1][yCoord + 1].equals("1")) {
                    transformationCounter++;
                }
            }
            if(width>xCoord+1&&height>yCoord-1&&yCoord-1>=0) {
                if (grid[xCoord + 1][yCoord - 1].equals("1")) {
                    transformationCounter++;
                }
            }
            if (transformationCounter == 3 || transformationCounter == 6) {
                switchArr[xCoord][yCoord] = "1";
                if (xCoord == consoleX && yCoord == consoleY) {
                    greenCounter++;
                }
            } else {
                switchArr[xCoord][yCoord] = "0";
            }
        }

        if (grid[xCoord][yCoord].equals("1")) {
            int transformationCounter = 0;
            if(width>xCoord-1&&height>yCoord-1&&xCoord-1>=0&&yCoord-1>=0) {
                if (grid[xCoord - 1][yCoord - 1].equals("1")) {
                    transformationCounter++;
                }
            }
            if(width>xCoord-1&&height>yCoord&&xCoord-1>=0) {
                if (grid[xCoord - 1][yCoord].equals("1")) {
                    transformationCounter++;
                }
            }
            if(width>xCoord&&height>yCoord-1&&yCoord-1>=0) {
                if (grid[xCoord][yCoord - 1].equals("1")) {
                    transformationCounter++;
                }
            }
            if(width>xCoord+1&&height>yCoord+1) {
                if (grid[xCoord + 1][yCoord + 1].equals("1")) {
                    transformationCounter++;
                }
            }
            if(width>xCoord+1&&height>yCoord) {
                if (grid[xCoord + 1][yCoord].equals("1")) {
                    transformationCounter++;
                }
            }
            if(width>xCoord&&height>yCoord+1) {
                if (grid[xCoord][yCoord + 1].equals("1")) {
                    transformationCounter++;
                }
            }
            if(width>xCoord-1&&height>yCoord+1&&xCoord-1>=0) {
                if (grid[xCoord - 1][yCoord + 1].equals("1")) {
                    transformationCounter++;
                }
            }
            if(width>xCoord+1&&height>yCoord-1&&yCoord-1>=0) {
                if (grid[xCoord + 1][yCoord - 1].equals("1")) {
                    transformationCounter++;
                }
            }
            if (transformationCounter == 2 || transformationCounter == 3 || transformationCounter == 6) {
                switchArr[xCoord][yCoord] = "1";
                if (xCoord == consoleX && yCoord == consoleY) {
                    greenCounter++;
                }
            } else {
                switchArr[xCoord][yCoord] = "0";
            }
        }
    }
}