import linkedList.Node;

public class MaximumHeightOfBt {
    public static void main(String[] args) {
        Node<Integer> root = new Node<Integer>(3);
        root.left = new Node<Integer>(1);
        root.right = new Node<Integer>(4);
        root.left.left = new Node<Integer>(0);
        root.left.right = new Node<Integer>(5);
        System.out.println(height(root));
    }
    public static int height(Node<Integer> root) {
        int height = helper(root);
        if(height >=1 ) {
            return height-1;
        } else {
            return 0;
        }
      }

    public static int helper(Node<Integer> root){
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        return 1 + Math.max(left, right);
    }
}
