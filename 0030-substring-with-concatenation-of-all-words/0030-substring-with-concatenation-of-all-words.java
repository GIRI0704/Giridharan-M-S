class Solution {
    public List<Integer> findSubstring(String str, String[] words) {
        List<Integer> result = new ArrayList<>();
         int wordLength = words[0].length();
         int totalLength = wordLength * words.length;
         Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= str.length() - totalLength; i++) {
            String sub = str.substring(i, i + totalLength);
            Map<String, Integer> subCount = new HashMap<>();
            boolean isConcatenated = true;

            for (int j = 0; j < totalLength; j += wordLength) {
                String word = sub.substring(j, j + wordLength);
                if (!wordCount.containsKey(word)) {
                    isConcatenated = false;
                    break;
                }
                subCount.put(word, subCount.getOrDefault(word, 0) + 1);
                if (subCount.get(word) > wordCount.get(word)) {
                    isConcatenated = false;
                    break;
                }
            }

            if (isConcatenated && wordCount.equals(subCount)) {
                result.add(i);
            }
        }

        return result;
    }
}