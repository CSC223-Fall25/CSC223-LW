package csc223.lw;

public class Tree {

    TreeNode root;
    
    public String levelOrder(){
        String result = "";
        TreeQueue queue = new TreeQueue();
        queue.enqueue(root);
        while (queue.isEmpty() == false){
            TreeNode curr = queue.dequeue();
            result += curr.data;
            if (curr.left != null){
                queue.enqueue(curr.left);
            }
            if (curr.right != null){
                queue.enqueue(curr.right);
            }
        }
        return result;
    }

    public String preorder(){
        if (root == null){
            return "";
        }
        String result = "";
        TreeNode curr = root;
        result += curr.data;
        result += preorder(curr.left);
        result += preorder(curr.right);
        return result;
    }

    private String preorder(TreeNode curr){
        if (curr == null){
            return "";
        }
        String result = "";
        result += curr.data;
        result += preorder(curr.left);
        result += preorder(curr.right);
        return result;
    }

    public String inorder(){
        if (root == null){
            return "";
        }
        String result = "";
        TreeNode curr = root;
        result += inorder(curr.left);
        result += curr.data;
        result += inorder(curr.right);
        return result;
    }

    private String inorder(TreeNode curr){
        if (curr == null){
            return "";
        }
        String result = "";
        result += inorder(curr.left);
        result += curr.data;
        result += inorder(curr.right);
        return result;
    }

    public String postorder(){
        if (root == null){
            return "";
        }
        String result = "";
        TreeNode curr = root;
        result += postorder(curr.left);
        result += postorder(curr.right);
        result += curr.data;
        return result;
    }

    private String postorder(TreeNode curr){
        if (curr == null){
            return "";
        }
        String result = "";
        result += postorder(curr.left);
        result += postorder(curr.right);
        result += curr.data;
        return result;
    }

    public void insert(char item){
        if (root == null){
            root = new TreeNode(item);
        }
        else {
            TreeQueue queue = new TreeQueue();
            queue.enqueue(root);
            while (queue.isEmpty() == false){
                TreeNode curr = queue.dequeue();
                if (curr.left == null){
                    curr.left = new TreeNode(item);
                    return;
                }
                else{
                    queue.enqueue(curr.left);
                }
                if (curr.right == null){
                    curr.right = new TreeNode(item);
                    return;
                }
                else{
                    queue.enqueue(curr.right);
                }
            }
        }
    }

    public boolean search(char item){
        if (root == null){
            return false;
        }
        TreeNode curr = root;
        if (curr.data == item){
            return true;
        }
        if (search(item, curr.left) == true || search(item, curr.right) == true){
            return true;
        }
        return false;
    }

    private boolean search(char item, TreeNode curr){
        if (curr == null){
            return false;
        }
        if (curr.data == item){
            return true;
        }
        if (search(item, curr.left) == true || search(item, curr.right) == true){
            return true;
        }
        return false;
    }

    public int size(){
        if (root == null){
            return 0;
        }
        int result = 0;
        TreeNode curr = root;
        result += size(curr.left);
        result += size(curr.right);
        return result + 1;
    }

    private int size(TreeNode curr){
        if (curr == null){
            return 0;
        }
        int result = 0;
        result += size(curr.left);
        result += size(curr.right);
        return result + 1;
    }

    public boolean isEmpty(){
        if (root == null){
            return true;
        }
        return false;
    }

    public int height(){
        int i = 0;
        TreeNode curr = root;
        while (curr != null){
            i++;
            curr = curr.left;
        }
        return i;
    }

    public static void main(String[] args){
        Tree t = new Tree();
        t.insert('A');
        t.insert('B');
        t.insert('C');
        t.insert('D');
        t.insert('E');
        System.out.println(t.height());
    }

}
