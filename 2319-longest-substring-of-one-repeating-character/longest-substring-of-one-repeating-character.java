// class Solution {
//     private int long_seq(char[] ch) {
//         if (ch.length == 0)
//             return 0;
//         int max = 1, count = 1;
//         for (int i = 1; i < ch.length; i++) {
//             if (ch[i] == ch[i - 1])
//                 count++;
//             else {
//                 max = Math.max(max, count);
//                 count = 1;
//             }
//         }
//         return Math.max(max, count);
//     }
//     public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
//         char[] ch = s.toCharArray();
//         char[] q_ch = queryCharacters.toCharArray();
//         int k = q_ch.length;
//         int[] len = new int[k];
//         for (int i = 0; i < k; i++) {
//             ch[queryIndices[i]] = q_ch[i];
//             len[i] = long_seq(ch);
//         }
//         return len;
//     }
// }
class Solution {

    class Node {
        char leftChar;
        char rightChar;

        int prefix;
        int suffix;
        int max;
        int length;

        Node(char leftChar, char rightChar,int prefix, int suffix, int max, int length) {
            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.prefix = prefix;
            this.suffix = suffix;
            this.max = max;
            this.length = length;
        }
    }

    Node[] tree;

    private void build(char[] ch, int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(
                ch[start],
                ch[start],
                1,
                1,
                1,
                1
            );
            return;
        }
        int mid = (start + end) / 2;
        build(ch, node * 2, start, mid);
        build(ch, node * 2 + 1, mid + 1, end);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node merge(Node left, Node right) {
        char leftChar = left.leftChar;
        char rightChar = right.rightChar;
        int prefix = left.prefix;
        int suffix = right.suffix;
        int max = Math.max(left.max, right.max);
        if (left.rightChar == right.leftChar) {

            if (left.prefix == left.length) {
                prefix = left.length + right.prefix;
            }

            if (right.suffix == right.length) {
                suffix = right.length + left.suffix;
            }

            max = Math.max(max, left.suffix + right.prefix);
        }

        return new Node(leftChar,rightChar,prefix,suffix,max,left.length + right.length);
    }

    private void update(
        int node,
        int start,
        int end,
        int index,
        char value
    ) {

        if (start == end) {

            tree[node] = new Node(
                value,
                value,
                1,
                1,
                1,
                1
            );

            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, end, index, value);
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    public int[] longestRepeating(
        String s,
        String queryCharacters,
        int[] queryIndices
    ) {

        int n = s.length();

        char[] ch = s.toCharArray();

        tree = new Node[4 * n];

        // Build only ONCE
        build(ch, 1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];
            char value = queryCharacters.charAt(i);

            ch[index] = value;

            // Update only one position
            update(
                1,
                0,
                n - 1,
                index,
                value
            );

            // Root contains answer for entire string
            ans[i] = tree[1].max;
        }

        return ans;
    }
}