import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.out;

public class Program {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		
		nums.add(3);
		nums.add(-2);
		nums.add(1);
		
		//for(int k : nums)
		//	System.out.println(k);
		
		//nums.stream().forEach(out::println);
		
		//for(int k : nums)
		//	if (k > 0)
		//		System.out.println(k);
		
		//nums.stream().filter(p->p > 0).forEach(out::println);
		
		/*ArrayList<Integer> result = new ArrayList<>();
		for(int k : nums)
			if (k > 0)
				result.add(k);
		
		Collections.sort(result);
		for(int k : result)
			System.out.println(k);*/
		
		/*nums.stream()
			.filter(p->p > 0)
			.sorted()
			.forEach(out::println);*/
		
		nums.parallelStream()
			.filter(p->p > 0)
			.sequential()
			.sorted((x,y)->y-x)
			.forEach(out::println);
		
		/*nums.parallelStream().
		filter(x-> x > 0).
		sequential().
		sorted().
		forEach( System.out::println);*/
		
		//nums.stream().
		//nums.parallelStream().
		//	filter(x->x>0).
		//	sequential().
		//	sorted().
		//	forEach( System.out::println );
		

	}

}
