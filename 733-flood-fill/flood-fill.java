class Solution {
    private void change(int[][] image, int sr, int sc, int color, int original) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length)
            return;
        if (image[sr][sc] != original)
            return;
        image[sr][sc] = color;
        change(image, sr - 1, sc, color, original);
        change(image, sr + 1, sc, color, original);
        change(image, sr, sc - 1, color, original);
        change(image, sr, sc + 1, color, original);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original == color) return image;
        change(image, sr, sc, color, original);
        return image;
    }
}