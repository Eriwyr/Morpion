import moves.Move;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mathieu on 09/02/2017.
 */
public class MinMax {

    private Tree<Map<Move, Integer>> tree;
    private Game game;


    public void play(){

        Move nextMove ;

        nextMove = getBestMove();

        game.play(nextMove);

        tree.keepBranch(nextMove);
    }





    private Move getBestMove(){

    }


    public MinMax(Game game){
        tree = new Tree<>(new HashMap<Move, Integer>());

        this.game = game;
    }


    public Tree<Map<Move, Integer>> getTree() {
        return tree;
    }

    public void setTree(Tree<Map<Move, Integer>> tree) {
        this.tree = tree;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
