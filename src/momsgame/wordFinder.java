package momsgame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class wordFinder {
	public static void main(String args[]) throws IOException {
		ArrayList<String> words = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"));

		try {
			String line = br.readLine();

			while (line != null) {
				words.add(line);
				line = br.readLine();
			}
		} finally {
			br.close();
		}
		
		for(int i = 0; i < words.size(); i++) {
			words.set(i, words.get(i).toLowerCase());
		}

		
		
		/////////////
		// Inputs //
		////////////

		ArrayList<Character> letters = new ArrayList<Character>() {
			{
				add('e');
				add('a');
				add('d');
				add('r');
				add('o');
				add('f');
				//add('n');
			}
		};

		int wordLength = 4;



		//find words

		//remove all words that don't work
		for(int i = 0; i < words.size(); i++) {

			//remove words that are too long
			if(words.get(i).length() != wordLength) {
				words.set(i, "");
				continue;
			}

			//remove words that contain letters that aren't in the list
			for(int j = 0; j < words.get(i).length(); j++) {
				if(!letters.contains(words.get(i).charAt(j))) {
					words.set(i, "");
					continue;
				}
			}

			//remove words that repeat letters
			int count = 0;
			for (int j = 0; j < words.get(i).length() - 1; j++) {
				for (int k = j + 1; k < words.get(i).length(); k++) {

					if(words.get(i).charAt(j) == words.get(i).charAt(k)){
						count++;
					}
				}    
			}
			if(count != 0) {
				words.set(i, "");
				continue;
			}
		}

		words.removeAll(Collections.singleton(""));

		for(String s : words) {
			System.out.println(s);
		}



	}

}

