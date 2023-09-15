
public class BitWiseSum {

	static int add(int x, int y) {
		int keep = (x & y) << 1;
		int res = x ^ y;

		if (keep == 0)
			return res;
		return add(keep, res);
	}

	public static void main(String[] args) {
		System.out.println(add(15, 38));
	}

}
