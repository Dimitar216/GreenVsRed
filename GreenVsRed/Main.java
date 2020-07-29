package GreenVsRed;

import java.util.Scanner;

public class Main {

    private static int whileCounter = 0;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please input the width of the grid(from 1 to 1000).");
        int widthOfGrid = scanner.nextInt();

        System.out.println();
        System.out.println("Please input the height of the grid(from 1 to 1000).");
        int heightOfGrid = scanner.nextInt();

        String[][] grid = GenerationZeroGridGenerator.generationZeroGridCreator(widthOfGrid,heightOfGrid);

        GridUtility.filler(grid,widthOfGrid,heightOfGrid);

        GridUtility.render(grid);

        System.out.println("Input x coordinates");
        int xInput = scanner.nextInt();
        if(xInput<0||xInput>widthOfGrid){
            System.err.println("Invalid coordinates.");
            System.exit(1);
        }
        System.out.println("Input y coordinates");
        int yInput = scanner.nextInt();
        if(yInput<0||yInput>heightOfGrid){
            System.err.println("Invalid coordinates.");
            System.exit(1);
        }
        System.out.println("Input generation runs");
        int generationRunsInput = scanner.nextInt();
        if(generationRunsInput<=0){
            System.err.println("Generation runs cannot be less than or 0");
            System.exit(1);
        }

        do {
            String[][] switchArray = new String[widthOfGrid][heightOfGrid];
            for(int row = 0; row<widthOfGrid;row++){
                for(int col=0;col<heightOfGrid;col++){
                    GridUtility.cellColorCalculatorAndSwapper(row,col,grid,widthOfGrid,heightOfGrid,xInput,yInput,switchArray);
                }
            }
            grid=switchArray;
            whileCounter++;
        } while (whileCounter < generationRunsInput);

        System.out.println("The selected coordinate becomes green "+GridUtility.getGreenCounter()+" times");
    }
}