package Custom;

public class BinaryTree {
    TreeNode root;
    String type;
    public BinaryTree(TreeNode root, String type) {
        this.root = root;
        this.type = type;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void insertNode(TreeNode node) {
        if (this.type == "min") {
            this.insertNodeMinHeap(node);
        }
    }

    private void insertNodeMinHeap(TreeNode node) {
        TreeNode curr = this.root;

        while (true) {
            if (node.getLeft().getValue() < curr.getValue()) {
                if (curr.getLeft() == null) {
                    node.setLeft(curr);
                    curr.setLeft(null);
                    this.root = node;
                }
                else if (curr.getLeft() != null) {
                    node.setLeft(curr);
                    curr.setLeft(null);
                    this.root = node;
                }
            }
            TreeNode left = curr.getLeft();
            TreeNode right = curr.getRight();
        }

    }
}
