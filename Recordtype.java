import java.util.ArrayList;
import java.util.HashMap;

public class Recordtype {
	private static HashMap<String,String> Record = new HashMap<String,String>();
	public static ArrayList<String> PublicRecordKey;
	
	Recordtype(){
		Record = new HashMap<String,String>();
	}
	
	public static void rtadd(String type) {
		Record.put(type,type);
	}
	
	public static boolean contain(String type) {
		if(Record.containsKey(type))
			return true;
		else
			return false;
	}
	
	public static int rtSize() {
		return Record.size();
	}
}
