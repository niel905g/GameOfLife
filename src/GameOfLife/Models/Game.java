package GameOfLife.Models;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Niels on 02-04-2018.
 */
public class Game {

    //    Defining size of 2d array: BOARD_SIZE X & Y
    private final int BOARD_SIZE_X = 30, BOARD_SIZE_Y = 26;

    private Cell[][] cellsArray = new Cell[BOARD_SIZE_X][BOARD_SIZE_Y];
    private Game game;


    private Game() {

        for (int y = 0; y < BOARD_SIZE_Y; y++) {
            for (int x = 0; x < BOARD_SIZE_X; x++) {

                Random random = new Random();
                int randomNumber = random.nextInt(2);
                Cell cell = new Cell();

                if (randomNumber == 0) {
                    cell.setAlive(false);
                }else if (randomNumber == 1) {
                cell.setAlive(true);
                }
                cellsArray[x][y] = cell;
            }
        }
    }

//    Method returns a game object
    public static Game createGame() {
        Game game = new Game();
        return game;
    }
    private Rectangle rectangleBlue, rectangleWhite;
    private ArrayList<Rectangle> rectangles = new ArrayList<>();

//    Method loop Array and create the cells
    public void createCells() {
        for (int y = 0, yPosition = 25; y < BOARD_SIZE_Y; y++, yPosition = yPosition + 22) {
            for (int x = 0, xPosition = 25; x < BOARD_SIZE_X; x++, xPosition = xPosition + 22) {

            if (cellsArray[x][y].isAlive()) {
                rectangleBlue = new Rectangle(20, 20, Color.BLUE);
                rectangleBlue.setX(xPosition);
                rectangleBlue.setY(yPosition);
                rectangleBlue.setStrokeType(StrokeType.INSIDE);
                rectangleBlue.setStroke(Color.BLACK);
                rectangleBlue.setStrokeWidth(2);
                GameOfLifeGui.getPane().getChildren().add(rectangleBlue);
                rectangles.add(rectangleBlue);
            }
            if (!cellsArray[x][y].isAlive()) {
                rectangleWhite = new Rectangle(20, 20, Color.WHITE);
                rectangleWhite.setX(xPosition);
                rectangleWhite.setY(yPosition);
                rectangleWhite.setStrokeType(StrokeType.INSIDE);
                rectangleWhite.setStroke(Color.BLACK);
                rectangleWhite.setStrokeWidth(2);
                GameOfLifeGui.getPane().getChildren().add(rectangleWhite);
                rectangles.add(rectangleWhite);
            }

        }
    }

    }
//    An update method which loop the Array to set livingNeighbours and then update each cell dead/alive.
    public void update() {

        for (int y = 0; y < BOARD_SIZE_Y; y++) {
            for (int x = 0; x < BOARD_SIZE_X; x++) {

                cellsArray[x][y].setLivingNeighbours(0);

                if (x > 0 && y > 0) {
                    if (cellsArray[x - 1][y - 1].isAlive()) {
                        cellsArray[x][y].setLivingNeighbours(cellsArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (x > 0) {
                    if (cellsArray[x - 1][y].isAlive()) {
                        cellsArray[x][y].setLivingNeighbours(cellsArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (y < BOARD_SIZE_Y - 1 && x > 0) {
                    if (cellsArray[x - 1][y + 1].isAlive()) {
                        cellsArray[x][y].setLivingNeighbours(cellsArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (y < BOARD_SIZE_Y - 1) {
                    if (cellsArray[x][y + 1].isAlive()) {
                        cellsArray[x][y].setLivingNeighbours(cellsArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (x < BOARD_SIZE_X - 1 && y < BOARD_SIZE_Y - 1) {
                    if (cellsArray[x + 1][y + 1].isAlive()) {
                        cellsArray[x][y].setLivingNeighbours(cellsArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (x < BOARD_SIZE_X - 1) {
                    if (cellsArray[x + 1][y].isAlive()) {
                        cellsArray[x][y].setLivingNeighbours(cellsArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (y > 0) {
                    if (cellsArray[x][y - 1].isAlive()) {
                        cellsArray[x][y].setLivingNeighbours(cellsArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (x < BOARD_SIZE_X - 1 && y > 0) {
                    if (cellsArray[x + 1][y - 1].isAlive()) {
                        cellsArray[x][y].setLivingNeighbours(cellsArray[x][y].getLivingNeighbours() + 1);
            }
        }
    }
}
        for (int y = 0; y < BOARD_SIZE_Y; y++) {
            for (int x = 0; x < BOARD_SIZE_X; x++) {
                cellsArray[x][y].update();
            }
        }
    }
    private int counter = 0;

//    ButtonAction Method
    public void buttonAction() {
        GameOfLifeGui.getPane().getChildren().removeAll(rectangles);

        rectangles.clear();

        update();

        createCells();

        counter++;

        String counterToString = String.valueOf(counter);

        GameOfLifeGui.getLabel().setText(counterToString);

    }
}
