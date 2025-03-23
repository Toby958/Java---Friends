package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class AlphaMain {
    public static void main(String[] args) {

        Colleague c1 = new Colleague("tika", 2022, 3,
                20, new ArrayList<>(Arrays.asList("coding", "reading")));
        Colleague c2 = new Colleague("litfried", 2022, 3,
                21, new ArrayList<>(Arrays.asList("writing", "singing")));
        Colleague c3 = new Colleague("dan", 2022, 3,
                22, new ArrayList<>(Arrays.asList("dancing", "painting")));

        BST bst = new BST();
        bst.insertColleague(c3);
        bst.insertColleague(c2);
        bst.insertColleague(c1);

        System.out.println(bst.printReverseAlphabetic());

    }
}