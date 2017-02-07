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

    public Vector randomDecision(Grid grid) {
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j ++){
                if(grid.getXY(i, j) == 'n') {
                    decisionTaken = true;
                    decision.add(0, i);
                    decision.add(1, j);
                    break;
                }
            }
            if (decisionTaken) {
                break;
            }
        }
        return decision;
    }
    @Override
    public Vector takeDecision(Grid grid) {
        decisionTaken = false;
        checkLine(grid);
        checkColumn(grid);
        checkDiag(grid);

        if (decisionTaken) {
            return decision;
        } else {
            return randomDecision(grid);
        }
    }

    public void checkLine(Grid grid) {
        initializeCounters();
            for (int i = 0; i<3; i++) {
                initializeCounters();
                for (int j = 0; j<3; j++) {
                    countSigns(i, j, grid);
                }
                setDecision();
            }

    }


    public void checkColumn(Grid grid) {
        initializeCounters();

            for (int j = 0; j<3; j++) {
                initializeCounters();
                for (int i = 0; i<3; i++) {
                    countSigns(i, j, grid);
                }
                setDecision();
            }
    }

    public void checkDiag(Grid grid) {
        initializeCounters();
            int countO =0;
            int countX =0;
            int targetX;
            int targetY;
            int j;
            //première diagonale
            initializeCounters();
            for (int i = 0; i<3; i++) {
                j=i;
                countSigns(i, j, grid);

            }

            setDecision();

            initializeCounters();
            //Deuxième diagronale
            j =3;
            for (int i = 0; i<3; i++) {
                j-=1;
                countSigns(i, j, grid);
            }

            setDecision();


    }

    public void countSigns(int x, int y, Grid grid) {
        switch (grid.getXY(x, y)) {
            case 'o' :
                countO ++;
                break;
            case 'n':
                targetX = x;
                targetY = y;
                break;
            case 'x':
                countX ++;
        }

    }

    public void setDecision(){

        if (decisionTaken && (countO == 2 && countX ==0)) {
            decision.add(0, targetX);
            decision.add(1, targetY);
        } else if(!decisionTaken &&((countO == 2 && countX ==0)|| (countX == 2 && countO == 0))) {
            decisionTaken= true;
            decision.add(0, targetX);
            decision.add(1, targetY);
        }
    }

    void initializeCounters(){
        countO =0;
        countX =0;
    }
}
