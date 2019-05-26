package tree;


import java.util.*;

/**
 * Created by longyun on 2018/10/15.
 */
public class BinaryTree {
    private TreeNode root; // 根
    public BinaryTree() {	// 构造函数
        root = null;
    }

    // 判断二叉树是否为空
    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 【递归】: 创建二叉树（二叉搜索树：左小右大的结构）， 每加入一个新元素，都要从root开始比较
     */
    public void buildTree(TreeNode node, int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            if (data < node.data) {
                if (node.left == null) {
                    node.left = new TreeNode(data);
                } else {
                    buildTree(node.left, data); // 递归！！！
                }
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(data);
                } else {
                    buildTree(node.right, data); // 递归！！！
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = new TreeNode(6);
        int[] num = {1, 2, 3, 4, 5, 6};
        for(int i = 0; i < num.length; i++){
            binaryTree.buildTree(root, num[i]);
        }
        binaryTree.levelOrderBottom(root);
    }

    //VLR——先序遍历
    void vlrDFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                System.out.println(cur.data);
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();//出栈
            cur = cur.right;//转向
        }
    }

    //LVR——中序遍历
    void lvrDFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();//出栈
            System.out.println(cur.data);//访问（左也可以看做是根结点，优先访问L）
            cur = cur.right;//转向
        }
    }

    //LRV——后序遍历
    void lrvDFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;

        while (cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            //在出栈之前，将栈顶元素，即当前节点cur视作实际的根节点，并检查其右子树是否已被访问
            //每当一个结点出栈时，都先扫描该结点的右子树，只有当该结点的左孩子和右孩子结点均被访问过了，才能访问结点自身。
            //1、获取栈顶元素
            cur = stack.peek();

            //没有右子树or右子树已经被访问过  的情况下，才可以访问V（保证R在V前边访问，L可以看做左右子树都为null）
            if (cur.right == null || cur.right == last) {
                //1. 访问元素
                System.out.println(cur.data);
                //2. 出栈顶
                stack.pop();
                //3.记录上次访问的结点
                last = cur;
                //4. 继续出栈（V被访问过了LRV，该出栈访问上一层的LRV）
                cur = null;
            }
            //有右子树，转向，右子树的左右孩子接着入栈
            else {
                cur = cur.right;
            }
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result, new ArrayList<>(), sum);
        return result;
    }

    private void dfs(TreeNode root, List<List<Integer>> result, List<Integer> tmpList, int sum) {
        if (root == null) {
            return;
        }
        //叶子结点
        if (root.left == null && root.right == null && sum - root.data == 0) {
            tmpList.add(root.data);
            result.addAll(new ArrayList(tmpList));
            tmpList.remove(tmpList.size() - 1);
            return;
        }
        dfs(root.left, result, tmpList, sum - root.data);
        dfs(root.right, result, tmpList, sum - root.data);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        Stack<List<Integer>> stack = new Stack<List<Integer>>();

        if(root == null){
            return result;
        }

        //1、根节点入队列
        queue.offer(root);

        //2、while条件 队列不为空
        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            //记录当前层的结点
            List<Integer> list = new ArrayList<>();

            //处理当前层的结点
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();//取出队列头
                list.add(node.data);

                if(node.left != null) //把下一层，左子树放入queue
                    queue.offer(node.left);
                if(node.right != null) //把下一层，右子树放入queue
                    queue.offer(node.right);
            }

            stack.push(new ArrayList(list));

        }//while

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }
}
