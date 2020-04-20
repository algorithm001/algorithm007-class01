package leetCode.week03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_77_0065 {
	
	List<List<Integer>> res = new ArrayList<>();
	int n;
	int k;
	
	public List<List<Integer>> combine(int n, int k) {
	    this.n = n;
	    this.k = k;
	    backtrack(1, new LinkedList<Integer>());
	    return res;
	  }

	public void backtrack(int first,LinkedList<Integer> curr ) {
		if (curr.size() == k) {
			res.add(new LinkedList<>(curr));
		}
		
		for (int i = first;i < n + 1;i++) {
			curr.add(i);
			backtrack(i + 1, curr);
			curr.removeLast();
		}
	}
}
