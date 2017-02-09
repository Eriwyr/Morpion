import java.util.Vector;

/**
 * Created by maxencebernier on 07/02/2017.
 */
public class AIIterative implements AI{
    boolean decisionTaken;
    //Counters
    private int countO =0;
    private int countX =0;
    private int targetX;
    private int targetY;
    private Vector decision;



    public AIIterative() {
        decisionTaken = false;
        decision = new Vector(2);
        decision.add(5);
        decision.add(5);
    }

    public Vector nextAvailablePosition(Grid grid) {
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j ++){
                // the AI goes through the entire grid, and sets the decision as soon as it finds an available spot
                if(grid.getXY(i, j) == 'n') {
                    decisionTaken = true;
                    decision.add(0, i);
                    decision.add(1, j);
                    break;
                }
            }
            if (decisionTaken) {
                // if a decision is taken, we ccan stop looking
                break;
            }
        }
        return decision;
    }
    
    @Override
    public Vector takeDecision(Grid grid) { //Method called every time it's the AI turn to
        decisionTaken = false; //When the turn begins, the AI has not yet taken a decision

        // The AI check every line, column and diagonal for options.
        checkLine(grid);
        checkColumn(grid);
        checkDiag(grid);

        //If it has found a good option in the checks above, the decision that was set it returned to the game.
        if (decisionTaken) {
            return decision;
        } else { // if not, the AI will take the first available position it finds in the game.
            return nextAvailablePosition(grid);
        }
    }

    public void checkLine(Grid grid) {
        // Counters are initialised
        initializeCounters();
            for (int i = 0; i<3; i++) {
                // Counters are initialised every time we check a new line.
                initializeCounters();
                for (int j = 0; j<3; j++) {
                    //In every line, we count what interests us.
                    countSigns(i, j, grid);
                }
                //Counters are analysed and a decision is taken accordingly.
                setDecision();
            }
    }


    public void checkColumn(Grid grid) {
        // Counters are initialised
        initializeCounters();
            for (int j = 0; j<3; j++) {
                // Counters are initialised every time we check a new column.
                initializeCounters();
                for (int i = 0; i<3; i++) {
                    //In every column, we count what interests us.
                    countSigns(i, j, grid);
                }
                //Counters are analysed and a decision is taken accordingly.
                setDecision();
            }
    }

    public void checkDiag(Grid grid) {
        // Counters are initialised
        initializeCounters();
        //The first diagonal is checked
        int j;
        for (int i = 0; i<3; i++) {
            j=i;
            //we count what interests us.
            countSigns(i, j, grid);
        }
        //Counters are analysed and a decision is taken accordingly.
        setDecision();

        // Counters are initialised for the second diagonal
        initializeCounters();
        //The second diagonal is checked
        j =3;
        for (int i = 0; i<3; i++) {
            j-=1;
            //we count what interests us.
            countSigns(i, j, grid);
        }
        //Counters are analysed and a decision is taken accordingly.
        setDecision();


    }

    // This method, which is called at the end of every check of a line
    // a column are a diagonal counts the number of each kind of letter
    // we can find on the grid
    public void countSigns(int x, int y, Grid grid) {
        switch (grid.getXY(x, y)) {
            case 'o' :
                // If we find an 'o', the according counter is incremented
                countO ++;
                break;
            case 'n':
                // If we fiend an 'n', this means the cell is empty and is an option for the AI to play.
                //It is stored
                targetX = x;
                targetY = y;
                break;
            case 'x':
                // same as 'o'
                countX ++;
        }

    }

    public void setDecision(){
    // The counters are analysed for every line, column and diagonals
        if (decisionTaken && (countO == 2 && countX ==0)) {
            // if a decision is already taken, but  we found a position
            // where the AI can play and win, it becomes the new decision
            decision.add(0, targetX);
            decision.add(1, targetY);
        } else if(!decisionTaken &&((countO == 2 && countX ==0)|| (countX == 2 && countO == 0))) {
            // if we find in the line / column / diagonal tow of a certain letter, and the thrid place is empty, this becomes our decision :
            //if there is two 'x', the AI blocks the payers. If there is two 'o', the AI wins.
            decisionTaken= true;
            decision.add(0, targetX);
            decision.add(1, targetY);
        }
    }

    void initializeCounters(){
        //Counters initialized at every  line / column / diagonal
        countO =0;
        countX =0;
    }
}
