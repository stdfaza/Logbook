class EventTree {
    private TreeNode root;

    public void insert(Event event) {
        root = insertRec(root, event);
    }

    private TreeNode insertRec(TreeNode root, Event event) {
        if (root == null) {
            root = new TreeNode(event);
            return root;
        }
        if (event.getDate().compareTo(root.event.getDate()) < 0) {
            root.left = insertRec(root.left, event);
        } else {
            root.right = insertRec(root.right, event);
        }
        return root;
    }

    public void inorderTraversal() {
        inorderRec(root);
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.event);
            inorderRec(root.right);
        }
    }
}