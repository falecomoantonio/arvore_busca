package Unicatolica.ArvoreBusca.Model;


public class BinaryTree {

    private Node nodeRoot;

    public BinaryTree() {
        this.nodeRoot = null;
    }

    public BinaryTree(Node root) {
        this.nodeRoot = root;
    }

    public Node getNodeRoot() {
        return this.nodeRoot;
    }

    public void addValue(int value) {
        this.nodeRoot = this.addRecursive(this.nodeRoot, value);
    }

    private Node addRecursive(Node tmpNode, int value) {
        if(tmpNode == null) {
            return new Node(value);
        }

        if(value < tmpNode.getValue()) {
            tmpNode.setNodeLeft(this.addRecursive(tmpNode.getNodeLeft(), value));
        }
        else if(value > tmpNode.getValue()) {
            tmpNode.setNodeRight(this.addRecursive(tmpNode.getNodeRight(), value));
        }

        return tmpNode;
    }

    public int countNode()
    {
        return this.countNodeRecursive(this.nodeRoot);
    }

    private int countNodeRecursive(Node tmpNode) {
        if(tmpNode == null) {
            return 0;
        } else {
            return countNodeRecursive(tmpNode.getNodeLeft()) + 1 + this.countNodeRecursive(tmpNode.getNodeRight());
        }
    }

    public boolean isEmpty()
    {
        if(this.nodeRoot == null)
            return true;

        int count = this.countNodeRecursive(this.nodeRoot);
        return count == 0;
    }
}