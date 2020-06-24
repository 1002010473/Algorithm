package ToOffer.sixty;

import DataStructure.BinaryTreeNode;

import java.util.Stack;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/2/14 13:32
 */
public class FiftyFour {

    public int kthLargest(BinaryTreeNode root, int k) {
        //if(root==null||k<1) return
        Stack<BinaryTreeNode> s = new Stack<>();
        traversal(root,s);//从左到右的中序遍历，需要全部遍历一次
        for(int i=0;i<k-1;i++){
            s.pop();
        }
        BinaryTreeNode node = s.pop();
        return node.value;
    }
    public void traversal(BinaryTreeNode node,Stack<BinaryTreeNode> s ){
        if(node.leftNode!=null){
            traversal(node.leftNode,s);
        }
        s.push(node);
        if(node.rightNode!=null){
            traversal(node.rightNode,s);
        }
    }


}
