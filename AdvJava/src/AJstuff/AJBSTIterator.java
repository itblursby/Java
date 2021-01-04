package AJstuff;
import java.util.Iterator;
import java.util.LinkedList;
public class AJBSTIterator<E> implements Iterator<E>{

	private LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	public AJBSTIterator(TreeNode tn) {
		TreeNode traveler = tn;
		while(traveler != null) {
			stack.push(traveler);
			traveler = traveler.left;
		}
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return stack.size()>0;
	}

	@Override
	public E next() {
		E val = stack.peek().val;
		// TODO Auto-generated method stub
		
		return null;
	}

}
