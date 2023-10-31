class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if (n <= 1) {
            return n; // No need to compress for input with length <= 1
        }

        int index = 0; // Index to update the result array
        int count = 1; // Count of consecutive characters, initialized to 1
        char currentChar = chars[0]; // Initialize the current character to the first character

        for (int i = 1; i < n; i++) {
            if (chars[i] == currentChar) {
                count++; // Increment the count for consecutive characters
            } else {
                chars[index++] = currentChar; // Update the result array with the current character

                if (count > 1) {
                    // If count is greater than 1, we need to add the count as characters
                    char[] countChars = String.valueOf(count).toCharArray();
                    for (char c : countChars) {
                        chars[index++] = c;
                    }
                }

                currentChar = chars[i]; // Update the current character
                count = 1; // Reset the count for the new character
            }
        }

        // Handle the last group of characters
        chars[index++] = currentChar;
        if (count > 1) {
            char[] countChars = String.valueOf(count).toCharArray();
            for (char c : countChars) {
                chars[index++] = c;
            }
        }

        return index; // Return the length of the compressed array
    }
}
