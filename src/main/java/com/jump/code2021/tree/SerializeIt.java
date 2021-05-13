package com.jump.code2021.tree;

public class SerializeIt {

    public TreeNode deserialize(String data){
        String[] node = data.split(",");
        return realDeserialize(node);
    }

    private static int curIdx=0;

    private TreeNode realDeserialize( String[] nodes){
        TreeNode root = new TreeNode();
        String v = nodes[curIdx];
        if(v.equals("#")){
            return  null;
        }

        root.val = Integer.parseInt(v);
        curIdx+=1;
        root.left = realDeserialize(nodes);
        curIdx+=1;
        root.right = realDeserialize(nodes);

        return root;
    }


    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();

    }




    public static void main(String[] args){
        String d ="1,2,#,4,#,#,3,#,#";
        SerializeIt s = new SerializeIt();
        TreeNode t = s.deserialize(d);
        System.out.println(t);
    }


    class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(){ }

    }

}
