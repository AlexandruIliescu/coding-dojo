package leetcode.random;

public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            if (word1.length() <= word2.length() && i < word1.length()) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            } else if (word1.length() >= word2.length() && i < word2.length()) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }

            if (word1.length() < word2.length() && i == word1.length() - 1) {
                sb.append(word2.substring(i + 1));
            }

            if(word1.length() > word2.length() && i == word2.length() - 1) {
                sb.append(word1.substring(i + 1));
            }
        }
        return sb.toString();
    }
}
//https://leetcode.com/problems/merge-strings-alternately/submissions/976709965/?envType=study-plan-v2&envId=leetcode-75