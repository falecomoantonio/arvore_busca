package Unicatolica.ArvoreBusca.Program;

import Unicatolica.ArvoreBusca.Logic.*;
import Unicatolica.ArvoreBusca.Model.BinaryTree;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Program {

    private static Scanner in = new Scanner(System.in);
    private static BinaryTree tree = null;

    private static void autoFillBinaryTree() {
        tree = new BinaryTreeWrapper().autoFill();
    }

    private static void fillBinaryTree() {
        int[] collection = (int[]) Array.newInstance(int.class, 16);

        for(int i = 0; i < collection.length; i++) {
            System.out.print(String.format("Número [%d de 16] >> ", (i + 1)));
            String value = in.next();

            try {
                collection[i] = Integer.parseInt(value);
            } catch (Exception e) {
                i--;
                System.err.println("Entrada Inválida");
            }
        }
        tree = new BinaryTreeWrapper().fill(collection);
    }

    private static void printMenu()
    {
        System.out.println("[ 1 ] - Procurar um valor e comparar (Profundidade x Largura)");
        System.out.println("[ 2 ] - Limpar e Preencher Árvore Manualmente");
        System.out.println("[ 3 ] - Limpar e Preencher Árvore Automaticamente");
        System.out.println("[ 0 ] - Sair");
    }

    public static void compare() {
        if(tree == null) {
            System.err.println("Árvore não foi inicializada");
        }
        else {
            System.out.print("Digite um número: ");
            boolean continueLoop = false;
            int valueSearch = 0;

            do {
                String inputValue = in.next();
                try {
                    valueSearch = Integer.parseInt(inputValue);
                    continueLoop = false;
                } catch (Exception e) {
                    continueLoop = true;
                }
            } while(continueLoop);

            AbstractSearch ds = new DepthSearch(),
                           ss = new SpreadSearch();
            ds.setTree(tree,valueSearch);
            ss.setTree(tree,valueSearch);
        }
    }

    public static void main(String[] args) {

        if(tree == null) {
            tree = new BinaryTree();
        }

        boolean continueProgram = true;

        while(continueProgram) {
            printMenu();
            int value = -1; // Cairá no Default

            try {
                String inputStrValue = in.next();
                value = Integer.parseInt(inputStrValue);
            } catch (Exception e) {
                value = -1; // Cairá no Default
            }

            switch (value) {
                case 0: continueProgram = false; break;
                case 1: compare(); break;
                case 2: fillBinaryTree(); break;
                case 3: autoFillBinaryTree(); break;
                default: System.out.println("Opção inválida, tente novamente!"); break;
            }

            System.out.println(tree.countNode());
            BinaryTreePrinter printer = new BinaryTreePrinter(tree);

            System.out.println();
            printer.print();
            System.out.println("\n");
        }
    }
}
