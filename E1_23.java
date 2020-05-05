package Package3;
//Introduced in Chapter 1
public class E1_23 {
	/** For reading from the console. */
	public static final java.util.Scanner INPUT = new java.util.Scanner(
			System.in);

	/** Create and play the game. */
	public static void main(String[] args) {
		System.out.println("Welcome to Beetle.");
		System.out.print("Please Input Number of Players:");
		BeetleGame game = new BeetleGame(INPUT.nextInt());
		game.play();
	}
}

/** The game of Beetle for two players. */
class BeetleGame {

	/** For reading from the console. */
	public static final java.util.Scanner INPUT = new java.util.Scanner(
			System.in);

	/** Player Beetle. */
	private Beetle[] bugs;

	/** Number of Player. */
	private int number;

	/** A die. */
	private Die die;

	/** Create the Die and Beetles. */
	public BeetleGame(int number) {
		bugs = new Beetle[number];
		this.number = number;
		for (int i = 0; i < number; i++)
			bugs[i] = new Beetle();
		die = new Die();
	}

	/** Play until someone wins. */
	public void play() {
		int player = 1;
		Beetle bug = bugs[player - 1];
		while (!(bug.isComplete())) {
			if (!(takeTurn(player, bug))) {
				player = player % number + 1;
				bug = bugs[player - 1];
			}
		}
		System.out.println("\nPlayer " + player + " wins!");
		System.out.println(bug);
	}

	/**
	 * Take a turn for the current player. Return true if the player earned a
	 * bonus turn.
	 */
	public boolean takeTurn(int player, Beetle bug) {
		System.out.println("\nPlayer " + player + ", your beetle:");
		System.out.println(bug);
		System.out.print("Hit return to roll: ");
		INPUT.nextLine();
		die.roll();
		System.out.print("You rolled a " + die.getTopFace());
		switch (die.getTopFace()) {
		case 1:
			System.out.println(" (body)");
			return bug.addBody();
		case 2:
			System.out.println(" (head)");
			return bug.addHead();
		case 3:
			System.out.println(" (leg)");
			return bug.addLeg();
		case 4:
			System.out.println(" (eye)");
			return bug.addEye();
		case 5:
			System.out.println(" (feeler)");
			return bug.addFeeler();
		default:
			System.out.println(" (tail)");
			return bug.addTail();
		}
	}
}
