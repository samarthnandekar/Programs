package Tree;

public class _56_SortedArrayToBST {

	public Node sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length - 1);
    }

    private Node toBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high)/2;
        Node n =new Node(nums[mid]);
        n.left = toBST(nums, low, mid - 1);
        n.right = toBST(nums, mid + 1, high);
        return n;
    }
}
