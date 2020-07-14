
import java.util.*;
import java.util.stream.*;
class Try{
	
	public static void main(String args[]) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.forEach(n->System.out.println(n));
		arr.forEach(n->{
			if(n%2 == 0)
				System.out.println(n);
		});
	}
}  