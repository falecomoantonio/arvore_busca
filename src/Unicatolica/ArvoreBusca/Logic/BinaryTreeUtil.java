package Unicatolica.ArvoreBusca.Logic;

import Unicatolica.ArvoreBusca.Model.BinaryTree;
import Unicatolica.ArvoreBusca.Model.Node;

public class BinaryTreeUtil {

    public int getMaxDepth(BinaryTree tree) {
        return this.getMaxDepthRecursive(tree.getNodeRoot());
    }


    private int getMaxDepthRecursive(Node root)
    {
        if (root == null)
            return 0;

        int leftDepth = this.getMaxDepthRecursive(root.getNodeLeft());
        int rightDepth = this.getMaxDepthRecursive(root.getNodeRight());

        return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
    }


    public boolean containsValue(BinaryTree tree, int value) {
        return this.containsValueRecursive(tree.getNodeRoot(),value);
    }

    private boolean containsValueRecursive(Node internalRoot, int value) {
        if(internalRoot == null) {
            return false;
        }

        if(internalRoot.getValue() == value) {
            return true;
        }

        return internalRoot.getValue() < value ?
                this.containsValueRecursive(internalRoot.getNodeLeft(), value) :
                this.containsValueRecursive(internalRoot.getNodeRight(), value);
    }
}
