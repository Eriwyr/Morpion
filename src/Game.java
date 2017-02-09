/**
 * Created by Mathieu on 09/02/2017.
 */
import moves.Move;

import java.util.ArrayList;


public abstract class Game {

    private boolean finished;
    private int turn = 0;
    protected ArrayList<Move> moves;


    public ArrayList<Move> getPossibleMoves(){System.out.println("getPossibleMoves function needs to be overwritten"); return new ArrayList<Move>();}

    public double evaluate(){System.out.println("evaluate function needs to be overwritten"); return 0;}

    public void resetToTurn(int n){System.out.println("resetToTurn function needs to be overwritten"); }

    protected void addMove(Move move){System.out.println("addMoves function needs to be overwritten"); };

    public void play(Move move){System.out.println("play function needs to be overwritten"); addMove(move);};

    public int testFinished(){System.out.println("isFinished function needs to be overwritten"); return 0;};




    public Move lastMove(){
        int size = this.getMoves().size();

        return this.getMoves().get(size - 1);
    }










    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<Move> moves) {
        this.moves = moves;
    }
}
