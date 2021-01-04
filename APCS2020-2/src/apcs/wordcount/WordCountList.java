package apcs.wordcount;
import java.util.Iterator;
import java.util.ArrayList;
public class WordCountList {
	//not going to implement List because there's a trillion methods I have to write.
	//will include size() indexOf() get() add() clear() contains()
	private ArrayList<WordCount> counts;
	public WordCountList() {
		counts = new ArrayList<WordCount>();
	}
	public WordCountList(int cap) {
		counts = new ArrayList<WordCount>(cap);
	}
	public int size() { return counts.size(); }
	public void clear() { counts.clear(); }
	public boolean add(WordCount wc) {
		if (counts.isEmpty()) {
			System.out.println("adding"+wc.getWord());
			counts.add(wc);
			return true;
		}
		int x = indexToInsert(wc);
//		if (x >= counts.size()) {
//			counts.add(wc);
//		}
		boolean co = contains2(x,wc);
		if (co) {
			System.out.println("incrementing"+wc.getWord());
			counts.get(x).increment();
			return false;
		}else {
			System.out.println("adding"+wc.getWord());
			counts.add(x,wc);
			return true;
		}
		
//		boolean added = false;
//		for (int i = 0; i < counts.size(); i++) {
//			if (counts.get(i).compareTo(wc)>0) {
//				counts.add(i,wc);
//				System.out.println("DBG: added " + wc.toString());
//				added = true;
//				break; // VWU, DO NOT read and modify the 'counts' at the same time. So we add to it and quit
//			}
//		}
//		if (!added) {
//			counts.add(wc);
//		}
		
	}
	public WordCount get(int i) {
		return counts.get(i);
	}
	public boolean addWord(String word) {
		
		WordCount wc = new WordCount(word,1);
		//add(wc);
//		int x = binarySearch(wc,0,counts.size());
//		if (x == -1) {
//			add(wc);
//			return;
//		}
		return add(wc);
		
//		int x = indexToInsert(wc);
//		if (x >= counts.size()) {
//			add(wc);
//			return;
//		}else if(counts.get(x).equals(wc)) {
//			counts.get(x).increment();
//			return;
//		}else {
//			add(wc);
//			return;
//		}
		
		
		//counts.get(x).increment();
		
	}
	public boolean contains(WordCount wc) {
//		int t = binarySearch(wc,0,counts.size());
//		if (t == -1){
//			return false;
//		}
//		return true;
		if (counts.size() == 0) {
			return false;
		}
		int t = indexToInsert(wc);
		if (t < counts.size()) {
			if (counts.get(t).equals(wc)) {
				return true;
			}
		}
		return false;
		
	}
	//use it right
	private boolean contains2(int index, WordCount wc) {
		if (counts.size() == 0) {
			return false;
		}
		
		if (index < counts.size()) {
			if (counts.get(index).equals(wc)) {
				return true;
			}
		}
		return false;
	}
	public int indexOf(WordCount wc) {
		int x = indexToInsert(wc);
		if (contains2(x,wc)) {
			return x;
		}
		return -1;
		//return binarySearch(wc,0,counts.size());
	}
	public boolean remove(int index) {
		if (index >= counts.size()) {
			return false;
		}else {
			counts.remove(index);
			return true;
		}
	}
	//returns index if found (old method that isn't used)
	private int binarySearch(WordCount wc, int begin, int end) {
		if (counts.size() == 0) {
			return -1;
		}
		if (begin > end) {    // VWU
			return -1;
		}
		//if (end - begin == 1) return counts.get(begin).equals(wc)?begin:-1;
		int tester = (begin + end) >> 1;
		if (tester < 0 || tester >= counts.size()) {
			return -1;
		}
		if (counts.get(tester).equals(wc)) {
			return tester;
		}
		if (wc.compareTo(counts.get(tester))>0){
			return binarySearch(wc, tester+1, end);
		}else {
			return binarySearch(wc, begin, tester-1);
		}
		//return 0;
	}
	//finds the smallest wordcount that is larger or equal to the given wordcount
	//range is [begin, end)
	private int indexToInsert(WordCount wc) {
		if (counts.size() == 0) {
			return 0;
		}
		
		if (counts.get(0).compareTo(wc)>=0) {
			System.out.print("gottem");
			return 0;
		}else if (counts.get(counts.size()-1).compareTo(wc)<0) {
			return counts.size();
		}else if (counts.get(counts.size()-1).compareTo(wc)==0) {
			return counts.size()-1;
		} else {
			return indexToInsert2(wc,1,counts.size());
		}
		
	}
	private int indexToInsert2(WordCount wc, int begin, int end) {
//		if (begin == end) {
//			return begin;
//		}
		int tester = (begin+end)>>1;
		//System.out.println("b"+arr[begin]+" t"+arr[tester]+" e"+arr[end]+" s"+subject);
		if (counts.get(tester).compareTo(wc)>=0&&counts.get(tester-1).compareTo(wc)<0) {
			return tester;
		}else if (counts.get(tester).compareTo(wc)>=0&&counts.get(tester-1).compareTo(wc)>=0) {
			return indexToInsert2(wc, begin, tester);
		}else {
			return indexToInsert2(wc, tester, end);
		}
	}
	@Override
	public String toString() {
		return counts.toString();
	}
	
}
