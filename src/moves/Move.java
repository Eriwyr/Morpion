/**
 * Created by Mathieu on 09/02/2017.
 */
abstract class Move {
    int turn;
    int player;


    
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
