package Unicatolica.ArvoreBusca.Program;

import Unicatolica.ArvoreBusca.Logic.BinaryTreePrinter;
import Unicatolica.ArvoreBusca.Logic.BinaryTreeUtil;
import Unicatolica.ArvoreBusca.Logic.BinaryTreeWrapper;
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
        System.out.println("[ 1 ] - Imprimir em Profundidade");
        System.out.println("[ 2 ] - Imprimir em Largura");
        System.out.println("[ 3 ] - Procurar um valor e comparar (Profundidade x Largura)");
        System.out.println("[ 4 ] - Limpar e Preencher Árvore Manualmente");
        System.out.println("[ 5 ] - Limpar e Preencher Árvore Automaticamente");
        System.out.println("[ 0 ] - Sair");
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
                case 1: System.out.println("Opção 1"); break;
                case 2: System.out.println("Opção 2"); break;
                case 3: System.out.println("Opção 3"); break;
                case 4: fillBinaryTree(); break;
                case 5: autoFillBinaryTree(); break;
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
