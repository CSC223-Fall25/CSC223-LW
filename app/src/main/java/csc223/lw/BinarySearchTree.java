package csc223.lw;

public class BinarySearchTree {
    
    NumericTreeNode root;

    public void insert(int val){
        if (root == null){
            root = new NumericTreeNode(val);
            return;
        }
        NumericTreeNode curr = root;
        while (curr != null){
            if (val < curr.data){
                if (curr.left == null){
                    curr.left = new NumericTreeNode(val);
                }
                else{
                    curr = curr.left;
                }
            }
            else if (val > curr.data){
                if (curr.right == null){
                    curr.right = new NumericTreeNode(val);
                }
                else{
                    curr = curr.right;
                }
            }
            else{
                return;
            }
        }
    }

    public void delete(int val){
        if (root == null){
            return;
        }
        if (root.data == val){
            root.data = findReplacement(root);
            if (root.data == Integer.MAX_VALUE){
                root = null;
            }
        }
        NumericTreeNode curr = root;
        while (curr != null){
            if (curr.left != null && curr.left.data == val){
                curr.left.data = findReplacement(curr.left);
                if (curr.left.data == Integer.MAX_VALUE){
                    curr.left = null;
                }
            }
            if (curr.right != null && curr.right.data == val){
                curr.right.data = findReplacement(curr.right);
                if (curr.right.data == Integer.MAX_VALUE){
                    curr.right = null;
                }
            }
            else if (curr.data > val){
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
        if (curr == null){
            return;
        }
    }

    private int findReplacement(NumericTreeNode root){
        int replacementVal = 0;
        NumericTreeNode curr = root;
        if (curr.left != null){
            if (curr.left.right == null){
                replacementVal = curr.left.data;
                curr.left = null;
                return replacementVal;
            }
            curr = curr.left;
            while (curr.right != null && curr.right.right != null){
                curr = curr.right;
            }
            replacementVal = curr.right.data;
            curr.right.data = findReplacement(curr.right);
            if (curr.right.data == Integer.MAX_VALUE){
                curr.right = null;
            }
            return replacementVal;
        }
        else if (curr.right != null){
            if (curr.right.left == null){
                replacementVal = curr.right.data;
                curr.right = null;
                return replacementVal;
            }
            curr = curr.right;
            while (curr.left != null && curr.left.left != null){
                curr = curr.left;
            }
            replacementVal = curr.left.data;
            curr.left.data = findReplacement(curr.left);
            if (curr.left.data == Integer.MAX_VALUE){
                curr.left = null;
            }
            return replacementVal;
        }
        else{
            return Integer.MAX_VALUE;
        }
    }

    public void update(int oldVal, int newVal){
        NumericTreeNode curr = root;
        if (curr.data > oldVal){
            update(oldVal, newVal, curr.left);
            if (curr.left.data > curr.data){
                int temp = curr.data;
                curr.data = curr.left.data;
                curr.left.data = temp;
                bubbleDown(curr.left);
                if (curr.right.data < curr.data){
                    bubbleDown(curr);
                }
                else{
                    findLessThan(curr);
                }
            }
        }
        else if (curr.data < oldVal){
            update(oldVal, newVal, curr.right);
            if (curr.right.data < curr.data){
                int temp = curr.data;
                curr.data = curr.right.data;
                curr.right.data = temp;
                bubbleDown(curr.right);
                if (curr.left.data > curr.data){
                    bubbleDown(curr);
                }
                else{
                    findGreaterThan(curr);
                }
            }
        }
        else {
            curr.data = newVal;
            while (curr != null){
                if (curr.left != null && curr.data < curr.left.data){
                    int temp = curr.data;
                    curr.data = curr.left.data;
                    curr.left.data = temp;
                    curr = curr.left;
                }
                else if (curr.right != null && curr.data > curr.right.data && newVal < root.data){
                    int temp = curr.data;
                    curr.data = curr.right.data;
                    curr.right.data = temp;
                    curr = curr.right;
                }
                else{
                    break;
                }
            }
        }
    }

    private void update(int oldVal, int newVal, NumericTreeNode curr){
        if (curr == null){
            return;
        }
        if (curr.data > oldVal){
            update(oldVal, newVal, curr.left);
            if (curr.left.data > curr.data){
                int temp = curr.data;
                curr.data = curr.left.data;
                curr.left.data = temp;
                bubbleDown(curr.left);
            }
        }
        else if (curr.data < oldVal){
            update(oldVal, newVal, curr.right);
            if (curr.right.data < curr.data){
                int temp = curr.data;
                curr.data = curr.right.data;
                curr.right.data = temp;
                bubbleDown(curr.right);
            }
        }
        else{
            curr.data = newVal;
            if (oldVal < root.data){
                while (curr != null){
                    if (curr.left != null && curr.data < curr.left.data){
                        int temp = curr.data;
                        curr.data = curr.left.data;
                        curr.left.data = temp;
                        curr = curr.left;
                    }
                    else if (curr.right != null && curr.data > curr.right.data && newVal < root.data){
                        int temp = curr.data;
                        curr.data = curr.right.data;
                        curr.right.data = temp;
                        curr = curr.right;
                    }
                    else{
                        break;
                    }
                }
            }
            else if (oldVal > root.data){
                while (curr != null){
                    if (curr.left != null && curr.data < curr.left.data && newVal > root.data){
                        int temp = curr.data;
                        curr.data = curr.left.data;
                        curr.left.data = temp;
                        curr = curr.left;
                    }
                    else if (curr.right != null && curr.data > curr.right.data){
                        int temp = curr.data;
                        curr.data = curr.right.data;
                        curr.right.data = temp;
                        curr = curr.right;
                    }
                    else{
                        break;
                    }
                }
            }
        }
    }

    private void bubbleDown(NumericTreeNode curr){
        if (curr.left != null && curr.data < curr.left.data){
            int temp = curr.data;
            curr.data = curr.left.data;
            curr.left.data = temp;
            bubbleDown(curr.left);
        }
        else if (curr.right != null && curr.data > curr.right.data){
            int temp = curr.data;
            curr.data = curr.right.data;
            curr.right.data = temp;
            bubbleDown(curr.right);
        }
    }

    private void findLessThan(NumericTreeNode root){
        NumericTreeNode curr = root.right;
        while (curr != null){
            if (root.data > curr.data){
                int temp = root.data;
                root.data = curr.data;
                curr.data = temp;
                findLessThan(curr);
                break;
            }
            curr = curr.left;
        }
    }

    private void findGreaterThan(NumericTreeNode root){
        NumericTreeNode curr = root.left;
        while (curr != null){
            if (root.data < curr.data){
                int temp = root.data;
                root.data = curr.data;
                curr.data = temp;
                findGreaterThan(curr);
                break;
            }
            curr = curr.right;
        }
    }

    public boolean search(int val){
        if (root == null){
            return false;
        }
        NumericTreeNode curr = root;
        if (curr.data == val){
            return true;
        }
        else if (curr.data > val){
            return search(curr.left, val);
        }
        else{
            return search(curr.right, val);
        }
    }

    private boolean search(NumericTreeNode curr, int val){
        if (curr == null){
            return false;
        }
        if (curr.data == val){
            return true;
        }
        else if (curr.data > val){
            return search(curr.left, val);
        }
        else{
            return search(curr.right, val);
        }
    }

    public String inOrder(){
        if (root == null){
            return "";
        }
        String result = "";
        NumericTreeNode curr = root;
        result += inOrder(curr.left);
        result += curr.data;
        result += inOrder(curr.right);
        return result;
    }

    private String inOrder(NumericTreeNode curr){
        if (curr == null){
            return "";
        }
        String result = "";
        result += inOrder(curr.left);
        result += curr.data;
        result += inOrder(curr.right);
        return result;
    }

    public static NumericTreeNode sortedArrayToBST(int[] values){
        BinarySearchTree b = new BinarySearchTree();
        int rootVal = values[values.length/2];
        b.insert(rootVal);
        for (int i = 0; i < values.length; i++){
            b.insert(values[i]);
        }
        return b.root;
    }

    public int lowestCommonAncestor(int p, int q){
        NumericTreeStack pStack = new NumericTreeStack();
        NumericTreeStack qStack = new NumericTreeStack();
        NumericTreeNode curr = root;
        int pDepth = 0;
        pStack.enqueue(curr);
        pDepth++;
        while (curr.data != p){
            if (p < curr.data){
                curr = curr.left;
            }
            else if (p > curr.data){
                curr = curr.right;
            }
            if (curr == null){
                return -1;
            }
            pStack.enqueue(curr);
            pDepth++;
        }
        curr = root;
        int qDepth = 0;
        qStack.enqueue(curr);
        qDepth++;
        while (curr.data != q){
            if (q < curr.data){
                curr = curr.left;
            }
            else if (q > curr.data){
                curr = curr.right;
            }
            if (curr == null){
                return -1;
            }
            qStack.enqueue(curr);
            qDepth++;
        }
        while (pDepth != qDepth){
            if (pDepth > qDepth){
                pDepth--;
                pStack.dequeue();
            }
            if (qDepth > pDepth){
                qDepth--;
                qStack.dequeue();
            }
        }
        while (!pStack.isEmpty() && !qStack.isEmpty()){
            int pVal = pStack.dequeue().data;
            int qVal = qStack.dequeue().data;
            if (pVal == qVal){
                return pVal;
            }
        }
        return -1;

    }

    public static void main(String[] args){
        BinarySearchTree b = new BinarySearchTree();
        b.insert(3);
        b.insert(6);
        b.insert(1);
        b.insert(0);
        b.insert(4);
        b.insert(10);
        System.out.println(b.inOrder());
        b.update(10, 2);
        System.out.println(b.inOrder());
        System.out.println(b.lowestCommonAncestor(12, 2));
        int [] sortedArray = new int[5];
        sortedArray[0] = -10;
        sortedArray[1] = -3;
        sortedArray[2] = 0;
        sortedArray[3] = 5;
        sortedArray[4] = 9;
        NumericTreeNode arrayRoot = sortedArrayToBST(sortedArray);
        System.out.println(arrayRoot.data);
    }

}
