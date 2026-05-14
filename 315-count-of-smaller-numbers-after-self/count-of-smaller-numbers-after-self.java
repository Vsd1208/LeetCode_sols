// class Solution {

//     class Node {
//         int val;
//         int count;
//         Node left, right;

//         Node(int val) {
//             this.val = val;
//             this.count = 0;
//         }
//     }

//     private int insert(Node root, int num) {
//         int smaller = 0;

//         if (num <= root.val) {
//             root.count++;
//             if (root.left == null) {
//                 root.left = new Node(num);
//             } else {
//                 smaller += insert(root.left, num);
//             }
//         } else {
//             smaller += root.count + 1;
//             if (root.right == null) {
//                 root.right = new Node(num);
//             } else {
//                 smaller += insert(root.right, num);
//             }
//         }

//         return smaller;
//     }

//     public List<Integer> countSmaller(int[] nums) {
//         int n = nums.length;
//         Integer[] result = new Integer[n];

//         Node root = new Node(nums[n - 1]);
//         result[n - 1] = 0;

//         for (int i = n - 2; i >= 0; i--) {
//             result[i] = insert(root, nums[i]);
//         }

//         return Arrays.asList(result);
//     }
// }
class Solution {
    private int[] count;
    private int[] indexes;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        indexes = new int[n];
        for (int i = 0; i < n; i++) indexes[i] = i;
        mergeSort(nums, 0, n - 1);
        List<Integer> res = new ArrayList<>();
        for (int c : count) res.add(c);
        return res;
    }
    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int rightCount = 0;
        while (i <= mid && j <= right) {
            if (nums[indexes[j]] < nums[indexes[i]]) {
                rightCount++;
                temp[k++] = indexes[j++];
            } else {
                count[indexes[i]] += rightCount;
                temp[k++] = indexes[i++];
            }
        }
        while (i <= mid) {
            count[indexes[i]] += rightCount;
            temp[k++] = indexes[i++];
        }
        while (j <= right) {
            temp[k++] = indexes[j++];
        }
        for (int p = 0; p < temp.length; p++) {
            indexes[left + p] = temp[p];
        }
    }
}