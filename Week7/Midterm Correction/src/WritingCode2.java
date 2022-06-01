import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class WritingCode2 {

	public static void main(String[] args) {

	    HashMap<String, Integer> map = new HashMap<String, Integer>();
	    map.put("hi", 5);
	    map.put("aloha", 7);
	    map.put("howdy", 4);
	    map.put("hello", 9);
	    map.put("hola", 5);

	    HashMap<Integer,List<String>> newMap = flipMap(map);
	    
	    for(Map.Entry<Integer, List<String>> entry: newMap.entrySet()){
	        System.out.println(entry.getKey() + " " + entry.getValue());
	    }
	}
	
	public static HashMap<Integer,List<String>> flipMap(HashMap<String, Integer> map) {
		
		HashMap<Integer,List<String>> newMap = new HashMap<Integer, List<String>>();
	    for (Map.Entry<String, Integer> element : map.entrySet()) {
	        if(newMap.containsKey(element.getValue())){
	            newMap.get(element.getValue()).add(element.getKey());
	        } else {
	            List<String> tmpList = new ArrayList<String>();
	            tmpList.add(element.getKey());
	            newMap.put(element.getValue(), tmpList);
	        }
	    }
	    
	    return newMap;
	}
}
