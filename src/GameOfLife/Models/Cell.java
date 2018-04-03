package GameOfLife.Models;

/**
 * Created by Niels on 02-04-2018.
 */

/* Basic rules:
Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
Any live cell with two or three live neighbours lives on to the next generation.
Any live cell with more than three live neighbours dies, as if by overpopulation.
Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
* */

public class Cell {

    // Deklaration af datatyper
    private int livingNeighbours;
    private boolean alive;

    /*
     **  Værdier til state og hvad de betyder:
     **  1 = birth
     **  2 = survival
     **  3 = overcrowding or loneliness
     */

    private byte state;

    // Update metode, der sætter alive til true eller false ud fra reglerne
    public void update() {

        // Hvis cellen er død og har 3 levende naboer, bliver den til en levende celle (birth)
        if (!isAlive() && livingNeighbours == 3) {
            alive = true;
            state = 1;
        }
        // Hvis cellen er levende og har 2 eller 3 levende naboer så er den stadig levende (survival)
        else if (isAlive() && (livingNeighbours == 2 || livingNeighbours == 3)) {
            alive = true;
            state = 2;
        }
        // Ellers dør den eller er stadig død (overcrowding or loneliness)
        else {
            alive = false;
            state = 3;
        }

    }

    // Gætter til livingNeighbours
    public int getLivingNeighbours() {
        return livingNeighbours;
    }

    // Sætter til livingNeighbours
    public void setLivingNeighbours(int livingNeighbours) {
        this.livingNeighbours = livingNeighbours;
    }

    // Gætter til alive
    public boolean isAlive() {
        return alive;
    }

    // Sætter til alive
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    // Gætter til state
    public byte getState() {
        return state;
    }

    // Sætter til state
    public void setState(byte state) {
        this.state = state;
    }
}

/*
public class Cell {

//    Declaration of variables
    private int livingNeighbours;
    private String name;
    private List neighborList;
    private int repetition;
    private String about;

    boolean alive = false;

    public Cell() {

        livingNeighbours = -1;
        repetition = 0;
        List neighborList = new ArrayList();
    }
//    Method to determine alive or dead according to rules above
    public String update() {

        String isAlive = "dead";

        if (alive) {
            isAlive = "Alive";
        }
//    Any dead cell with exactly three live neighbours
//    becomes a live cell, as if by reproduction.
        if (!alive && (livingNeighbours == 3)) {
            alive = true;
            about = "Cell is born";
        }
//    Any live cell with two or three live neighbours lives on to the next generation.
        if (alive && livingNeighbours == 2) {
            alive = true;
            about = "Cell has two neighbours and lives on to next generation";

        }
        if (alive && livingNeighbours == 3) {
            alive = true;
            about = "Cell has three neighbours and lives on to next generation";
        }
//     Any live cell with fewer than two live neighbours dies,
//     as if caused by underpopulation.
        if (!alive){
            about = "Cell continues dead";
        } else {
//     Any live cell with more than three live neighbours dies, as if by overpopulation.
            about = "Cell died of overpopulation";
        }
        return about + "Cell " + name + " is " + isAlive + " with " + livingNeighbours + " neighbours";
    }

    public int getLivingNeighbours() {
        return livingNeighbours;
    }

    public void setLivingNeighbours(int livingNeighbours) {
        this.livingNeighbours = livingNeighbours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getNeighborList() {
        return neighborList;
    }

    public void setNeighborList(List neighborList) {
        this.neighborList = neighborList;
    }

    public int getRepetition() {
        return repetition;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
*/
