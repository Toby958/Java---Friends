Step 1: Create the Colleague Class 
•	File: Colleague.java
•	Required attributes:
o	String tag (screen name)
o	int joinYear, int joinMonth, int joinDay
o	ArrayList<String> interests
•	Constructor: Accepts all above attributes in order
•	Getters and Setters for all attributes
•	Additional methods:
o	String getDateJoined() → returns "YYYY-MM-DD"
o	String getUserName() → returns "HAR@" + tag
o	String toString() → for debugging only
•	Test class: ColleagueMain.java
 
Step 2: Create the BSTNode Class (10 marks)
•	File: BSTNode.java
•	Attributes:
o	Colleague c
o	BSTNode l (left)
o	BSTNode r (right)
•	Constructor: Accepts a Colleague object
•	Required methods:
o	Colleague getC()
o	BSTNode getL(), void setL(BSTNode)
o	BSTNode getR(), void setR(BSTNode)
•	Test class: BSTNodeMain.java
 
Step 3: Create the BST Class (15 marks)
•	File: BST.java
•	Attribute: BSTNode root
•	Constructor: BST()
•	Method:
o	void insertColleague(Colleague c)
	Creates a new BSTNode and inserts it alphabetically by username (case-insensitive)
	Uses recursion
•	Restrictions:
o	Do not create a getRoot() method
•	Test class: BSTMain.java
 
Step 4: Create the FileReader Class (20 marks)
•	File: FileReader.java
•	Method:
o	public static BST readColleagues(String filename)
•	Reads a file where each line contains:
css
CopyEdit
tag;YYYY-MM-DD;interest1,interest2,...
•	Actions:
o	Create Colleague objects from each line
o	Insert them into the BST using insertColleague()
•	Recommended: Use Scanner for reading files
•	Handle all exceptions internally
•	Test class: FileReaderMain.java
 
Step 5: Unique Usernames and Reverse Alphabetic Traversal (15 marks)
•	Enhancement in Colleague class:
o	Method: getUniqueUserName() → format: HAR@tag#XYZ (starting at 100)
•	Enhancement in BST class:
o	Method: printReverseAlphabetic() → returns String with one UUN per line in reverse alphabetical order
•	Test class: AlphaMain.java
•	Note: BST still uses usernames (not UUNs) for ordering
 
Step 6: Find a New Friend (Graph) (15 marks)
•	Enhancements in Colleague class:
o	Attribute: friends (standard collection, e.g. ArrayList)
o	Method: void befriend(Colleague c)
o	Method: boolean isFriendsWith(Colleague c)
o	Method: int numFriends()
•	New class: Graph.java
o	Attribute: BST tree
o	Constructor: Graph(BST tree, String edgeFilename)
o	Reads a file with format:
CopyEdit
username1,username2
o	Each line creates a mutual friendship
o	Handles missing users and avoids duplicate friendships
•	Final Method:
Colleague findFriend(String userName)
Returns a match who:
1.	Is not already friends
2.	Shares at least one interest
3.	Has the fewest friends
4.	Joined most recently
o	Returns null if no match found
o	May add helper methods if needed
•	Test class: GraphMain.java
o	Use your own colleagues.txt and edges.txt for testing

![image](https://github.com/user-attachments/assets/43ff898e-4fab-45c0-9831-1a1a46b150eb)
