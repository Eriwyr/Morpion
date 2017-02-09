import moves.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Mathieu on 09/02/2017.
 */


public class Tree<T> {

    private Node<T> root;

    public Tree(T rootData) {
        root = new Node<T>();
        root.data = rootData;
        root.children = new ArrayList<Node<T>>();
    }

    public static class Node<T> {
        private T data;
        private Node<T> parent;
        private List<Node<T>> children;
    }

    public void keepBranch(){
        int index ;

        for(Node<T> node  : this.root.children){

        }

    //    this = this.root = root.children.get();
    }
}