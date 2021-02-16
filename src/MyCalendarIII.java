public class MyCalendarIII {
    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarIII().new MyCalendarThree();
        System.out.println(myCalendarThree.book(10,20));
        System.out.println(myCalendarThree.book(50,60));
        System.out.println(myCalendarThree.book(10,40));
        System.out.println(myCalendarThree.book(5,15));
        System.out.println(myCalendarThree.book(5,10));
    }
    class MyCalendarThree {
        TreeNode tree;
        int max = 0;

        public MyCalendarThree() {
        }

        public int book(int start, int end) {
            tree = book(start, end, tree, 1);
            return max;
        }

        public TreeNode book(int start, int end, TreeNode root, int count) {
            if (root == null) {
                // Base condition to add node in BST
                root = new TreeNode(start, end, count);
                max = Math.max(max, root.count);
            } else if (start >= root.end) {
                // No overlap, add  node in right subtree
                root.right = book(start, end, root.right, count);
            } else if (end <= root.start) {
                // No overlap, add node in left subtree
                root.left = book(start, end, root.left, count);
            } else {
                // Overlap, break nodes into multiple nodes (1/2/3 nodes)
                int startMin = Math.min(start, root.start);
                int startMax = Math.max(start, root.start);
                int endMin = Math.min(end, root.end);
                int endMax = Math.max(end, root.end);
                if (startMin < startMax) {
                    // No need to add new node if both are equal, instead update the count of current node.
                    root.left = book(startMin, startMax, root.left, start < root.start ? count : root.count);
                }

                if (endMin < endMax) {
                    // No need to add new node if both are equal, instead update the count of current node.
                    root.right = book(endMin, endMax, root.right, end > root.end ? count : root.count);
                }

                root.start = startMax;
                root.end = endMin;
                root.count+=count;
                max = Math.max(max, root.count);
            }

            return root;
        }
    }
    private static class TreeNode {
        int count;
        int start;
        int end;
        TreeNode left;
        TreeNode right;

        TreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }
    }
}
