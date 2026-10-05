class PrefixTree {    
    private static final int ROOT = 1;
    private static final int INITIAL_CAPACITY = 64;
 
    private int[] base;
    private int[] check;
    private boolean[] isEnd;
 
    private final Map<Character, Integer> alphabet = new HashMap<>();
 
    public PrefixTree() {
        base = new int[INITIAL_CAPACITY];
        check = new int[INITIAL_CAPACITY];
        isEnd = new boolean[INITIAL_CAPACITY];
        base[ROOT] = 0;      // 0 means "no children yet"
        check[ROOT] = -1;    // mark root as occupied
    }
 
    public void insert(String word) {
        int state = ROOT;
        for (int i = 0; i < word.length(); i++) {
            int code = codeOf(word.charAt(i), true);
            state = getOrCreateChild(state, code);
        }
        isEnd[state] = true;
    }
 
    public boolean search(String word) {
        int state = walk(word);
        return state != -1 && isEnd[state];
    }
 
    public boolean startsWith(String prefix) {
        return walk(prefix) != -1;
    }
 
    // ------------------------------------------------------------------
    // Lookup
    // ------------------------------------------------------------------
 
    /** Follows the string from the root; returns the final state or -1. */
    private int walk(String s) {
        int state = ROOT;
        for (int i = 0; i < s.length(); i++) {
            int code = codeOf(s.charAt(i), false);
            if (code == 0 || base[state] == 0) {
                return -1;
            }
            int next = base[state] + code;
            if (next >= check.length || check[next] != state) {
                return -1;
            }
            state = next;
        }
        return state;
    }
 
    private int codeOf(char c, boolean create) {
        Integer code = alphabet.get(c);
        if (code != null) {
            return code;
        }
        if (!create) {
            return 0;
        }
        int newCode = alphabet.size() + 1;
        alphabet.put(c, newCode);
        return newCode;
    }
 
    // ------------------------------------------------------------------
    // Insertion
    // ------------------------------------------------------------------
 
    private int getOrCreateChild(int state, int code) {
        // Case 1: state has no children yet, pick a base where this code fits.
        if (base[state] == 0) {
            int b = findBase(new int[]{code});
            base[state] = b;
            return claim(b + code, state);
        }
 
        int next = base[state] + code;
        ensureCapacity(next);
 
        // Case 2: child already exists.
        if (check[next] == state) {
            return next;
        }
 
        // Case 3: slot is free.
        if (check[next] == 0) {
            return claim(next, state);
        }
 
        // Case 4: slot is taken by another parent's child -> relocate our children.
        relocate(state, code);
        return base[state] + code;
    }
 
    private int claim(int index, int parent) {
        ensureCapacity(index);
        check[index] = parent;
        return index;
    }
 
    /**
     * Moves all existing children of `state` to a new base where they and
     * the additional child `extraCode` all fit, then creates the new child.
     */
    private void relocate(int state, int extraCode) {
        int oldBase = base[state];
        int[] codes = childCodes(state, extraCode);
        int newBase = findBase(codes);
 
        for (int code : codes) {
            if (code == extraCode) {
                continue; // new node, nothing to move
            }
            int oldIdx = oldBase + code;
            int newIdx = newBase + code;
 
            claim(newIdx, state);
            base[newIdx] = base[oldIdx];
            isEnd[newIdx] = isEnd[oldIdx];
 
            // Re-parent grandchildren to the moved node.
            if (base[oldIdx] != 0) {
                int maxCode = alphabet.size();
                for (int k = 1; k <= maxCode; k++) {
                    int g = base[oldIdx] + k;
                    if (g < check.length && check[g] == oldIdx) {
                        check[g] = newIdx;
                    }
                }
            }
 
            // Free the old slot.
            check[oldIdx] = 0;
            base[oldIdx] = 0;
            isEnd[oldIdx] = false;
        }
 
        base[state] = newBase;
        claim(newBase + extraCode, state);
    }
 
    /** Codes of all current children of `state`, plus `extraCode`. */
    private int[] childCodes(int state, int extraCode) {
        int maxCode = alphabet.size();
        int[] tmp = new int[maxCode + 1];
        int n = 0;
        int b = base[state];
        for (int k = 1; k <= maxCode; k++) {
            int idx = b + k;
            if (idx < check.length && check[idx] == state) {
                tmp[n++] = k;
            }
        }
        tmp[n++] = extraCode;
        return Arrays.copyOf(tmp, n);
    }
 
    /** Smallest base >= 1 such that base + code is free for every code. */
    private int findBase(int[] codes) {
        int b = 1;
        while (true) {
            boolean ok = true;
            for (int code : codes) {
                int idx = b + code;
                ensureCapacity(idx);
                if (check[idx] != 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return b;
            }
            b++;
        }
    }
 
    private void ensureCapacity(int index) {
        if (index < check.length) {
            return;
        }
        int newLen = Math.max(index + 1, check.length * 2);
        base = Arrays.copyOf(base, newLen);
        check = Arrays.copyOf(check, newLen);
        isEnd = Arrays.copyOf(isEnd, newLen);
    }
}