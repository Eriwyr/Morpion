package moves;

/**
 * Created by Mathieu on 09/02/2017.
 */
public abstract class Move {
    int turn;
    int player;
    double evaluation;




    public double getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(double evaluation) {
        this.evaluation = evaluation;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }


}
