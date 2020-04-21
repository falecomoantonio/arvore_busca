package Unicatolica.ArvoreBusca.Program;

import Unicatolica.ArvoreBusca.Model.BinaryTree;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Program {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();

        for(int i = 0;i < 100; i++) {
            int value = ThreadLocalRandom.current().nextInt(-100,100);
            bt.addValue(value);
        }


    }
}
