package org.example;
import java.util.ArrayList;
import java.util.Arrays;
public class BSTMain {
    public static void main(String[] args) {
        BST tree = new BST();

        Colleague c1 = new Colleague("litfried", 2022, 2,
                1, new ArrayList<>(Arrays.asList("coding", "music")));
        Colleague c2 = new Colleague("tika", 2022, 3, 2,
                new ArrayList<>(Arrays.asList("reading", "swimming")));
        Colleague c3 = new Colleague("lynConway", 2021, 4,
                3, new ArrayList<>(Arrays.asList("hiking", "yoga")));


        tree.insertColleague(c1);
        tree.insertColleague(c2);
        tree.insertColleague(c3);


















    }
}





