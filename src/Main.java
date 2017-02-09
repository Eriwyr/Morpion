import moves.Move;
import moves.TttMove;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Morpion morpion = new Morpion();
     //   morpion.start();
        ArrayList<Move> l = morpion.getPossibleMoves();
        System.out.println(l.size());

    }
}
