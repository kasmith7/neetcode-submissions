class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = new String(freqTable(str));
            map.computeIfAbsent(key, k -> new ArrayList()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private byte[] freqTable(String s) {
        byte[] buckets = new byte[32];
        for (char c : s.toCharArray()) {
            buckets[c - 'a']++;
        }
        return buckets;
    }


}
