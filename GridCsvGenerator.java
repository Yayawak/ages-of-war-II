import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class TileGeneratorApp extends JFrame {
    // int rows = 8;
    // int cols = 12;
    int rows = 25;
    int cols = 20;
    // int rows = 35;
    // int cols = 30;
    Dimension screenSize;
    public static int[][] gridBinary;
    private String fileCsvName;

    public TileGeneratorApp(String fileCsvName)
    {
        this.fileCsvName = fileCsvName;
        screenSize = new Dimension(1000, 1000);
        // screenSize = new Dimension(600, 1000);
        setSize(screenSize);
        initApp();
        // setPreferredSize(new Dimension(1300, 700));
        System.out.println("screensize size " + getSize());
        // System.out.println("screensize p size " + getPreferredSize());
    }

    void initApp() {
        // int gridWidth = getWidth() / cols;
        // int gridHeight = getHeight() / rows;
        System.out.println("scrernsize " + getSize());
        int gridWidth = (int) screenSize.getWidth() / cols;
        int gridHeight = (int) screenSize.getHeight() / rows;
        System.out.println("grid w : " + gridWidth);
        System.out.println("grid h : " + gridHeight);

        Point currentPos = getLocation();
        // setLayout(new GridL);
        gridBinary = new int[rows][cols];
        setLayout(null);
        for (int i = 0; i < rows; i++) {
            currentPos.setLocation(0, currentPos.getY());
            for (int j = 0; j < cols; j++) {
                System.out.println(currentPos);
                CustomPanel grid = new CustomPanel(i, j);
                grid.setSize(gridWidth, gridHeight);
                grid.setLocation(currentPos);
                // Color color = 0 + j % 2 == 0 ?
                Color color = (i + j) % 2 == 0 ?
                // Color.green : Color.blue;
                        Color.black : Color.white;
                grid.setBackground(color);

                getContentPane().add(grid);

                currentPos.setLocation(currentPos.getX() + gridHeight, currentPos.getY());
            }
            currentPos.setLocation(currentPos.getX(), currentPos.getY() + gridHeight);
        }
        setSize(screenSize);

    }

    class CustomPanel extends JPanel {
        private static boolean canChangeColor = false;

        public CustomPanel(int i, int j) {
            // setBackground(new Color(
            // (float)(Math.random()),
            // (float)(Math.random()),
            // (float)(Math.random())
            // ));
            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    if (canChangeColor) {
                        setBackground(Color.red);
                        TileGeneratorApp.gridBinary[i][j] = 1;
                        printMatrix(gridBinary);
                        genCsvMaze(gridBinary);
                    }
                }
            });

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    setBackground(Color.pink);
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    canChangeColor = !canChangeColor;
                }

            });
        }

        public static void printMatrix(int[][] mat) {
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    int elem = mat[i][j];
                    String color = elem == 0 ? Colors.ANSI_BLUE : Colors.ANSI_RED;
                    // Colors.ANSI_RED_BACKGROUND;
                    System.out.print(
                            color +
                                    mat[i][j] + " " +
                                    Colors.ANSI_RESET);
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }

        public void genCsvMaze(int[][] mat) {
            StringBuilder bd = new StringBuilder("");

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    int elem = mat[i][j];
                    bd.append(String.valueOf(elem));
                    if (j != mat[0].length - 1)
                        bd.append(",");
                    else {
                        bd.append("\n");
                    }
                }
                System.out.println();
            }
            // System.out.println(new File("").getAbsolutePath());
            // String fullPath = new File("").getAbsolutePath()
            // Paths.

            try {
                // FileWriter myWriter = new FileWriter("gridData.csv", false);
                FileWriter myWriter = new FileWriter(new File(fileCsvName), false);
                myWriter.write(bd.toString());
                System.out.println(bd.toString());
                // new File
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }
}

class Colors {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
}

public class GridCsvGenerator {
    public static void main(String[] args) {
        new TileGeneratorApp(args[0]).setVisible(true);
    }

}
