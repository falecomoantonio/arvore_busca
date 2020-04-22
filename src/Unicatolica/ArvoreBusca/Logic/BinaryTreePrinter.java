package Unicatolica.ArvoreBusca.Logic;

import Unicatolica.ArvoreBusca.Model.BinaryTree;
import Unicatolica.ArvoreBusca.Model.Node;

import java.io.PrintStream;

public class BinaryTreePrinter {

    private BinaryTree tree;

    public BinaryTreePrinter(BinaryTree tree) {
        this.tree = tree;
    }

    private String traversePreOrder(Node root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getValue());

        String pointerRight = "└──";
        String pointerLeft = (root.getNodeRight() != null) ? "├──" : "└──";

        this.traverseNodes(sb, "", pointerLeft, root.getNodeLeft(), root.getNodeRight() != null);
        this.traverseNodes(sb, "", pointerRight, root.getNodeRight(), false);

        return sb.toString();
    }

    private void traverseNodes(StringBuilder sb, String padding, String pointer, Node node, boolean hasRightSibling) {

        if (node != null) {

            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.getNodeRight() != null) ? "├──" : "└──";

            this.traverseNodes(sb, paddingForBoth, pointerLeft, node.getNodeLeft(), node.getNodeRight() != null);
            this.traverseNodes(sb, paddingForBoth, pointerRight, node.getNodeRight(), false);

        }

    }

    public void print() {
        System.out.print(this.traversePreOrder(tree.getNodeRoot()));
    }
}
