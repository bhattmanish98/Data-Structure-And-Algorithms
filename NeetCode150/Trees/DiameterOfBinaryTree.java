import java.util.LinkedList;
import java.util.Queue;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            max = Math.max(max, 2 + Math.max(maxDepth(node.left), maxDepth(node.right)));
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
