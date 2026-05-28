import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int index = -1;
        int length = Integer.MAX_VALUE;
    }

    TrieNode root = new TrieNode();

    private void insert(String word, int idx) {
        TrieNode node = root;
        int len = word.length();

        // update root also (important for empty suffix case)
        if (len < node.length || (len == node.length && idx < node.index)) {
            node.length = len;
            node.index = idx;
        }

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            if (node.children[c] == null)
                node.children[c] = new TrieNode();

            node = node.children[c];

            // update best candidate
            if (len < node.length || (len == node.length && idx < node.index)) {
                node.length = len;
                node.index = idx;
            }
        }
    }

    private int query(String word) {
        TrieNode node = root;
        int res = node.index; // default: empty suffix case

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            if (node.children[c] == null)
                break;

            node = node.children[c];
            res = node.index;
        }

        return res;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int n = wordsQuery.length;

        // build trie
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = query(wordsQuery[i]);
        }

        return ans;
    }
}