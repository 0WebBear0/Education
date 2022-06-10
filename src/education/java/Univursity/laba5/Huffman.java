package education.java.Univursity.laba5;

import java.io.*;
import java.util.*;

class Huffman {
	public static void main(String[] args) throws Exception
	{
		Tree theTree = new Tree(); // Создание дерева
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter message. Press [ENTER] to go to the next line. Press [ENTER] TWICE to end the input.");
		String message = "";
		String currentLine = "";
		do { // Dвод сообщения
			if(message.length() > 0) message += "\n";
			currentLine = input.readLine();
			message += currentLine;
		} while (currentLine.length() > 0);
		message = message.substring(0, message.length() - 1);
		String copy = message;
		ArrayList<Node> letters = new ArrayList<>(); // Составление приоритетной очереди
		HashMap<Character, String> table = new HashMap<>();
		while(message.length() > 0) {
			char next = message.charAt(0);
			String modified = message.replace(String.valueOf(next), "");
			letters.add(new Node(message.length() - modified.length(), next));
			message = modified;
		}
		while(letters.size() > 1) { // Создание дерева Хаффмана
			Collections.sort(letters);
			Node combination = new Node(letters.get(0).iData + letters.get(1).iData, ' ');
			combination.leftChild = letters.get(0);
			combination.rightChild = letters.get(1);
			combination.isTrail = false;
			letters.remove(1);
			letters.set(0, combination);
		}
		theTree.root = letters.get(0);
		System.out.println("Huffman Tree: ");
		theTree.printTree(table);
		System.out.println("Code Table: ");
		for(int i = 0; i < table.size(); i++) {
			System.out.println("[" + table.keySet().toArray()[i] + "] : " + table.values().toArray()[i]);
		}
		System.out.println("Encoded Message: ");
		for (int i = 0; i < table.size(); i++)
			copy = copy.replace(table.keySet().toArray()[i].toString(), table.values().toArray()[i].toString());
		System.out.println(copy);
		System.out.println("Decoded Message: ");
		System.out.println(theTree.Decode(copy));
	}
}