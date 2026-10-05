class PrefixTree {
    boolean endNode;
    PrefixTree[] children;

    public PrefixTree() {
        this.endNode = false;
        this.children = new PrefixTree[26];
    }

    public void insert(String word) {
        if (word.length() == 0) {
            endNode = true;
            return;
        }

        char c = word.charAt(0);
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new PrefixTree();
        }
        children[c - 'a'].insert(word.substring(1, word.length()));
    }

    public boolean search(String word) {
        if (word.length() == 0) {
            return endNode;
        }

        char c = word.charAt(0);
        if (children[c - 'a'] == null) {
            return false;
        }
        return children[c - 'a'].search(word.substring(1,word.length()));
    }

    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) {
            return true;
        }

        char c = prefix.charAt(0);
        if (children[c - 'a'] == null) {
            return false;
        }
        return children[c - 'a'].startsWith(prefix.substring(1,prefix.length()));
    }
}
