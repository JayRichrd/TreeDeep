package com.jy;

public class Main {

	public static void main(String[] args) {
		// 构建树结构
		TreeNode node7 = new TreeNode(7, null, null);
		TreeNode node6 = new TreeNode(6, null, null);
		TreeNode node5 = new TreeNode(5, node7, null);
		TreeNode node4 = new TreeNode(4, null, null);
		TreeNode node3 = new TreeNode(3, null, node6);
		TreeNode node2 = new TreeNode(2, node4, node5);
		TreeNode node1 = new TreeNode(1, node2, node3);
		System.out.println("树的深度:" + treeDeepRecursively(node1));
		System.out.println("树是否为平衡二叉树:" + isBalanced(node1));
	}

	/**
	 * 使用递归求取树的深度
	 * 
	 * @param root
	 *            树的根节点
	 * @return 返回树的深度
	 */
	public static int treeDeepRecursively(TreeNode root) {
		if (root == null)
			return 0;
		// 递归求取左右子树的深度
		int left = treeDeepRecursively(root.mLeft);
		int right = treeDeepRecursively(root.mRight);
		// 取较大者再加1为树的深度
		return left > right ? (left + 1) : (right + 1);
	}

	/**
	 * 判断某树是否为平衡二叉树
	 * 
	 * @param root
	 *            树的根节点
	 * @return 如果是平衡树返回true,否则返回false
	 */
	public static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		int[] deep = new int[1];
		return isBalanced(root, deep);
	}

	/**
	 * 判断某树是否为平衡二叉树
	 * 
	 * @param root
	 *            树的根节点
	 * @param deep
	 *            保存当前节点的深度
	 * @return 如果是平衡树返回true,否则返回false
	 */
	public static boolean isBalanced(TreeNode root, int[] deep) {
		if (root == null) {
			deep[0] = 0;
			return true;
		}

		int[] left = new int[1];
		int[] right = new int[1];
		// 后续遍历判断每个节点
		if (isBalanced(root.mLeft, left) && isBalanced(root.mRight, right)) {
			int dif = left[0] - right[0];
			// 根据差值判断是否为平衡树
			if (dif >= -1 && dif <= 1) {
				deep[0] = (left[0] > right[0] ? left[0] : right[0]) + 1;
				return true;
			}
		}
		return false;
	}

}
