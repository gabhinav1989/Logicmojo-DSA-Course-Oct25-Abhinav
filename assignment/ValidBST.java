public class ValidBST {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(3);
        node.right = new Node(7);
        node.left.left = new Node(22);
        node.left.right = new Node(4);
        node.right.left = new Node(6);
        node.right.right = new Node(8);


        Node node2 = new Node(5);
        node2.left = new Node(3);
        node2.right = new Node(7);
        node2.right.left = new Node(17);
        node2.right.right = new Node(19);

        System.out.println(isValidBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isValidBST(node2, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static boolean isValidBST(ValidBST.Node node, int low, int high) {
        if (node == null) {
            return true;
        }
        int nodeValue = node.val;
        if (nodeValue < low || nodeValue > high) {
            return false;
        }

        boolean left = isValidBST(node.left, low, nodeValue);
        boolean right = isValidBST(node.right, nodeValue, high);

        return left && right;
    }
}
