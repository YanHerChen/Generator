import java.util.ArrayList;
import java.util.HashMap;

public class RecordKeyN {
	/*
	 * act:活動 emap:博物館 ODM:步道 food食物
	 */
	private static HashMap<String, String> Recordact = new HashMap<String, String>();
	private static HashMap<String, String> Recordemap = new HashMap<String, String>();
	private static HashMap<String, String> RecordODM = new HashMap<String, String>();
	private static HashMap<String, String> Recordfood = new HashMap<String, String>();
	private static HashMap<String, String> Recordhotel = new HashMap<String, String>();
	private static ArrayList<String> Record = new ArrayList<String>();
	public static ArrayList<String> PublicRecordKey;
	private static String act, emap, ODM, food, hotel;
	

	RecordKeyN() {
		Recordact = new HashMap<String, String>();
		Recordemap = new HashMap<String, String>();
		RecordODM = new HashMap<String, String>();
		Recordfood = new HashMap<String, String>();
		Recordhotel = new HashMap<String, String>();
		Record = new ArrayList<String>();
	}

	public static void rknadd(String name, int index) {
		switch (index) {
		case 1:
			Recordact.put(name, name);
			act = name;
			break;
		case 2:
			Recordemap.put(name,name);
			emap = name;
			break;
		case 3:
			RecordODM.put(name,name);
			ODM = name;
			break;
		case 4:
			Recordfood.put(name, name);
			food = name;
			break;
		case 5:
			Recordhotel.put(name, name);
			hotel = name;
			break;
		}
	}

	public static void rknarrayadd(String name) {
		Record.add(name);
	}

	public static String rknget(int index) {
		String reply = "";
		switch (index) {
		case 1:
			reply = Recordact.get(act);
			break;
		case 2:
			reply = Recordemap.get(emap);
			break;
		case 3:
			reply = RecordODM.get(ODM);
			break;
		case 4:
			reply = Recordfood.get(food);
			break;
		case 5:
			reply = Recordhotel.get(hotel);
			break;
		}
		if (reply == null) {
			if (Recordact.size() > 0)
				reply = Recordact.get(act);
			else if (Recordemap.size() > 0)
				reply = Recordemap.get(emap);
			else if (RecordODM.size() > 0)
				reply = RecordODM.get(ODM);
			else if (Recordfood.size() > 0)
				reply = Recordfood.get(food);
			else if (Recordhotel.size() > 0)
				reply = Recordhotel.get(hotel);
		}

		return reply;
	}

	public static String rknarrayget(int index) {
		PublicRecordKey = Record;
		return PublicRecordKey.get(index);
	}

	public static String selectfull() {
		String reply = "";
		if (Recordact.size() > 0)
			reply = Recordact.get(act);
		else if (Recordemap.size() > 0)
			reply = Recordemap.get(emap);
		else if (RecordODM.size() > 0)
			reply = RecordODM.get(ODM);
		else if (Recordfood.size() > 0)
			reply = Recordfood.get(food);
		else if (Recordhotel.size() > 0)
			reply = Recordhotel.get(hotel);
		return reply;
	}

	public static int rknarraySize() {
		return Record.size();
	}
	
	public static String RandomGetRecord() {
		int code = (int) (Math.random() * Record.size());
		return Record.get(code);
	}
}
