package org.example;



import java.io.*;
import java.io.FileReader;
import java.util.*;
import java.util.ArrayList;

public class  Graph extends BST {
    private BST bst;
    private Map<String, Colleague> colleagues;

    public Graph(BST bst, String edgeListFile) {
        this.bst = bst;
        this.colleagues = new HashMap<>();
    }

    private void populateGraph(String edgeListFile) {
        try (BufferedReader br = new BufferedReader(new FileReader("edges-2.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length != 7) {
                    System.out.println("Invalid line: " + line);
                    continue;
                }
                String username1 = tokens[0];
                String username2 = tokens[1];
                int year = Integer.parseInt(tokens[2]);
                int month = Integer.parseInt(tokens[3]);
                int day = Integer.parseInt(tokens[4]);
                int numFriends = Integer.parseInt(tokens[5]);
                String[] interests = tokens[6].split(";");

                // Skip line if colleagues not in BST
                if (!bst.searchColleague(username1)) {
                    System.out.println(username1 + " not found in BST");
                    continue;
                }
                if (!bst.searchColleague(username2)) {
                    System.out.println(username2 + " not found in BST");
                    continue;
                }

                Colleague c1 = colleagues.getOrDefault(username1, new Colleague(username1, year, month, day, new ArrayList<>(Arrays.asList(interests))));
                Colleague c2 = colleagues.getOrDefault(username2, new Colleague(username2, year, month, day, new ArrayList<>(Arrays.asList(interests))));
                colleagues.putIfAbsent(username1, c1);
                colleagues.putIfAbsent(username2, c2);

                c1.befriend(c2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Colleague findFriend(String username) throws Exception {
        Colleague c = colleagues.get(username);
        if (c == null) {
            throw new Exception(username + " not found in graph");
        }

        // Get colleagues with lowest degree
        List<Colleague> lowestDegree = new ArrayList<>();
        int minDegree = Integer.MAX_VALUE;
        for (Colleague friend : c.getFriends()) {
            if (!c.isFriendsWith(friend) && friend.numFriends() < minDegree) {
                lowestDegree.clear();
                lowestDegree.add(friend);
                minDegree = friend.numFriends();
            } else if (!c.isFriendsWith(friend) && friend.numFriends() == minDegree) {
                lowestDegree.add(friend);
            }
        }

        // Get colleague with latest join date among colleagues with lowest degree
        if (lowestDegree.isEmpty()) {
            return null;
        }
        Colleague candidateFriend = lowestDegree.get(0);
        for (int i = 1; i < lowestDegree.size(); i++) {
            if (lowestDegree.get(i).getUserName().compareTo(candidateFriend.getUserName()) > 0) {
                candidateFriend = lowestDegree.get(i);
            }
        }
        return candidateFriend;
    }
}