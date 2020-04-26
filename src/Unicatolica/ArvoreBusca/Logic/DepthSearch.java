package Unicatolica.ArvoreBusca.Logic;

import Unicatolica.ArvoreBusca.Logic.Interfaces.IAbstractSearch;
import Unicatolica.ArvoreBusca.Model.BinaryTree;
import Unicatolica.ArvoreBusca.Model.Node;

import java.util.Optional;
import java.util.Stack;

public class DepthSearch extends AbstractSearch implements IAbstractSearch {

    private Stack<Node> target;

    public DepthSearch() {
        super();
        this.target = new Stack<Node>();
    }

    public DepthSearch(int value) {
        super(value);
        this.target = new Stack<Node>();
    }

    @Override
    public boolean search(Node no) {
        if (this.isSearchValue(no)) {
            this.getParent(no);
            return true;
        } else {
            if (no.getNodeRight() != null) {
                this.target.push(no.getNodeRight());
            }
            if (no.getNodeLeft() != null) {
                this.target.push(no.getNodeLeft());
            }
        }

        Node tmpNode = this.target.pop();
        if (tmpNode != null && this.search(tmpNode)) {
            return true;
        }
        return false;
    }

    public void setTree(BinaryTree tree, int searchValue) {
        this.searchValue = searchValue;
        boolean result = this.search(tree.getNodeRoot());
        if(result) {
            this.printer();
        }
    }

    public boolean isSearchValue(Node node) {
        return Optional.ofNullable(node.getValue() == this.searchValue).orElse(false);
    }

    @Override
    public int count() {
        return Optional.ofNullable(this.target.size()).orElse(0);
    }
}