package demo1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Class01 extends Object {

	public static void main(String[] args) {
		// 1. find Repeated Characters of String
		findDuplicateChar("java");
		// 2. How to check if two Strings are anagrams of each other?
		
		System.out.println("reverse String: "+reverseStr("dharmanand"));

	}

	static void findDuplicateChar(String word) {
		char[] characters = word.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : characters) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		for (char c : map.keySet()) {
			if (map.get(c) > 1)
				System.out.println(c + " : " + map.get(c));
		}
	}

	static String reverseStr(String str) {
		char[] charArr = str.toCharArray();
		int size = charArr.length, j = 0;
		String reverseSt = "";
		for (int i = size - 1; i >= 0; i--) {

			reverseSt = reverseSt+charArr[i];

		}

		return reverseSt;

	}
}
