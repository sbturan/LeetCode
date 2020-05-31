import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvalidTransactions {
	public static void main(String[] args) {
		System.out.println(new InvalidTransactions()
				.invalidTransactions(new String[]{"alice,20,800,mtv","alice,50,100,beijing"}));
	}
	public List<String> invalidTransactions(String[] transactions) {
		List<String> result = new ArrayList<>();
		boolean[] isAdded=new boolean[transactions.length];
		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < transactions.length; i++) {
			String cur = transactions[i];
			cur = cur + "," + i;
			String name = cur.split(",")[0];
			isValid(cur, map.get(name), result, transactions,isAdded);
			List<String> orDefault = map.getOrDefault(name, new ArrayList<>());
			orDefault.add(cur);
			map.put(name,orDefault);
		}
		return result;
	}

	private void isValid(String tran, List<String> olds, List<String> result, String[] transactions,boolean[] isAdded) {
		
		String[] splitted = tran.split(",");
		boolean isValid = true;
		if (Float.valueOf(splitted[2]) > 1000) {
			isValid = false;
		}

		String city = splitted[3];
		Integer timeOrg=Integer.valueOf(splitted[1]);
		if(olds!=null) {
			for (String s : olds) {
				String[] split = s.split(",");
				Integer time=Integer.valueOf(split[1]);
				Integer index = Integer.valueOf(split[4]);
				if (!city.equals(split[3])&&Math.abs(time-timeOrg)<=60) {
					isValid = false;
					if(!isAdded[index]) {
						result.add(transactions[index]);
						isAdded[index]=true;
					}
					
				}

			}
		}

		if (!isValid) {
			Integer curIndex = Integer.valueOf(splitted[4]);
			if(!isAdded[curIndex]) {
				result.add(transactions[curIndex]);
				isAdded[curIndex]=true;
			}
			
		}
	}
}
