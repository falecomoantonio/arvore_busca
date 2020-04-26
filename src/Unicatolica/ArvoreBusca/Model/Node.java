package Unicatolica.ArvoreBusca.Model;

public class Node {

    private int defaultValue;
    private Node parent;
    private Node left;
    private Node right;

    public Node(int value) {
        this.defaultValue = value;
        this.right = null;
        this.left = null;
        this.parent = null;
    }

    public Node getParent() {
        return this.parent;
    }

    public void setParent(Node node) {
        this.parent = node;
    }

    public void setValue(int value) {
        this.defaultValue = value;
    }

    public int getValue() {
        return this.defaultValue;
    }

    public void setNodeLeft(Node node) {
        this.left = node;
    }

    public void setNodeRight(Node node) {
        this.right = node;
    }

    public Node getNodeLeft() {
        return this.left;
    }

    public Node getNodeRight() {
        return this.right;
    }

    @Override
    public String toString() {
        Integer wrapper = new Integer(this.defaultValue);
        return wrapper.toString();
    }
}
