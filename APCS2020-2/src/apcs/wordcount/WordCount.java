package apcs.wordcount;

import java.util.Comparator;

public class WordCount implements Comparable<WordCount> {
	final private String target;
	private int count = 0;
	public WordCount(String target) {
		this.target = target;
	}
	public WordCount(String target, int count) {
		this.target = target;
		this.count = count;
	}
	public String getWord() { return target; }
	public int getCount() { return count; }
	public void increment() { count++; }
	@Override
	public int compareTo(WordCount other) {
		return this.target.compareTo(other.getWord());
	}
	@Override
	public boolean equals(Object other) {
		WordCount o = (WordCount) other;
		return this.target.equals(o.getWord());
	}
	@Override
	public String toString() {
		return "[Word: \""+target+"\" count: " + count + "]";
	}
	
}
class WordCommon implements Comparator<WordCount>{
	@Override
	public int compare(WordCount o1, WordCount o2) {
		// TODO Auto-generated method stub
		return o1.getCount() - o2.getCount();
	}
}
class WordAlpha implements Comparator<WordCount>{
	@Override
	public int compare(WordCount o1, WordCount o2) {
		return o1.getWord().compareTo(o2.getWord());
	}
}

