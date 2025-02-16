class Tree {
    // Function to serialize a tree and return a list containing nodes of tree.
    int i=0;
    public ArrayList<Integer> serialize(Node root) {
          ArrayList<Integer> list=new ArrayList<>();
          helperSerialize(list,root);
          return list;
    }
    void helperSerialize(ArrayList<Integer> list,Node root)
    {
        if(root==null){
            list.add(-1);
            return ;
        }
        list.add(root.data);
        helperSerialize(list,root.left);
        helperSerialize(list,root.right);
    }
    

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        if(arr.get(i)==-1){
            i++;
            return null;
        }  
        Node node=new Node(arr.get(i++));
        node.left=deSerialize(arr);
        node.right=deSerialize(arr);
        return node;
    }
};