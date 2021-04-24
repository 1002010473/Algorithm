package Algorithm.data_struct.tree;
/**
 * @description: 思路很简单，就是递归将左右节点赋值给 mid 节点就可以了，每次递归的左右大小保持平衡，从而实现高度平衡
 * @author: 文琛
 * @time: 2020/7/20 9:54
 */
public class lc109_有序链表转二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode node = head;
        //统计长度 -- 为了按照长度实现数组
        int length = 0;
        while(node != null){
            node = node.next;
            length++;
        }
        TreeNode[] arr = new TreeNode[length];
        //将链表 复制 转化为TreeNode的数组
        for(int i = 0; i < length; i++){
            arr[i] = new TreeNode(head.val);
            head = head.next;
        }
        int left = 0, right = length - 1;
        return method(arr, left, right);
    }
    public TreeNode method(TreeNode[] arr, int left, int right){
        if(left > right) return null;
        int mid = left + ((right - left) >> 1);
        TreeNode root = arr[mid];
        root.left = method(arr, left, mid - 1);
        root.right = method(arr, mid + 1, right);
        return root;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
