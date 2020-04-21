package Unicatolica.ArvoreBusca.Model;


public class BinaryTree {

    private Node nodeRoot;

    public BinaryTree() {
        this.nodeRoot = null;
    }

    public BinaryTree(Node root) {
        this.nodeRoot = root;
    }

    public void addValue(int value) {
        this.nodeRoot = this.addRecursive(this.nodeRoot, value);
    }

    private Node addRecursive(Node tmpNode, int value) {
        if(tmpNode == null) {
            return new Node(value);
        }

        if(value < tmpNode.getValue()) {
            tmpNode.setNodeRight(this.addRecursive(tmpNode.getNodeLeft(), value));
            return tmpNode;
        }
        else if(value > tmpNode.getValue()) {
            tmpNode.setNodeRight(this.addRecursive(tmpNode.getNodeRight(), value));
            return tmpNode;
        } else {
            return tmpNode;
        }
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
}