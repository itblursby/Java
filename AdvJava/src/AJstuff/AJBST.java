package AJstuff;

import java.util.Iterator;

public class AJBST<E extends Comparable> implements AJCollection<E> {
	private TreeNode root;
	int size = 0;
	public AJBST() {
		
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		TreeNode traveler = root;
		if (traveler == null) {
			root = new TreeNode(e);
			return true;
		}
		while(true) {
			if (e.compareTo(traveler.val)<0) {
				if (traveler.left == null) {
					traveler.left = new TreeNode<E>(e);
					size++;
					break;
				} else {
					traveler = traveler.left;
				}
			} else {
				if (traveler.right == null) {
					traveler.right = new TreeNode<E>(e);
					size++;
					break;
				} else {
					traveler = traveler.right;
				}
			}
		}
		return true;
	}

	@Override
	public boolean remove(E e) {
		TreeNode parent = null;
		TreeNode traveler = root;
		while(traveler != null) {
			if (traveler.val.equals(e)) {
				deleteRoot(traveler, parent);
				size--;
				return true;
			}
			parent = traveler;
			if (e.compareTo(traveler.val)<0) {
				traveler = traveler.left;
			} else {
				traveler = traveler.right;
			}
		}
		return false;
	}
	private void deleteRoot(TreeNode tn, TreeNode parent) {
		if (tn.left == null && tn.right == null) {
			if (parent == null) {
				root = null;
			} else {
				if (parent.val.compareTo(tn.val)<0) {
					parent.left = null;
				}else {
					parent.right = null;
				}
			}
		}else {
			if (tn.left != null) {
				tn.val = tn.left.val;
				deleteRoot(tn.left,tn);
			}else {
				tn.val = tn.right.val;
				deleteRoot(tn.right,tn);
			}
		}
	}
	@Override
	public boolean contains(E e) {
		TreeNode traveler = root;
		while(traveler != null) {
			if (traveler.val.equals(e)) return true;
			if (e.compareTo(traveler.val)<0) traveler = traveler.left;
			else traveler = traveler.right;
		}
		return false;
	}
	private TreeNode contains2(E e) {
		TreeNode traveler = root;
		while(traveler != null) {
			if (traveler.val.equals(e)) return traveler;
			if (e.compareTo(traveler.val)<0) traveler = traveler.left;
			else traveler = traveler.right;
		}
		return null;
	}
	@Override
	public void clear() {
		root = null;
		size = 0;		
	}
	@Override
	public int size() {
		return size;
	}
}
class TreeNode<E extends Comparable>{
	E val;
	TreeNode left;
	TreeNode right;
	TreeNode(E e) {
		val = e;
		left = null;
		right = null;
	}
	TreeNode() {
		val = null;
		left = null;
		right = null;
	}
	
}
