package com.usu;

public class Main {


    public static void main(String[] args) {
	// write your code here

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(20);
        tree.insert(33);
        tree.insert(11);
        tree.insert(17);
        tree.insert(26);
        tree.insert(110);
        tree.insert(24);

        if (tree.search(26)) {
            System.out.println("found me!");
        } else {
            System.out.println("value not found");
        }

        tree.remove(24);
        tree.display();
    }
}
