import java.io.IOException;
import java.util.Vector;

/**
 * Created by Eriwyr on 07/02/2017.
 */
public class Morpion {
    private Grid grid;
    private AI ai;
    private boolean end;
    private boolean playAgain;
    public Morpion()
    {
        grid = new Grid();
        ai= new AIIterative();
        end = false;
        playAgain = false;

    }


    public void start()
    {
        char v;
        while (!end) {


            if (!grid.isFull()) {
                try {
                    askForMore('x');
                } catch (IOException e) {
                    e.printStackTrace();
                }
                grid.printGrid();

                v = verifyEndGame();
                if (v != 'n') {
                    System.out.println("Les " + v + " ont gagné ! ");
                    end = true;

                }
            } else {
                end = true;
            }

            if (!grid.isFull() && !end && !playAgain) {

                AIPlays(ai);
                grid.printGrid();
                v = verifyEndGame();
                if (v != 'n') {
                    System.out.println("Les " + v + " ont gagné ! ");
                    end = true;
                }

            }else {
                end = true;
            }
        }
    }

    public void AIPlays(AI ai) {
        Vector v =ai.takeDecision(grid);
        //ai.takeDecision(grid);
        if (v != null) {
            grid.setXY((int)v.elementAt(0),(int)v.elementAt(1), 'o');

        } else {
            System.out.println("null");
        }

    }
    public void askForMore(char c) throws IOException {
        int x,y;
        System.out.println("Please input x: ");
        do {
            x = System.in.read();
        }
        while(x < 48 || x > 57);
        System.out.println("Please input y: ");
        do {
            y = System.in.read();
        }
        while(y < 48 || y > 57);
        grid.setXY(x-48, y-48, c);
    }

    public char verifyLine(){ // return x if x win, o if y win, n if nobody win
        int cmptX;
        int cmptY;
        for(int i =0 ; i<3 ; i++){
            cmptX = 0;
            cmptY = 0;
            for(int j=0; j<3; j++){
                if(grid.getXY(i,j) =='x'){
                    cmptX++;
                }
                if(grid.getXY(i,j) =='o'){
                    cmptY++;
                }

                if(cmptX == 3){
                    return 'x';
                }
                if(cmptY == 3){
                    return 'o';
                }
            }
        }

        return'n';
    }

    public char verifyDiag(){

        if(grid.getXY(0,0) == 'x' && grid.getXY(1,1) == 'x' && grid.getXY(2,2) == 'x') {return 'x';}
        if(grid.getXY(0,0) == 'o' && grid.getXY(1,1) == 'o' && grid.getXY(2,2) == 'o') {return 'o';}
        if(grid.getXY(0,2) == 'x' && grid.getXY(1,1) == 'x' && grid.getXY(2,0) == 'x') {return 'x';}
        if(grid.getXY(0,2) == 'o' && grid.getXY(1,1) == 'o' && grid.getXY(2,0) == 'o') {return 'o';}
        return'n';
    }

    public char verifyCol(){
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(grid.getXY(i,j) != 'x')
                {
                    break;
                }
                if(j==2) { return 'x';}
            }

            for(int j=0; j<3; j++) {
                if(grid.getXY(i,j) != 'o')
                {
                    break;
                }
                if(j==2) { return 'o';}
            }
        }
        return 'n';
    }

    public char verifyEndGame() {
        char v;
        v = verifyCol();
        if (v != 'n') {
            return v;
        }
        v = verifyLine();
        if (v != 'n') {
            return v;
        }
        v = verifyDiag();
        if (v != 'n') {
            return v;
        }
        return 'n';


    }
}
