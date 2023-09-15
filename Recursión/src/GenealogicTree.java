import java.util.ArrayList;
import java.util.Random;

public class GenealogicTree {

	static String[] names = { "Charles", "Claire", "Edwar", "Francis", "Peter", "Layla", "Eose", "Matthew", "Laura",
			"Chad", "Clark", "Lois", "Lana", "Lex", "Laura", "Chad", "Diego", "Pauline", "Albert", "Andrew","Gabriella" };

	static Random r = new Random();
	static final int MAX = 10;

	static class Person {
		private String name;
		private ArrayList<Person> sons;

		public Person(String name) {
			this.name = name;
			sons = new ArrayList<Person>();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public ArrayList<Person> getSons() {
			return sons;
		}

		public void setSons(ArrayList<Person> sons) {
			this.sons = sons;
		}

		void addSon(String sonName) {
			sons.add(new Person(sonName));
		}

		void printSons() {
			printSons(this);
		}

		void printSons(Person who) {
			System.out.println("List of sons of " + who.name);

			for (int i = 0; i < who.sons.size(); i++) {
				System.out.print(who.sons.get(i).getName() + " ");
			}

			System.out.println();
			System.out.println("--------------------------");

			for (int i = 0; i < who.sons.size(); i++) {
				if (!who.sons.get(i).getSons().isEmpty()) {
					printSons(who.sons.get(i));
				}
			}
		}
	}

	static int getRandomNum() {
		return r.nextInt(MAX);
	}

	static String getRandomName() {
		return names[r.nextInt(names.length)];
	}

	public static void main(String[] args) {
		Person oldMan = new Person(getRandomName());
		int numSons = getRandomNum();
		int numGrandSons = getRandomNum();

		for (int i = 0; i < numSons; i++) {
			oldMan.addSon(getRandomName());
			for (int j = 0; j < numGrandSons; j++) {
				oldMan.sons.get(i).addSon(getRandomName());
			}
		}
		oldMan.printSons();
	}
}
