//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//public class Test {
//	public static void main(String[] args) {
//		Test t = new Test();
////		
////		System.out.println(
////				t.minimumHours(4, 5, possibleFeatures, numFeatureRequests, featureRequests));
//	}
//	   int minimumHours(int rows, int columns, List<List<Integer> > grid)
//	    { 
//		    if(rows==0||columns==0 ||grid==null || grid.get(0)==null) {
//		    	return 0;
//		    }
//	        int result=0;
//	        int[][] matrix=new int[rows][columns];
//	     	for(int i=0;i<rows;i++) {
//        		for(int j=0;j<columns;j++) {
//        	       matrix[i][j]=grid.get(i).get(j);		
//        		}
//	     	}
//	     	int oneCount=0;
//	        while (oneCount<rows*columns) {
//	        	oneCount=0;
//	        	int[][] matrixNew=new int[rows][columns];
//	        	for(int i=0;i<rows;i++) {
//	        		for(int j=0;j<columns;j++) {
//	        			if(matrix[i][j]==1) {
//	        				matrixNew[i][j]=1;
//	        				oneCount++;
//	        				if(i>0) {
//	        					matrixNew[i-1][j]=1;
//	        				}
//	        				if(i<rows-1) {
//	        					matrixNew[i+1][j]=1;
//	        				}
//	        				if(j>0) {
//	        					matrixNew[i][j-1]=1;
//	        				}
//	        				if(j<columns-1) {
//	        					matrixNew[i][j+1]=1;
//	        				}
//	        			}
//	        		}
//	        	}
//	        	  for (int i = 0; i < matrixNew.length; i++) {
//	        		  matrix[i] = Arrays.copyOf(matrixNew[i], matrixNew[i].length);
//	        	  }
//	        	result++;
//	        }
//	        return result-1;
//	    }
//	public ArrayList<String> popularNFeatures(int numFeatures, int topFeatures, List<String> possibleFeatures,
//			int numFeatureRequests, List<String> featureRequests) {
//		if(topFeatures>numFeatures) {
//			return new ArrayList<>(featureRequests);
//		}
//		if (topFeatures == 0 || featureRequests == null || possibleFeatures == null || numFeatures == 0
//				|| numFeatureRequests == 0) {
//			return new ArrayList<String>();
//		}
//
//		HashMap<String, Integer> counts = new HashMap<>();
//		for (String pf : possibleFeatures) {
//			for (String fr : featureRequests) {
//				if (fr.toLowerCase().indexOf(pf.toLowerCase()) > -1) {
//					counts.put(pf, counts.getOrDefault(pf, 0) + 1);
//
//				}
//			}
//		}
////		Map<String, Integer> sortedMap = counts.entrySet().stream()
////				.sorted((Map.Entry.<String, Integer>comparingByValue().reversed()).)
////				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
//		ArrayList<String> result = new ArrayList<String>();
//		Set<String> keySet = sortedMap.keySet();
//		int i = 0;
//		for (String s : keySet) {
//			result.add(s);
//			i++;
//			if (i == topFeatures) {
//				break;
//			}
//		}
//		return result;
//	}
//}
