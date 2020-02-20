import java.util.Random;
import java.util.List;
import java.util.ArrayList;

class UniqueRandomNumberGenerator {
	private Integer[] numList;

	public Integer[] getNumList() {
		return numList;
	}

	public UniqueRandomNumberGenerator(int num) {
		numList = new Integer[num];
		Random rand = new Random();
		List<Integer> used = new ArrayList<Integer>();

		for (int i = 0; i < num - 1; i++) {
			do {
				numList[i] = rand.nextInt(num - 1) + 1;
			} while (used.contains(numList[i]));

			used.add(numList[i]);
		}

		numList[num - 1] = 34;
	}
}
