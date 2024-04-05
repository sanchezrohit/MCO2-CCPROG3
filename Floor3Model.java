import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Floor3Model {
    // Define the size of the grid

    private int currentFloor;

    private final int doorwayRow = 0; // Replace X with the actual row
    private final int doorwayCol = 3; // Replace Y with the actual column
    private int transitionRow = 0;
    private int transitionCol = 1;
    private List<String[][]> floors;
    public static final int ROWS = 7;
    public static final int COLS = 5;
    private int playerRow = 6;
    private int playerCol = 2;

    private int doorBackRow = 6;
    private int doorBackCol = 2;

    public Floor3Model(){
        floors = new ArrayList<>();
        String[][] firstFloor = new String[7][3];

        firstFloor[0][1] = "D";

        String[][] secondFloor = new String[7][7];

        floors.add(firstFloor);
        floors.add(secondFloor);

    }

    public boolean isDoorwayCell(int row, int col) {
        return row == doorwayRow && col == doorwayCol;
    }

    public boolean isDoorwayBackCell(int row, int col) {
        return row == doorBackRow && col == doorBackCol;
    }

    // Method to check the specific cells for different colors
    public boolean movePlayer(int dRow, int dCol) {
        int newRow = playerRow + dRow;
        int newCol = playerCol + dCol;

        // Check boundaries
        if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS) {
            playerRow = newRow;
            playerCol = newCol;
            System.out.println("Player is trying to move to: [" + (playerRow + dRow) + ", " + (playerCol + dCol) + "]");
            return true; // Move was successful
        }
        return false; // Move was outside bounds
    }

    public void changeFloor(int newFloor) {
        // Validation of the newFloor index should be done here
        currentFloor = newFloor;
        // Reset player position for the new floor
        playerRow = 6; // Choose appropriate starting row
        playerCol = 1; // Choose appropriate starting column
        // Ensure these are within bounds for the new floor
    }

    public boolean shouldChangeFloor(int row, int col) {
        return currentFloor == 0 && row == transitionRow && col == transitionCol;
    }

    public Color getBorderColorForCell(int row, int col) {
        // Return the color based on the cell position
        if (col == 2 && row == 3) {
            return Color.RED; // B
        }
        else if (row == 6 && col == 2) {
            return Color.ORANGE; // D
        } else if (row == 0 && col == 2) {
            return Color.GREEN; // F
        } else {
            return Color.WHITE; // Default border color
        }
    }

    // Returns the letter for the specific cell
    public String getLetterForCell(int row, int col) {
        String[][] floor = floors.get(currentFloor);
        if (row == playerRow && col == playerCol) {
            return "P";
        }
        else if(col == 2  && row == 3) {
            return "B"; // The cell marked B
        } else if (row == 6 && col == 2) {
            return "D"; // The cell marked D
        } else if (row == 0 && col == 2) {
            return "F"; // The cell marked F
        } else {
            return "";
        }
    }

    public Color getCellColor(int row, int col) {
        // Returns Color.BLACK for all cells
        return Color.BLACK;
    }

    public Color getTextColorForCell(int row, int col, String letter) {
        // Here you can specify the color for each letter or cell
        switch (letter) {
            case "D":
                return Color.ORANGE; // Color for the letter D
            case "F":
                return Color.GREEN; // Color for the letter F
            case "B":
                return Color.RED; // Color for the question mark
            default:
                return Color.WHITE; // Default text color
        }
    }




    public int getPlayerRow() {
        return playerRow;
    }

    public int getPlayerCol() {
        return playerCol;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }


}