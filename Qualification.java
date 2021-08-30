import java.util.Scanner;

public class Qualification {

	public static void main(String[] args) {

		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("Welcome to IQHebat Competition 2019");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");

		int totolPersonInQroup = 10;
		float avgScoreForNextLevel = 3.5f;
		int maxScore = 5;
		String[] personNameWithScore = new String[totolPersonInQroup];
		Scanner input = new java.util.Scanner(System.in);
		for (int i = 0; i < personNameWithScore.length; i++) {

			System.out.print(i + 1 + ".  Enter participant name and score(0-5):");
			personNameWithScore[i] = input.nextLine();
		}
		input.close();
		System.out.println("\n===========================================\n");

		int[] scores = new int[totolPersonInQroup];

		for (int i = 0; i < scores.length; i++) {

			scores[i] = Integer.valueOf(personNameWithScore[i].split(" ", 2)[1]);
		}

		boolean firstLevelQualified = totalAvgScores(totolPersonInQroup, avgScoreForNextLevel, scores);

		System.out.println("\n===========================================\n");
		System.out.println("---------------------------------------\n");
		if (firstLevelQualified) {

			maxScoredPariticipants(maxScore, scores, personNameWithScore);
		}

	}

	private static void maxScoredPariticipants(int maxScore, int[] scores, String[] personNameWithScore) {

		int numberOfPersonWhoScoredFive = 0;

		for (int i = 0; i < scores.length; i++) {

			if (scores[i] == maxScore) {

				++numberOfPersonWhoScoredFive;
			}
		}

		System.out.println("Number of participants who score 5 : " + numberOfPersonWhoScoredFive);

		System.out.println("\nParticipant who score 5:");

		for (int i = 0; i < personNameWithScore.length; i++) {

			int score = Integer.valueOf(personNameWithScore[i].split(" ", 2)[1]);

			if (score == maxScore) {

				System.out.println(personNameWithScore[i].split(" ", 2)[0]);
			}
		}
	}

	private static boolean totalAvgScores(int totolPersonInQroup, float avgScoreForNextLevel, int[] scores) {

		float totalScores = 0;
		boolean qualified = false;
		for (int i = 0; i < scores.length; i++) {

			totalScores += scores[i];
		}

		System.out.println("The total score for 10 participants is :" + totalScores);

		float averageFromScores = totalScores / totolPersonInQroup;

		System.out.println("The average score for this group is :" + averageFromScores);

		if (averageFromScores >= avgScoreForNextLevel) {

			System.out.println("\n**Congratulations! Your group is qualified**");
			qualified = true;
		} else {
			System.out.println("\n**Sorry! Your group is not qualified**");
		}
		return qualified;
	}
}
