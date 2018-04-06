import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateFileinSystem {
	public static void main(String[] args) {
		FindDuplicateFileinSystem f=new FindDuplicateFileinSystem();
		System.out.println(f.findDuplicate(new String[] {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));
	} 
	public List<List<String>> findDuplicate(String[] paths) {
         
		HashMap<String,List<String>> contectMap=new HashMap<>();
		for(int i=0;i<paths.length;i++) {
			String[] split = paths[i].split(" ");
			for(int j=1;j<split.length;j++) {
				String content=split[j].split("\\(")[1];
				content=content.substring(0, content.length()-1);
				List<String> orDefault = contectMap.getOrDefault(content, new ArrayList<>());
				orDefault.add(split[0]+"/"+split[j].split("\\(")[0]);
				contectMap.put(content, orDefault);
			}
		}
		
		List<List<String>> result=new ArrayList<>();
		for(String s:contectMap.keySet()) {
			if(contectMap.get(s).size()>1) {
				result.add(contectMap.get(s));
			}
		}
		return result;
	}
}

 