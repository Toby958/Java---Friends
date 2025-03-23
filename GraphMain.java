package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import java.io.IOException;

public class GraphMain {

    public static void main(String[] args) throws IOException {
        BST bst = new BST();
        Colleague c1 = new Colleague("Aliceuu", 2022, 2,
                1, new ArrayList<>(Arrays.asList("coding", "music")));
        Colleague c2 = new Colleague("tika", 2022, 3, 2,
                new ArrayList<>(Arrays.asList("reading", "swimming")));
        Colleague c3 = new Colleague("lynConway", 2021, 4,
                3, new ArrayList<>(Arrays.asList("hiking", "yoga")));


        bst.insertColleague(c1);
        bst.insertColleague(c2);
        bst.insertColleague(c3);

        // Create graph
        Graph graph = new Graph(bst, "edges-2.txt");

        // Find friend
        try {
            Colleague friend = graph.findFriend("Alice");
            System.out.println("Friend of Alice with lowest degree and latest join date: " + friend.getUserName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
