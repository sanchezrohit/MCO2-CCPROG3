import javax.swing.*;

public class FloorManagerRaya implements FloorChangeListener{
    private JFrame mainFrame;
    private Floor1RayaController floor1RayaController;

    private Floor2RayaController floor2RayaController;

    private Floor3RayaController floor3RayaController;

    private  Floor4RayaController floor4RayaController;

    private BossFloorRayaController bossfloorRayaController;

    private Floor1RayaView view;

    private  Floor1RayaModel model;




    private int currentFloor = 4; // Start from floor 1

    public FloorManagerRaya(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        switchToFloor(4); // first floor
    }



    public void switchToFloor(int floorNumber) {
        currentFloor = floorNumber;
        switch (floorNumber) {
            case 4:
                initializeFloor1Raya();
                break;
            case 5:
                initializeFloor2Raya();
                break;
            case 6:
                initializeFloor3Raya();
                break;
            case 7:
                initializeFloor4Raya();
                break;
            case 8:
                initializeBossFloorRaya();
                break;
            default:
                System.out.println("Floor not implemented.");
        }
    }

    private void initializeFloor1Raya() {

        Floor1RayaModel model = new Floor1RayaModel();
        Floor1RayaView view = new Floor1RayaView(model);
        floor1RayaController = new Floor1RayaController(model, view, this);
        mainFrame.setContentPane(view);
        mainFrame.revalidate();
    }

    private void initializeFloor2Raya() {
        Floor2RayaModel model = new Floor2RayaModel();
        Floor2RayaView view = new Floor2RayaView(model);
        floor2RayaController = new Floor2RayaController(model, view, this);
        mainFrame.setContentPane(view);
        mainFrame.revalidate();
    }

    private void initializeFloor3Raya() {
        Floor3RayaModel model = new Floor3RayaModel();
        Floor3RayaView view = new Floor3RayaView(model);
        floor3RayaController = new Floor3RayaController(model, view, this);
        mainFrame.setContentPane(view);
        mainFrame.revalidate();
    }

    private void initializeFloor4Raya() {
        Floor4RayaModel model = new Floor4RayaModel();
        Floor4RayaView view = new Floor4RayaView(model);
        floor4RayaController = new Floor4RayaController(model, view, this);
        mainFrame.setContentPane(view);
        mainFrame.revalidate();
    }

    private void initializeBossFloorRaya() {
        BossFloorRayaModel model = new BossFloorRayaModel();
        BossFloorRayaView view = new BossFloorRayaView(model);
        bossfloorRayaController = new BossFloorRayaController(model, view, this);
        mainFrame.setContentPane(view);
        mainFrame.revalidate();
    }

    @Override
    public void onFloorChange(int newFloor) {
        if (newFloor == 5) {
            switchToFloor(5);
        }else if(newFloor == 4){
            switchToFloor(4);
        }
        else if (newFloor == 6){
            switchToFloor(6);
        }
        else if(newFloor == 7){
            switchToFloor(7);
        } else if(newFloor == 8){
            switchToFloor(8);
        }
    }
}


