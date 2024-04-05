import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class FloorManager implements FloorChangeListener{
    private JFrame mainFrame;
    private GridController gridController;
    private Floor2Controller floor2Controller;

    private Floor3Controller floor3Controller;


    private int currentFloor = 1; // Start from floor 1

    public FloorManager(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        switchToFloor(1);
    }



    public void switchToFloor(int floorNumber) {
        currentFloor = floorNumber;
        switch (floorNumber) {
            case 1:
                initializeFloor1();
                break;
            case 2:
                initializeFloor2();
                break;
            case 3:
                initializeFloor3();
                break;
            default:
                System.out.println("Floor not implemented.");
        }
    }

    private void initializeFloor1() {
        GridModel model = new GridModel();
        GridView view = new GridView(model);
        gridController = new GridController(model, view, this);
        mainFrame.setContentPane(view);
        mainFrame.revalidate();
    }

    private void initializeFloor2() {
        Floor2Model model = new Floor2Model();
        Floor2View view = new Floor2View(model);
        floor2Controller = new Floor2Controller(model, view, this);
        mainFrame.setContentPane(view);
        mainFrame.revalidate();
    }

    private void initializeFloor3() {
        Floor3Model model = new Floor3Model();
        Floor3View view = new Floor3View(model);
        floor3Controller = new Floor3Controller(model, view, this);
        mainFrame.setContentPane(view);
        mainFrame.revalidate();
    }

    @Override
    public void onFloorChange(int newFloor) {
        if (newFloor == 2) {
            switchToFloor(2);
        }else if(newFloor == 3){
                switchToFloor(3);
            }
        else if (newFloor == 1){
            switchToFloor(1);
        }
        }
    }


