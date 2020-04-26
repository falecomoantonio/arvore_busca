package Unicatolica.ArvoreBusca.Logic;

import Unicatolica.ArvoreBusca.Model.BinaryTree;
import Unicatolica.ArvoreBusca.Model.Node;

public abstract class AbstractSearch {

    protected int searchValue;

    private String message;

    public AbstractSearch() {
        this.message = new String();
        this.searchValue = 0;
    }

    public AbstractSearch(int value) {
        this.message = new String();
        this.searchValue = value;
    }

    protected void getParent(Node node) {
        String sequence = new String();
        Node tmpValue = node;
        sequence = sequence.concat(node.toString());
        sequence = sequence.concat(" > ");
        while (node.getParent() != null) {
            tmpValue = tmpValue.getParent();
            sequence = sequence.concat(tmpValue.toString());
        }
        this.message = this.message.concat(sequence);
    }

    protected void printer() {
        if (this.message != null || this.message != "") {
            System.out.println("Caminho possível: " + this.message);
        } else {
            System.out.printf("%d não encontrado", this.searchValue);
            System.out.println("");
        }
    }

    public abstract void setTree(BinaryTree tree, int valueSearch);
}
