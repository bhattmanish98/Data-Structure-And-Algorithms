class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        swapChild(root);
        return root;
    }

    private void swapChild(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        if (root.left != null && root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            swapChild(root.left);
            swapChild(root.right);
        } else if (root.left == null) {
            root.left = root.right;
            root.right = null;
            swapChild(root.left);
        } else {
            root.right = root.left;
            root.left = null;
            swapChild(root.right);
        }
    }
}