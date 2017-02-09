import moves.Move;
import moves.TttMove;

import java.io.IOException;
import java.util.*;

/**
 * Created by Eriwyr on 07/02/2017.
 */
public class Morpion extends Game {
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

            if (!grid.isFull() && !end ) {

                if (!playAgain) {
                    AIPlays(ai);
                    System.out.println("L'IA joue : ");
                    grid.printGrid();

                    v = verifyEndGame();
                    if (v != 'n') {
                        System.out.println("Les " + v + " ont gagné ! ");
                        end = true;
                    }
                }



            }else {
                end = true;
            }
        }
        System.out.println("Fin du jeu");
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
    @Override
    public void play(Move move){
        if (move.getPlayer() == 0) { // 0 dans player => IA
            grid.setXY(((TttMove)move).getX(),((TttMove)move).getY(), 'o');
        } else { // 1 => joueur
            grid.setXY(((TttMove)move).getX(),((TttMove)move).getY(), 'x');
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

        int intX = x-48;
        int intY = y-48;
        if (allowed(intX, intY)) {
            grid.setXY(intX, intY, c);
            playAgain= false;
        } else {
            System.out.println("Merci de choisir une case libre");
            playAgain = true;
        }

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


    public char verifyCol(){ // return x if x win, o if y win, n if nobody win
        int cmptX;
        int cmptY;
        for(int j =0 ; j<3 ; j++){
            cmptX = 0;
            cmptY = 0;
            for(int i=0; i<3; i++){
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
    }/*
    public char verifyCol(){
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(grid.getXY(i,j) != 'x')
                {
                    break;
                }
                if(j==3) { return 'x';}
            }

            for(int j=0; j<3; j++) {
                if(grid.getXY(i,j) != 'o')
                {
                    break;
                }
                if(j==3) { return 'o';}
            }
        }
        return 'n';
    }*/

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

    public boolean allowed(int x, int y) {
        if (grid.getXY(x, y) == 'n') return true;
        else return false;
    }

    @Override
    public ArrayList<Move> getPossibleMoves() {
        ArrayList<Move> list = new ArrayList<Move>();
        for (int i =0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (grid.getXY(i, j) == 'n') {
                    list.add(new TttMove(i, j));
                }
            }
        }
         return list;
    }

    @Override
    public double evaluate(){
        int returnValue;
        switch (verifyEndGame()) {
            case 'n':
                returnValue = 0;
                break;
            case 'o':
                returnValue = 1;
                break;
            case 'x':
                returnValue = -1;
                break;
            default :
                returnValue = 4;
                break;
        }
         return returnValue;
    }
    @Override
    public void resetToTurn(int n){
        
    }

    @Override
    protected void addMove(Move move) {
        moves.add(move);
    }




}
