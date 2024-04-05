import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.border.Border;

class Floor2View extends JPanel {
    private Floor2Model model;

    public Floor2View(Floor2Model model) {
        this.model = model;
        this.initializeGrid();

    }


    // Initializes the grid UI
    private void initializeGrid() {
        setLayout(new GridLayout(model.ROWS, model.COLS));
        Font cellFont = new Font("SanSerif", Font.BOLD, 25);

        for (int row = 0; row < model.ROWS; row++) {
            for (int col = 0; col < model.COLS; col++) {
                JPanel cell = new JPanel();

                cell.setBackground(model.getCellColor(row, col));
                cell.setOpaque(true);

                Color borderColor = model.getBorderColorForCell(row, col);
                Border border = BorderFactory.createLineBorder(borderColor, 1);//adjust the thickness
                cell.setBorder(border);

                JLabel label = new JLabel(model.getLetterForCell(row, col), SwingConstants.CENTER);
                label.setFont(cellFont);

                Color textColor = model.getTextColorForCell(row, col, model.getLetterForCell(row, col));
                label.setForeground(textColor);

                // Ensure the label's background is opaque to show the cell color
                label.setOpaque(true);
                label.setBackground(Color.black);


                cell.add(label);
                add(cell);
            }
        }
    }


    public void updateView() {
        // Remove all components and rebuild the grid
        removeAll();
        initializeGrid();
        revalidate();
        repaint();
    }


}