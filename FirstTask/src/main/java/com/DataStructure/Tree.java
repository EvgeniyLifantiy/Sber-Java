package com.DataStructure;

public class Tree {

    private Tree left;

    private Tree right;

    private int key;

    public Tree(Tree left, Tree right, int key) {
        this.left = left;
        this.right = right;
        this.key = key;
    }

}
