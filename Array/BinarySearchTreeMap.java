import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeMap {

    private TreeNode root;
    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        TreeNode newNode = new TreeNode(key, val);
        if (root == null) {
            root = newNode;
            return;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (key < curr.key) {
                if (curr.left == null) {
                    curr.left = newNode;
                    return;
                }
                curr = curr.left;
            }
            else if (key > curr.key) {
                if (curr.right == null) {
                    curr.right = newNode;
                    return;
                }
                curr = curr.right;
            }
            else if (key == curr.key) {
                curr.val = val;
                return;
            }
        }
    }

    public int get(int key) {
        TreeNode curr = root;
        while (curr != null) {
            if (key < curr.key) {
                curr = curr.left;
            } else if (key > curr.key) {
                curr = curr.right;
            } else {
                return curr.val;
            }
        }
        return -1;
    }

    public int getMin() {
        TreeNode current = findMin(root);
        return (current != null) ? current.val : -1;
    }

    public int getMax() {
        TreeNode curr = root;
        while (curr != null && curr.right != null) {
            curr = curr.right;
        }
        return (curr != null) ? curr.val : -1;
    }

    public void remove(int key) {
        root = removeHelper(key, root);
    }

    private TreeNode removeHelper(int key, TreeNode rootNode) {
        if (root == null) return null;

        if (key < rootNode.key) {
            rootNode.left = removeHelper(key, rootNode.left);
        } else if (key > rootNode.key) {
            rootNode.right = removeHelper(key, rootNode.right);
        } else {
            if (rootNode.left == null) {
                return rootNode.right; 
            }
            else if (rootNode.right == null) {
                return rootNode.left;
            }
            else {
                TreeNode minSuccessor = findMin(rootNode.right);
                rootNode.val = minSuccessor.val;
                rootNode.key = minSuccessor.key;
                rootNode.right = removeHelper(minSuccessor.key, rootNode.right);
            }
        }

        return rootNode;
    }

    private TreeNode findMin(TreeNode rootNode) {
        while (rootNode != null && rootNode.left != null) {
            rootNode = rootNode.left;
        }
        return rootNode;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> result = new ArrayList<Integer>();
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            inOrderTraversal(root.left, result);
            result.add(root.key);
            inOrderTraversal(root.right, result);
        }
    }

    public class TreeNode {
        int key;
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int key, int val) {
            this.key = key;
            this.val = val; 
            left = null;
            right = null; 
        }
}
}

