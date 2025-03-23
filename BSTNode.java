package org.example;

/**
 This class represents a node in a binary search tree for colleagues.
 */
public class BSTNode {

    // Colleague object held in this node
    private final Colleague c;

    // left child of this node
    private BSTNode l;

    // right child of this node
    private BSTNode r;


    /**
     Constructor for creating a BSTNode object with a given Colleague object
     @param elem the Colleague object to be stored in this node
     */
    public BSTNode(Colleague elem) {
        c = elem;
        l = null;
        r = null;
    }


    /**
     Getter method for retrieving the Colleague object stored in this node
     @return the Colleague object stored in this node
     */
    public Colleague getC() {
        return c;
    }


    /**
     Setter method for setting the left child of this node
     @param l the BSTNode to be set as the left child of this node
     */
    public void setL(BSTNode l) {
        this.l = l;
    }


    /**
     Setter method for setting the right child of this node
     @param r the BSTNode to be set as the right child of this node
     */
    public void setR(BSTNode r) {
        this.r = r;
    }


    /**
     Getter method for retrieving the left child of this node
     @return the left child of this node
     */
    public BSTNode getL() {
        return l;
    }


    /**
     Getter method for retrieving the right child of this node
     @return the right child of this node
     */
    public BSTNode getR() {
        return r;
    }
}