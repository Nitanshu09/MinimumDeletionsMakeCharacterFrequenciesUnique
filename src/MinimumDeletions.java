
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

public class MinimumDeletions {

	public static int minDeletionsToMakeGoodString(String s) {
		Map<Character, Integer> frequencyMap = new HashMap<>();
		for (char c : s.toCharArray()) {
			frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
		}
		System.out.println(frequencyMap);
		HashSet<Integer> uniqueFrequencies = new HashSet<>();
		int deletions = 0;
		for (int freq : frequencyMap.values()) {
			while (uniqueFrequencies.contains(freq)) {
				freq--;
				deletions++;
			}
			if (freq != 0) {
				uniqueFrequencies.add(freq);
			}
		}
		System.out.println(uniqueFrequencies);
		return deletions;
	}

	public static void main(String[] args) {
		String s = "bbcebab";
		int deletions = minDeletionsToMakeGoodString(s);
		System.out.println("Minimum deletions required: " + deletions); // Output: 0
	}
}
