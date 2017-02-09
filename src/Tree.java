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

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public List<Node<T>> getChildren() {
            return children;
        }

        public void setChildren(List<Node<T>> children) {
            this.children = children;
        }
    }

    public void keepBranch(T param) {

        for (Node<T> node : this.root.children) {
            if (param.equals(node.data)) {
                this.root = node;
            }
        }
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }
}