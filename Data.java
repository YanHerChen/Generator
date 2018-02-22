import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Data {
	/*
	 * emapAction是歷史與科別景點(博物館); 
	 * ODwsvMovingRoad是老街_登山步道_古道_隧道等觀光景點;
	 * Activity是活動，比如賞鳥、放天燈、划龍舟之類;
	 * Hotel是住宿; FoodShop是食物店家;
	 */
	private static HashMap<String, HashMap<String, String>> emapAction = new HashMap<String, HashMap<String, String>>();
	private static HashMap<String, HashMap<String, String>> ODwsvMovingRoad = new HashMap<String, HashMap<String, String>>();
	private static HashMap<String, HashMap<String, String>> Activity = new HashMap<String, HashMap<String, String>>();
	private static HashMap<String, HashMap<String, String>> Hotel = new HashMap<String, HashMap<String, String>>();
	private static HashMap<String, HashMap<String, String>> FoodShop = new HashMap<String, HashMap<String, String>>();

	private static String path = "C:\\Users\\River\\Desktop\\生成句子\\";
	private static String[] file = { "食衣住行\\景點\\歷史文物與科學景點\\emapOpenDataAction", "食衣住行\\景點\\觀光景點_老街_綠園道_登山步道_隧道_公園_古道等\\ODwsvMovingRoad",
			"食衣住行\\景點\\活動\\activity_C_f", "食衣住行\\住宿\\hotel_C_f","食衣住行\\食物\\foodshop" };

	Data() {
		try {
			ReadJsonData();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void ReadJsonData() throws IOException {
		int i = 0;
		for (String filepath : file) {
			JSONParser parser = new JSONParser();
			try {
				System.out.println(filepath);
				Object obj = parser.parse(new BufferedReader(
						new InputStreamReader(new FileInputStream(path + filepath + ".json"), "UTF-8")));
				JSONObject jsonObject = (JSONObject) obj;

				switch (i) {
				case 0:
					ParseEmapAction(jsonObject);
					break;
				case 1:
					ParseODwsvMovingRoad(jsonObject);
					break;
				case 2:
					ParseActivity_C_f(jsonObject);
					break;
				case 3:
					ParseHotel_C_f(jsonObject);
					break;
				case 4:
					ParseFoodshop(jsonObject);
					break;
				}
			} catch (Exception e) {//暫時關閉
				e.printStackTrace();
			}
			i++;
		}
	}

	/*ParseEmapAction
	 * name: 景點名稱
	 * type: 景點種類(歷史、文化、科學等等)
	 * address: 地址
	 * cityName: 縣市鄉鎮(json用兩個  隔開)
	 * ticketPrice: 票價
	 * phone: 連絡電話
	 * openTime: 開放時間
	 * groupTypeName: 種類(博物館)
	 */
	private static void ParseEmapAction(JSONObject jsonObject) {
		JSONArray emap = (JSONArray) jsonObject.get("emap");
		for (int i = 0; i < emap.size(); i++) {
			JSONObject emapObject = (JSONObject) emap.get(i);

			String name = (String) emapObject.get("name");
			String type = (String) emapObject.get("type");
			String address = (String) emapObject.get("address");
			String cityName = (String) emapObject.get("cityName");
			String ticketPrice = (String) emapObject.get("ticketPrice");
			String phone = (String) emapObject.get("phone");
			String openTime = (String) emapObject.get("openTime");
			String groupTypeName = (String) emapObject.get("groupTypeName");
			HashMap<String,String> temp = new HashMap<String,String>();
			temp.put("name", name);
			temp.put("type", type);
			temp.put("address", address);
			temp.put("cityName", cityName);
			temp.put("ticketPrice", ticketPrice);
			temp.put("phone", phone);
			temp.put("openTime", openTime);
			temp.put("groupTypeName", groupTypeName);
			emapAction.put(name, temp);
		}
	}

	/*ParseODwsvMovingRoad
	 * name: 景點名稱
	 * AreaLocation: 景點位置
	 * Feature: 特色
	 * Price: 票價
	 * StaTime: 停留時間
	 * TrafficGuidelines: 路線規劃
	 * City: 縣市
	 * Town: 鄉鎮
	 * Tel: 連絡電話
	 */
	private static void ParseODwsvMovingRoad(JSONObject jsonObject) {
		JSONArray ODwsv = (JSONArray) jsonObject.get("ODwsv");
		for (int i = 0; i < ODwsv.size(); i++) {
			JSONObject ODwsvObject = (JSONObject) ODwsv.get(i);

			String Name = (String) ODwsvObject.get("Name");
			String AreaLocation = (String) ODwsvObject.get("AreaLocation");
			String Feature = (String) ODwsvObject.get("Feature");
			String Price = (String) ODwsvObject.get("Price");
			String StayTime = (String) ODwsvObject.get("StayTime");
			String TrafficGuidelines = (String) ODwsvObject.get("TrafficGuidelines");
			String City = (String) ODwsvObject.get("City");
			String Town = (String) ODwsvObject.get("Town");
			String Tel = (String) ODwsvObject.get("Tel");
			

			HashMap<String,String> temp = new HashMap<String,String>();
			temp.put("name", Name);
			temp.put("AreaLocation", AreaLocation);
			temp.put("Feature", Feature);
			temp.put("Price", Price);
			temp.put("StayTime", StayTime);
			temp.put("TrafficGuidelines", TrafficGuidelines);
			temp.put("City", City);
			temp.put("Town", Town);
			temp.put("Tel", Tel);
			ODwsvMovingRoad.put(Name, temp);
		}
	}

	/*ParseActivity_C_f
	 * Name: 賞地名稱
	 * Add: 地址
	 * Location: 縣市鄉鎮(json用兩個 隔開)
	 * Description: 景點描述
	 * Start: 賞地開始時間
	 * End: 賞地結束時間
	 * Travellinginfo: 路線規劃
	 */
	private static void ParseActivity_C_f(JSONObject jsonObject) {
		JSONArray activity = (JSONArray) jsonObject.get("activity");
		for (int i = 0; i < activity.size(); i++) {
			JSONObject activityObject = (JSONObject) activity.get(i);

			String Add = (String) activityObject.get("Add");
			String Description = (String) activityObject.get("Description");
			String End = (String) activityObject.get("End");
			String Start = (String) activityObject.get("Start");
			String Travellinginfo = (String) activityObject.get("Travellinginfo");
			String Location = (String) activityObject.get("Location");
			String Name = (String) activityObject.get("Name");
			
			HashMap<String,String> temp = new HashMap<String,String>();
			temp.put("name", Name);
			temp.put("Add", Add);
			temp.put("Description", Description);
			temp.put("Start", Start);
			temp.put("End", End);
			temp.put("Travellinginfo", Travellinginfo);
			temp.put("Location", Location);
			Activity.put(Name, temp);
		}
	}

	/*ParseHotel_C_f
	 * Name: 飯店名稱
	 * Add: 地址
	 * Description: 描述特色
	 * Tel: 連絡電話
	 * Spec: 每間房價格
	 * Grade: 五星級飯店
	 */
	private static void ParseHotel_C_f(JSONObject jsonObject) {
		JSONArray JHotel = (JSONArray) jsonObject.get("Hotel");
		for (int i = 0; i < JHotel.size(); i++) {
			JSONObject HotelObject = (JSONObject) JHotel.get(i);

			String Add = (String) HotelObject.get("Add");
			String Description = (String) HotelObject.get("Description");
			String Tel = (String) HotelObject.get("Tel");
			String Name = (String) HotelObject.get("Name");
			String Spec = (String) HotelObject.get("Spec");
			String Grade = (String) HotelObject.get("Grade");
			
			HashMap<String,String> temp = new HashMap<String,String>();
			temp.put("name", Name);
			temp.put("Add", Add);
			temp.put("Description", Description);
			temp.put("Tel", Tel);
			temp.put("Spec", Spec);
			temp.put("Grade", Grade);
			Hotel.put(Name, temp);
		}
	}

	/*ParseFoodshop
	 * locate: 縣市
	 * openhour: 開放時間
	 * cost: 平均消費
	 * tel: 連絡電話
	 * name: 店名
	 * address: 地址
	 * classify: 店類型(義式、中式等)
	 * description: 描述、特色
	 */
	private static void ParseFoodshop(JSONObject jsonObject) {
		JSONArray Jfood = (JSONArray) jsonObject.get("foodshop");
		for (int i = 0; i < Jfood.size(); i++) {
			JSONObject HotelObject = (JSONObject) Jfood.get(i);
			String openhour = (String) HotelObject.get("openhour");
			String cost = (String) HotelObject.get("cost");
			String tel = (String) HotelObject.get("tel");
			String name = (String) HotelObject.get("name");
			String locate = (String) HotelObject.get("locate");
			String address = (String) HotelObject.get("address");
			String classify = (String) HotelObject.get("classify");
			String description = (String) HotelObject.get("description");
			
			HashMap<String,String> temp = new HashMap<String,String>();
			temp.put("name", name);
			temp.put("tel", tel);
			temp.put("cost", cost);
			temp.put("openhour", openhour);
			temp.put("address", address);
			temp.put("locate", locate);
			temp.put("classify", classify);
			temp.put("description", description);
			FoodShop.put(name, temp);
		}
	}

	public static HashMap<String,HashMap<String,String>> getData(String choice){
		switch(choice) {
		case "emapAction":
			return emapAction;
		case "ODwsvMovingRoad":
			return ODwsvMovingRoad;
		case "Activity":
			return Activity;
		case "Hotel":
			return Hotel;
		case "FoodShop":
			return FoodShop;
		default:
			return null; 
		}
	}

	//搜尋同樣縣市的其他地方(景點、住宿、活動、食物)
	public static String SearchViewlocate(String name) {
		String Location = "";
		if(emapAction.containsKey(name)) {
			HashMap<String,String> Etemp = emapAction.get(name);
			String[] city = Etemp.get("cityName").split("  ");
			Location = city[0];
		}else if(ODwsvMovingRoad.containsKey(name)) {
			HashMap<String,String> Otemp = ODwsvMovingRoad.get(name);
			Location = Otemp.get("City");
		}else if(Activity.containsKey(name)) {
			HashMap<String,String> Atemp = Activity.get(name);
			String[] city = Atemp.get("Location").split("  ");
			Location = city[0];
		}else if(FoodShop.containsKey(name)) {
			HashMap<String,String> Atemp = FoodShop.get(name);
			String[] city = Atemp.get("locate").split("  ");
			Location = city[0];
		}
		return Location;
	}
	
	//以下為搜尋新的地方(景點、住宿、活動、食物)
	public static String SearchFooshop(String locate) {
		ArrayList<String> arrayfood = new ArrayList<String>();
		for(String name:FoodShop.keySet()) {
			HashMap<String,String> temp = FoodShop.get(name);
			String key = temp.get("locate");
			if(key.contains(locate)) {
				arrayfood.add(name);
			}
		}
		int index = (int) (Math.random() * arrayfood.size());
		System.out.println(locate +"  Data300  "+index+"  "+arrayfood.size());
		String name = arrayfood.get(index);
		RecordTemp.add(name, FoodShop.get(name));
		return name;
	}
	
	public static String SearchAct(String locate) {
		ArrayList<String> arrayact = new ArrayList<String>();
		for(String name:Activity.keySet()) {
			HashMap<String,String> temp = Activity.get(name);
			String[] key = temp.get("Location").split("  ");
			if(key[0].contains(locate)) {
				arrayact.add(name);
			}
		}
		int index = (int) (Math.random() * arrayact.size());
		if(index==0)
			return SearchODM(locate);
		else {
			String name = arrayact.get(index);
			RecordTemp.add(name, Activity.get(name));
			return name;
		}
	}
	
	public static String SearchODM(String locate) {
		ArrayList<String> arrayODM = new ArrayList<String>();
		for(String name:ODwsvMovingRoad.keySet()) {
			HashMap<String,String> temp = ODwsvMovingRoad.get(name);
			String key = temp.get("City");
			if(key.contains(locate)) {
				arrayODM.add(name);
			}
		}
		int index = (int) (Math.random() * arrayODM.size());
		if(index==0)
			return SeachView(locate);
		else {
			String name = arrayODM.get(index);
			RecordTemp.add(name, ODwsvMovingRoad.get(name));
			return name;
		}
	}
	
	public static String SeachView(String locate) {
		ArrayList<String> arrayView = new ArrayList<String>();
		for(String name:emapAction.keySet()) {
			HashMap<String,String> temp = emapAction.get(name);
			String[] key = temp.get("cityName").split("  ");
			if(key[0].contains(locate)) {
				arrayView.add(name);
			}
		}
		int index = (int) (Math.random() * arrayView.size());
		System.out.println(locate +"  Data300  "+index+"  "+arrayView.size());
		String name = arrayView.get(index);
		RecordTemp.add(name, emapAction.get(name));
		return name;
	}
	
	public static String SeachHotel(String locate) {
		ArrayList<String> arrayView = new ArrayList<String>();
		for(String name:Hotel.keySet()) {
			HashMap<String,String> temp = Hotel.get(name);
			String key = temp.get("City");
			if(key.contains(locate)) {
				arrayView.add(name);
			}
		}
		int index = (int) (Math.random() * arrayView.size());
		
		String name = "";
		if(index==0) {
			name = "沒有住宿";
		}
		else{
			arrayView.get(index);
			RecordTemp.add(name, emapAction.get(name));
		}
		return name;
	}
	
	public static int WitchData(String name) {
		String Location = "";
		if(emapAction.containsKey(name)) {
			return 1;
		}else if(ODwsvMovingRoad.containsKey(name)) {
			return 2;
		}else if(Activity.containsKey(name)) {
			return 3;
		}else if(FoodShop.containsKey(name)) {
			return 4;
		}else if(Hotel.containsKey(name)) {
			return 5;
		}else {
			return 0;
		}
	}
}
