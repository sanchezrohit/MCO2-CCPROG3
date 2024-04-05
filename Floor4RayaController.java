import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.KeyEvent;

class Floor4RayaController {

    private JFrame frame;
    private Floor4RayaModel model;
    private Floor4RayaView view;

    private FloorChangeListener floorChangeListener;



    private FloorManagerRaya manager;

    //private Floor4View Floor4View;


    public Floor4RayaController(Floor4RayaModel model, Floor4RayaView view, FloorChangeListener floorChangeListener) {
        this.model = model;
        this.view = view;
        this.floorChangeListener = floorChangeListener;
        setUpKeyBindings();
    }

    private void setUpKeyBindings() {
        InputMap inputMap = view.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = view.getActionMap();

        // Bind the arrow keys to actions
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "moveUp");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "moveDown");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "moveLeft");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "moveRight");

        // Define actions for moving up
        actionMap.put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.movePlayer(-1, 0)) { // move up
                    view.updateView();
                }
            }
        });

        actionMap.put("moveDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.movePlayer(1, 0)) { // move down
                    view.updateView();
                }
            }
        });

        actionMap.put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.movePlayer(0, -1)) { // move left
                    view.updateView();
                }
            }
        });

        actionMap.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.movePlayer(0, 1)) { // move right
                    view.updateView();
                }
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enterPressed");
        actionMap.put("enterPressed", new AbstractAction() {
            @Override

            // Check if the player should change floors based on their position
            public void actionPerformed(ActionEvent e) {
                if (model.isDoorwayCell(model.getPlayerRow(), model.getPlayerCol())) {
                    floorChangeListener.onFloorChange(6);
                    System.out.println("changing floors...");}// Transition to floor 2


            }
        });








        // Repeat for moveDown, moveLeft, and moveRight...
    }

    private void setupFloorTransition() {
        // This method is a placeholder for the logic that decides when to switch floors.
        // For simplicity, let's assume it's a key binding on the GridView.
        InputMap inputMap = view.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = view.getActionMap();

    }




    public void movePlayer(int rowOffset, int colOffset) {
        int currentRow = model.getPlayerRow();
        int currentCol = model.getPlayerCol();
        int newRow = currentRow + rowOffset;
        int newCol = currentCol + colOffset;

        // Check boundaries
        if (newRow >= 0 && newRow < Floor4RayaModel.ROWS && newCol >= 0 && newCol < Floor4RayaModel.COLS) {
            model.movePlayer(newRow, newCol);
            view.updateView(); // You need to create this method in your GridView class
        }
    }
    private boolean isSpecialCell(int row, int col) {
        // Check if the cell is marked with "D" for door or another special marker
        String tile = model.getLetterForCell(row, col);
        boolean isSpecial = "D".equals(tile);
        System.out.println("Player is at [" + row + ", " + col + "] with tile: " + tile + " isSpecial: " + isSpecial); // Debug print
        return isSpecial;
    }
}

// Any interaction handling can be added here

