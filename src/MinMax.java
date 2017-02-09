import moves.Move;

import java.util.Map;

/**
 * Created by Mathieu on 09/02/2017.
 */
public class MinMax {

    private Tree<Map<Move, Integer>> tree;
    private Game testGame;










    public Tree<Map<Move, Integer>> getTree() {
        return tree;
    }

    public void setTree(Tree<Map<Move, Integer>> tree) {
        this.tree = tree;
    }

    public Game getTestGame() {
        return testGame;
    }

    public void setTestGame(Game testGame) {
        this.testGame = testGame;
    }
}
