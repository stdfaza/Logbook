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
public Event search(String name) {
    return searchRec(root, name);
}

private Event searchRec(TreeNode root, String name) {
    if (root == null) {
        return null;
    }
    if (root.event.getName().equalsIgnoreCase(name)) {
        return root.event;
    }
    Event leftSearch = searchRec(root.left, name);
    if (leftSearch != null) {
        return leftSearch;
    }
    return searchRec(root.right, name);
}
