package org.example;


//Importing packages
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



/**
 * 1. File-name: Colleagues.java
 * 2. @version 1.0
 * 3. Creation Date: 25.03.23
 * 4. Last Modification Date: 11.03.23
 * 5. @author Toby
 * 6. - No copyright
 * 7. Purpose of the program: Program to represent colleagies
 * 8. Version History: 1.0 - pure code;
 */


/**

 Represents a colleague with a unique tag and interests, and tracks their join date and username.
 Provides methods for getting and setting colleague information and generating unique usernames.
 */
 public class Colleague {

    /** List of friends for the colleague.*/
    private final ArrayList<Colleague> friends;

    /** The tag for the colleague. */
    private String tag;

    /** The year the colleague joined. */
    private int joinYear;

    /** The month the colleague joined. */
    private int joinMonth;

    /** The day the colleague joined. */
    private int joinDay;

    /** List of interests for the colleague. */
    private ArrayList<String> interests;

    /** The unique number for the colleague. */
    private final int uniqueNumber;

    /** The next unique number to be assigned. */
    private static int nextUniqueNumber = 100;



    /**
     * Constructs a new Colleague object with the given tag, join date, and interests.
     *
     * @param tag the user's tag
     * @param joinYear the year the user joined
     * @param joinMonth the month the user joined
     * @param joinDay the day the user joined
     * @param interests a list of the user's interests
     */
    public Colleague(String tag, int joinYear, int joinMonth, int joinDay , ArrayList<String> interests) {
        this.tag = tag;
        this.joinYear = joinYear;
        this.joinMonth = joinMonth;
        this.joinDay = joinDay;
        this.interests = interests;
        this.uniqueNumber = nextUniqueNumber;
        nextUniqueNumber++;
        this.friends = new ArrayList<>();
    }


    /**
     * @return the user's tag
     */
    public String getTag() {
        return tag;
    }


    /**
     * Sets the user's tag.
     * @param tag the user's new tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }


    /**
     * @return the year the user joined
     */
    public int getJoinYear() {
        return joinYear;
    }


    /**
     * Sets the year the user joined.
     * @param joinYear the year the user joined
     */
    public void setJoinYear(int joinYear) {
        this.joinYear = joinYear;
    }


    /**
     * @return the month the user joined
     */
    public int getJoinMonth() {
        return joinMonth;
    }


    /**
     * Sets the month the user joined.
     * @param joinMonth the month the user joined
     */
    public void setJoinMonth(int joinMonth) {
        this.joinMonth = joinMonth;
    }


    /**
     * @return the day the user joined
     */
    public int getJoinDay() {
        return joinDay;
    }


    /**
     * @param joinDay the day the user joined
     */
    public void setJoinDay(int joinDay) {
        this.joinDay = joinDay;
    }


    /**
     * @return a list of the user's interests
     */
    public ArrayList<String> getInterests() {
        return interests;
    }


    /**
     * Sets the user's interests.
     *
     * @param interests a list of the user's new interests
     */
    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }


    /**
     * Gets the date the colleague joined in yyyy-MM-dd format.
     * @return the date the colleague joined in yyyy-MM-dd format
     */
    public String getDateJoined() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, joinYear);
        cal.set(Calendar.MONTH, joinMonth-1);
        cal.set(Calendar.DAY_OF_MONTH, joinDay);
        Date joinDate = cal.getTime();
        String dateString = String.format("%tF", joinDate);
        return dateString;
    }


    /**
     * @return the unique username for this colleague
     */
    public String getUniqueUserName() {
        return "HAR@" + tag + "#" + uniqueNumber;
    }


    /**
     * @return the username for this colleague
     */
    public String getUserName() {

        return "HAR@" + tag;
    }

    public void befriend(Colleague c) {
        friends.add(c);
    }

    public boolean isFriendsWith(Colleague c) {
        return friends.contains(c);
    }

    public int numFriends() {
        return friends.size();
    }

    public ArrayList<Colleague> getFriends() {
        return friends;
    }


    /**
     * @return a string representation of this colleague's profile
     */
    @Override
    public String toString() {
        return "Profile created." + "/n" + "Tag=" + tag + "UserName=" + getUserName()
                + "/n" + "Intrests: " + interests;
    }


}