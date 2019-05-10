import java.util.*;
class InOrderIter {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();
		if (root == null)
			return list;
		int count = 0;
		TreeNode cur = root;
		while(!st.empty()) {
			//System.out.println("Peek "+cur.val);
			while (cur != null) {
				st.push(cur);
				//System.out.println("Left "+cur.val);
				cur = cur.left;
				System.out.println(count++);
			}
			cur = st.pop();
			//System.out.println("Pop "+cur.val);
			list.add(cur.val);
			cur = cur.right;
				System.out.println(count++);
		}
		return list;
	}
}
