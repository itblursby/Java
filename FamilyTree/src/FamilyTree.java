import java.util.*;
import java.io.*;
public class FamilyTree {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("family.in"));
		PrintWriter p = new PrintWriter("family.out");
		s.close();
		p.close();
	}
	class Cow {
		ArrayList<Cow> children = new ArrayList<Cow>(0);
		Cow mother;
		String name;
		Cow(Cow m,String name_){
			this.mother = m;
			this.name = name_;
		}
		void addChild(Cow e){
			this.children.add(e);
		}
		Cow getChild(int i){
		    return this.children.get(i);
		}
	}
	

}
