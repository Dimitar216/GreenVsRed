package GreenVsRed;

public class GenerationZeroGridGenerator {

    /**
     * A method that checks if the received parameters are valid and creates a 2D array with the sizes of the
     * parameters.
     * @param widthOfGrid the width of the array.
     * @param heightOfGrid the height of the array.
     * @return a String 2D array
     */
    protected static String[][] generationZeroGridCreator(int widthOfGrid, int heightOfGrid){
            if(widthOfGrid<=0||widthOfGrid>1000){
                System.err.println("Invalid input.Input should be from 1 to 1000");
                System.exit(1);
            }
            if(heightOfGrid<=0||heightOfGrid>1000){
                System.err.println("Invalid input.Input should be from 1 to 1000");
                System.exit(1);
            }
        String[][] grid = new String[widthOfGrid][heightOfGrid];

        return grid;
    }

}