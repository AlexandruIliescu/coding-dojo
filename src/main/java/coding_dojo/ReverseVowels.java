package coding_dojo;

public class ReverseVowels {

    //https://leetcode.com/problems/reverse-vowels-of-a-string/
    //use of 2 pointers, left and right pointers

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            boolean leftIsVowel = isVowel(arr[left]);
            boolean rightIsVowel = isVowel(arr[right]);
            if(leftIsVowel && rightIsVowel) {
                swap(arr, left, right);
                ++left;
                --right;
            }
            if(!leftIsVowel) {
                ++left;
            }
            if(!rightIsVowel) {
                --right;
            }
        }
        return new String(arr);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean isVowel(char letter) {
        char c = Character.toLowerCase(letter);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}