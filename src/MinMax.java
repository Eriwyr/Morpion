import moves.Move;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mathieu on 09/02/2017.
 */
public class MinMax {

    /*private Tree<Map<Move, Integer>> tree;
    private Game game;


    public void play(){

        if(tree == null){
            intializeTree(); // If it's the first AI move, we initialize the moves possibilities tree
        }else{
            updateTreeRoot(game.lastMove()); // Else, we update the moves tree after the player has played.
        }


        Move nextMove = getBestMove();

        game.play(nextMove);


        updateTreeRoot(nextMove); // The AI has played, we update the moves tree.
    }

    private void intializeTree() {
        
    }


    private Move getBestMove(){

    }







    private void updateTreeRoot(Move move){

        Integer x = tree.getRoot().getData().get(move);

        Map<Move, Integer> mapLastMove = new Map<Move, Integer>;

        mapLastMove.put(move, x);

        tree.keepBranch(mapLastMove);
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
    }*/
}
