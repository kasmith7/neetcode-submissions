class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<List<String>>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = new String(freqTable(str));
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            List<String> group = map.get(key);
            group.add(str);
        }
        for (String key : map.keySet()) {
            groups.add(map.get(key));
        }

        return groups;
    }

    private byte[] freqTable(String s) {
        byte[] buckets = new byte[32];
        for (char c : s.toCharArray()) {
            buckets[c - 'a']++;
        }
        return buckets;
    }


}
