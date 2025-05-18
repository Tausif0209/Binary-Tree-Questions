import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
public class LevelOrderSpiralForm {
  public ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root.left==null &&root.right==null)  {
            ans.add(root.data);
            return ans;
        
    }
    Queue<Node> queue=new LinkedList<>();
    queue.offer(root);
    int level=0;
    while(!queue.isEmpty()){
     ArrayList<Integer> list=new ArrayList<>();
     int levelSize=queue.size();
     for(int i=0;i<levelSize;i++){
          Node currNode=queue.poll();
          if(currNode.left!=null) queue.offer(currNode.left);
          if(currNode.right!=null) queue.offer(currNode.right);
          if(level%2==0) list.add(0,currNode.data);
          else list.add(currNode.data);
          
     }
     level++;
     ans.addAll(list);
    } return ans;
}}
