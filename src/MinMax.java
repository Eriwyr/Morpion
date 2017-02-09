import moves.Move;
import moves.TttMove;

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
            intializeTree(lastMove); // If it's the first AI move, we initialize the moves possibilities tree
        }else{
            updateTreeRoot(lastMove); // Else, we update the moves tree after the player has played.
        }


        Move nextMove = getBestMove();

        game.play(nextMove);


        updateTreeRoot(nextMove); // The AI has played, we update the moves tree.
    }





    private void intializeTree(Move firstMove) {

        tree.setRoot(new Tree.Node<>(firstMove));


        initializeTree2(tree.getRoot(), 1);
    }

    private void initializeTree2(Tree.Node<Move> node, int n){



        game.play(node.getData());

        if(game.isFinished() || n > 10){
            node.getData().setEvaluation(game.evaluate());
        }
        else{
            //int i = 0;
            for (Move move : game.getMoves()) {

                if(n != game.getTurn()){
                    game.resetToTurn(n);
                }

                Tree.Node<Move> tempNode = new Tree.Node<>(move);
                node.getChildren().add(tempNode);

                tempNode.setParent(node);

                initializeTree2(tempNode, n + 1);
            }
        }


    }




    private Move getBestMove(){

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
