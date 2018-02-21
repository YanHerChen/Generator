import java.util.ArrayList;

public class RecordKeyN {
	private static ArrayList<String> Record = new ArrayList<String>();
	public static ArrayList<String> PublicRecordKey;
	
	RecordKeyN(){
		Record = new ArrayList<String>();
	}
	
	public static void rknadd(String chat) {
		Record.add(chat);
	}
	
	public static String rknget(int index) {
		return Record.get(index);
	}
	
	public static void rknclear() {
		Record.clear();
	}
	
	public static int rknSize() {
		return Record.size();
	}
	
	public static ArrayList<String> rkngetAll(){
		PublicRecordKey = Record;
		return PublicRecordKey;
	}
}
