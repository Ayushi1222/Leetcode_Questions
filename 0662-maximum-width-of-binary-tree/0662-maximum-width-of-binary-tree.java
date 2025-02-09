/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        Queue<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        int maxWidth = 0;
        
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int minStart = q.peek().getValue(); // Minimum index for normalization
            
            int first = 0, last = 0;
            
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> current = q.poll();
                TreeNode node = current.getKey();
                int index = current.getValue();
                
                int normalizedIndex = index - minStart; // Normalize the index

                if (i == 0) first = normalizedIndex;
                if (i == size - 1) last = normalizedIndex;

                if (node.left != null) {
                    q.offer(new Pair<>(node.left, normalizedIndex * 2 + 1));
                }
                if (node.right != null) {
                    q.offer(new Pair<>(node.right, normalizedIndex * 2 + 2));
                }
            }
            
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        
        return maxWidth;
    }
}

class Pair<K,V>{
    private K node;
    private V index;

    public Pair(K node, V index)
    {
        this.node=node;
        this.index=index;
    }

    public K getKey()
    {
        return node;
    }

    public V getValue()
    {
        return index;
    }

}