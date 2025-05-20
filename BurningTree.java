import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BurningTree {
   public static int minTime(Node root, int target) {
         if(root.left==null && root.right==null) return 0;
         HashMap<Integer,ArrayList<Node>> adj=new HashMap<>();
         createAdj(root,adj);
         HashSet<Integer> set=new HashSet<>();
         Queue<Integer> queue=new LinkedList<>();
         int sec=-1;
         queue.offer(target);
         while(!queue.isEmpty()){
             int levelSize=queue.size();
             for(int i=0;i<levelSize;i++){
                 int curr=queue.poll();
                 set.add(curr);
                 for(Node neighbors: adj.get(curr)){
                    if(!set.contains(neighbors.data)) queue.offer(neighbors.data);
                 }
             } sec++;
         }
         
        return sec;
    }
    private static void createAdj(Node root,HashMap<Integer,ArrayList<Node>> adj){
        if(root==null) return ;
        ArrayList<Node> list;
        if(root.left!=null) {
          list=adj.getOrDefault(root.data,new ArrayList<>());
          list.add(root.left);
          adj.put(root.data,list);
          list=adj.getOrDefault(root.left.data,new ArrayList<>());
          list.add(root);
          adj.put(root.left.data,list);
        }
        if(root.right!=null) {
          list=adj.getOrDefault(root.data,new ArrayList<>());
          list.add(root.right);
          adj.put(root.data,list);
          list=adj.getOrDefault(root.right.data,new ArrayList<>());
          list.add(root);
          adj.put(root.right.data,list);
        }
        createAdj(root.left,adj);
        createAdj(root.right,adj);
    }
}
