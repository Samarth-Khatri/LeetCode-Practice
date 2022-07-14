// { Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}// } Driver Code Ends


class Solution
{
    public static Node buildTree(int inorder[], int preorder[], int n) {
        return rBuildTree(preorder,0,n-1,inorder,0,n-1);
    }
    
    // psi -> Preorder starting index
    // pei -> Preorder ending index
    // isi -> Ineorder starting index
    // iei -> Ineorder ending index
    // colse -> Count of Left Sub Tree elements
    private static Node rBuildTree(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if(isi>iei)
            return null;
        int idx = isi;
        while(inorder[idx]!=preorder[psi])
            idx++;
        
        int colse = idx-isi;
        Node node = new Node(preorder[psi]);
        
        node.left = rBuildTree(preorder,psi+1,psi+colse,inorder,isi,idx-1); // left subtree call
        node.right = rBuildTree(preorder,psi+colse+1,pei,inorder,idx+1,iei); // right subtree call
            
        return node;
    }
}
