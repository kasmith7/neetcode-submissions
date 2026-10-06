class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<List<String>>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String sortStr = new String(ca);
            if (!map.containsKey(sortStr)) {
                map.put(sortStr, new ArrayList<String>());
            }
            List<String> group = map.get(sortStr);
            group.add(str);
        }
        for (String s : map.keySet()) {
            groups.add(map.get(s));
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
