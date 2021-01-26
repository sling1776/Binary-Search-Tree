package com.usu;

import com.sun.source.tree.Tree;

public class BinarySearchTree {
    private class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
    }

    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            TreeNode node = new TreeNode();
            node.value = value;
            root = node;
        } else {
            TreeNode parent = null;
            TreeNode current = root;
            while (current != null) {
                parent = current;
                if (current.value < value) {
                    current = current.right;
                } else {
                    current = current.left;
                }
            }

            TreeNode newNode = new TreeNode();
            newNode.value = value;
            if (parent.value < value) {
                parent.right = newNode;
            } else {
                parent.left  = newNode;
            }
        }
    }

    public boolean search(int value) {
        TreeNode current = root;
        while (current != null) {
            if (current.value == value) {
                return true;
            } else if (current.value < value) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return false;
    }

    public void display() {
        display(root);
    }

    private void display(TreeNode node) {
        if (node == null) return;
        display(node.left);
        System.out.println(node.value);
        display(node.right);
    }

    public int count() {
        return count(root);
    }

    private int count(TreeNode node) {
        if(node == null) return 0;
        return 1 + count(node.left) + count(node.right);
    }


    public int leafCount() {
        return leafCount(root);
    }

    private int leafCount(TreeNode node) {
        if(node == null) return 0;
        if(node.right == null && node.left == null) return 1;
        return leafCount(node.left) + leafCount(node.right);
    }

    public int height() {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right));
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }


    public boolean remove(int value) {
        TreeNode parent = null;
        TreeNode node = root;
        boolean found = false;
        while(!found && node != null) {
            if (node.value < value) {
                parent = node;
                node = node.right;
            } else if (node.value > value) {
                parent = node;
                node = node.left;
            } else {
                found = true;
            }
        }

        if (!found) return false;

        if (node.left == null) {
            if (parent == null) {
                root = node.right;
            } else if (parent.value < value) {
                parent.right = node.right;
            } else {
                parent.left = node.right;
            }
        } else {
            TreeNode parentOfRight = node;
            TreeNode rightMost = node.left;
            while(rightMost.right != null) {
                parentOfRight = rightMost;
                rightMost = rightMost.right;
            }

            node.value = rightMost.value;

            if (parentOfRight.right == rightMost) {
                parentOfRight.right = rightMost.left;
            } else {
                parentOfRight.left = rightMost.left;
            }
        }
        return true;
    }



}
