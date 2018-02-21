import java.util.ArrayList;
import java.util.HashMap;

public class RecordKeyN {
	private static HashMap<String, String> Recordact = new HashMap<String, String>();
	private static HashMap<String, String> Recordemap = new HashMap<String, String>();
	private static HashMap<String, String> RecordODM = new HashMap<String, String>();
	private static HashMap<String, String> Recordfood = new HashMap<String, String>();
	private static ArrayList<String> Record = new ArrayList<String>();
	public static ArrayList<String> PublicRecordKey;
	private static String act, emap, ODM, food;

	RecordKeyN() {
		Recordact = new HashMap<String, String>();
		Recordemap = new HashMap<String, String>();
		RecordODM = new HashMap<String, String>();
		Recordfood = new HashMap<String, String>();
		Record = new ArrayList<String>();
	}

	public static void rknadd(String type, int index) {
		switch (index) {
		case 1:
			Recordact.put(type, type);
			act = type;
			break;
		case 2:
			Recordemap.put(type, type);
			emap = type;
			break;
		case 3:
			RecordODM.put(type, type);
			ODM = type;
			break;
		case 4:
			Recordfood.put(type, type);
			food = type;
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
		}

		return reply;
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
		return reply;
	}

	public static String rknarrayget(int index) {
		PublicRecordKey = Record;
		return PublicRecordKey.get(index);
	}

	public static int rknSize() {
		return Record.size();
	}
}
