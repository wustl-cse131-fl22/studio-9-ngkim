package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Map<String, Integer> heightMap = new HashMap<>();

		heightMap.put("Lucas", 66);
		heightMap.put("Andrew", 72);
		heightMap.put("Justin", 72);

		System.out.println("Type in the name you want to know the height of. ");
		String typedIn = in.next();



		for (String name: heightMap.keySet()) {
			while(!typedIn.equals("quit")) {
				if(heightMap.get(typedIn) == null) {
					System.out.println("There is no such name in the map. ");	
				} else {
					System.out.println(typedIn + ": " + heightMap.get(name));
				}
				System.out.println("Type in the name you want to know the height of. ");
				typedIn = in.next();
			}
		}
	}
}
