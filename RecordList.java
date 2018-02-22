import java.util.ArrayList;
import java.util.HashMap;

public class RecordList {
	//¨C¤@¥yªº¬ö¿ý
	private static ArrayList<String[]> Record = new ArrayList<String[]>();
	public static ArrayList<String[]> PublicRecord;
	
	RecordList(){
		Record = new ArrayList<String[]>();
	}
	
	public static void rladd(String[] chat) {
		Record.add(chat);
	}
	
	public static String[] rlget(int index) {
		return Record.get(index);
	}
	
	public static void rlclear() {
		Record.clear();
	}
	
	public static int rlSize() {
		return Record.size()-1;
	}
	
	public static ArrayList<String[]> rlgetAll(){
		PublicRecord = Record;
		return PublicRecord;
	}
}
