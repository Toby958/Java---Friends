package org.example;


/**
 The BST class represents a binary search tree of Colleague objects, where the order is based on the unique username of each Colleague.
 */
public class BST {

    private BSTNode root;

    /**
     * Initializes an empty binary search tree.
     */
    public BST() {
        root = null;
    }

    /**
     * Inserts a Colleague object into the binary search tree.
     * @param c the Colleague object to be inserted
     */
    public void insertColleague(Colleague c) {
        if (c == null) {
            return;
        }
        BSTNode newNode = new BSTNode(c);
        if (root == null) {
            root = newNode;
        } else {
            insertColleagueHelper(root, newNode);
        }
    }

    /**
     * A helper method for inserting a Colleague object into the binary search tree.
     *
     * @param node    the current node being compared to the new node
     * @param newNode the node to be inserted
     */
    private void insertColleagueHelper(BSTNode node, BSTNode newNode) {

        String newNodeUsername = newNode.getC().getUserName().toLowerCase();
        String nodeUsername = node.getC().getUserName().toLowerCase();
        int i = 0;

        while (i < newNodeUsername.length() && i < nodeUsername.length()) {
            if (newNodeUsername.charAt(i) < nodeUsername.charAt(i)) {
                if (node.getL() == null) {
                    node.setL(newNode);
                } else {
                    insertColleagueHelper(node.getL(), newNode);
                }
                return;

            } else if (newNodeUsername.charAt(i) > nodeUsername.charAt(i)) {
                if (node.getR() == null) {
                    node.setR(newNode);
                } else {
                    insertColleagueHelper(node.getR(), newNode);
                }

                return;
            }
            i++;
        }
    }
    /**
     Returns a string of the unique usernames of all Colleague objects in the binary search tree, sorted in reverse alphabetical order.
     @return a string of the unique usernames in reverse alphabetical order
     */
    public String printReverseAlphabetic() {
        StringBuilder sb = new StringBuilder();
        reverseInOrderTraversal(root, sb);
        return sb.toString();
    }

    /**
     A helper method for printing the unique usernames of all Colleague objects in the binary search tree in reverse alphabetical order.
     @param node the current node being visited
     @param sb the StringBuilder used to build the string of unique usernames
     */
    private void reverseInOrderTraversal(BSTNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        reverseInOrderTraversal(node.getR(), sb);
        sb.append(node.getC().getUniqueUserName()).append("\n");
        reverseInOrderTraversal(node.getL(), sb);
    }

    public boolean searchColleague(String username) {
        if (username == null) {
            return false;
        }
        String lowercaseUsername = username.toLowerCase();
        BSTNode currentNode = root;
        while (currentNode != null) {
            String currentNodeUsername = currentNode.getC().getUserName().toLowerCase();
            if (lowercaseUsername.equals(currentNodeUsername)) {
                return true;
            } else if (lowercaseUsername.compareTo(currentNodeUsername) < 0) {
                currentNode = currentNode.getL();
            } else {
                currentNode = currentNode.getR();
            }
        }
        return false;
    }


}





