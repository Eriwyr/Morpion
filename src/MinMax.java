import moves.Move;
import moves.TttMove;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mathieu on 09/02/2017.
 */
public class MinMax {

    private Tree<Move> tree;
    private Game game;


    public void play(){


        Move lastMove = game.lastMove();
        if(tree == null){
            initializeTree(lastMove); // If it's the first AI move, we initialize the moves possibilities tree
        }else{
            updateTreeRoot(lastMove); // Else, we update the moves tree after the player has played.
        }


        Move nextMove = getBestMove();

        game.play(nextMove);


        updateTreeRoot(nextMove); // The AI has played, we update the moves tree.
    }





    private void initializeTree(Move firstMove) {

        tree.setRoot(new Tree.Node<>(firstMove));

        initializeTree2(tree.getRoot(), 1);
    }


    private double initializeTree2(Tree.Node<Move> node, int n){

        ArrayList<Double> leafValues = new ArrayList<>();


        if(n !=1){

            game.play(node.getData());
        }

        if(game.isFinished() || n > 10){

            double eval = game.evaluate();
            node.getData().setEvaluation(eval);
            return eval;
        }
        else{

            for (Move move : game.getMoves()) {

                if(n != game.getTurn()){
                    game.resetToTurn(n);
                }

                Tree.Node<Move> tempNode = new Tree.Node<>(move);

                node.getChildren().add(tempNode);

                tempNode.setParent(node);

                tempNode.getData().setEvaluation(initializeTree2(tempNode, n + 1));

                leafValues.add(tempNode.getData().getEvaluation());
            }

            if( n%2 == 0){

                return Collections.min(leafValues);
            }
            else{
                return Collections.max(leafValues);
            }
        }

    }




    private Move getBestMove(){

        double max = -20;
        Move bestMove = new TttMove(0,0);

        for (Tree.Node<Move> childNode: tree.getRoot().getChildren()) {

            if(childNode.getData().getEvaluation() > max){
                bestMove = childNode.getData();
            }

        }
        return bestMove;
    }







    private void updateTreeRoot(Move move){
        tree.keepBranch(move);
    }



    public MinMax(Game game){
        this.game = game;
    }







    public Tree<Move> getTree() {
        return tree;
    }

    public void setTree(Tree<Move> tree) {
        this.tree = tree;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
