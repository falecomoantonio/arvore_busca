package Unicatolica.ArvoreBusca.Logic.Interfaces;

import Unicatolica.ArvoreBusca.Model.Node;

public interface IAbstractSearch {
    boolean search(Node no);

    default int count() {
        return 0;
    }
}
