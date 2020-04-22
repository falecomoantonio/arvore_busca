package Unicatolica.ArvoreBusca.Logic;

import Unicatolica.ArvoreBusca.Model.BinaryTree;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BinaryTreeWrapper {

    private Random rd;

    public BinaryTreeWrapper()
    {
        this.rd = new Random();
    }


    public BinaryTree fill(int[] collection) {
        if(!collection.getClass().isArray())
            return null;

        BinaryTree bt = new BinaryTree();
        for(int i : collection) {
            bt.addValue(i);
        }
        return bt;
    }

    public BinaryTree autoFill() {

        int[] collection = (int[]) Array.newInstance(int.class, 16);
        int min = -100, max = 100;

        for(int i = 0; i < collection.length; i++) {
            collection[i] = this.rd.nextInt((max - min) + 1) + min;
        }

        return this.fill(collection);
    }

}
