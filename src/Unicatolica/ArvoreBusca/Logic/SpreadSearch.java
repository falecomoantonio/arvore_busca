package Unicatolica.ArvoreBusca.Logic;

import Unicatolica.ArvoreBusca.Logic.Interfaces.IAbstractSearch;
import Unicatolica.ArvoreBusca.Model.BinaryTree;
import Unicatolica.ArvoreBusca.Model.Node;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public final class SpreadSearch extends AbstractSearch implements IAbstractSearch {

    private Queue<Node> target;

    public SpreadSearch() {
        super();
        this.target = new LinkedList<Node>();
    }

    public SpreadSearch(int value) {
        super(value);
        this.target = new LinkedList<Node>();
    }

    @Override
    public void setTree(BinaryTree tree, int valueSearch) {
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
    public boolean search(Node no) {
        if (this.isSearchValue(no)) {
            this.getParent(no);
            return true;
        } else {
            if (no.getNodeLeft() != null) {
                this.target.add(no.getNodeLeft());
            }
            if (no.getNodeRight() != null) {
                this.target.add(no.getNodeRight());
            }

            Node tmpNode = this.target.poll();
            if (tmpNode != null && this.search(tmpNode)) {
                return true;
            }
            return false;
        }
    }

    @Override
    public int count() {
        return Optional.ofNullable(this.target.size()).orElse(0);
    }
}
