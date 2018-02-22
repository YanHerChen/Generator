import java.util.HashMap;

public class RecordTemp {
	// 紀錄每個"人事時地物"
	private static HashMap<String, HashMap<String, String>> Datatemp = new HashMap<String, HashMap<String, String>>();

	RecordTemp() {
		Datatemp = new HashMap<String, HashMap<String, String>>();
	}

	public static void add(String name, HashMap<String, String> ad) {
		Datatemp.put(name, ad);
	}

	/*
	 * Data食衣住行共5類，但是地址的標誌有好幾種(locate、add等)
	 * 另生成句子描述也有好幾種(營業時間、開放時間)
	 */
	public static String get(String name, String type) {
		int witch = Data.WitchData(name);
		HashMap<String,String> inf = Datatemp.get(name);
		String sinf = "";
		
		switch(type) {
		case "回覆開放時間":
			switch(witch) {
			case 1://emapAction
				sinf = inf.get("openTime");
				break;
			case 2://ODwsvMovingRoad
				sinf = "24小時";
				break;
			case 3://Activity
				sinf = inf.get("Start") + "~"+inf.get("End");
				break;
			case 4://FoodShop
				sinf = inf.get("openhour");
				break;
			case 5://Hotel
				sinf = inf.get("24小時");
				break;
			}
			break;
		case "回覆景點資訊":
			switch(witch) {
			case 1:
				sinf = inf.get("type");
				break;
			case 2:
				sinf = inf.get("Feature");
				break;
			case 3:
				sinf = inf.get("Description");
				break;
			case 4:
				sinf = inf.get("description");
				break;
			case 5:
				sinf = inf.get("Description");
				break;
			}
			break;
		case "回覆地點":
			switch(witch) {
			case 1:
				sinf = inf.get("cityName");
				break;
			case 2:
				sinf = inf.get("City");
				break;
			case 3:
				sinf = inf.get("Location");
				break;
			case 4:
				sinf = inf.get("locate");
				break;
			case 5:
				sinf = inf.get("Add");
				break;
			}
			break;
		case "回覆地址":
			switch(witch) {
			case 1:
				sinf = inf.get("address");
				break;
			case 2:
				sinf = inf.get("City")+inf.get("Town");
				break;
			case 3:
				sinf = inf.get("Add");
				break;
			case 4:
				sinf = inf.get("address");
				break;
			case 5:
				sinf = inf.get("Add");
				break;
			}
			break;
		case "回覆食物資訊"://食物特色
			sinf = inf.get("classify");
			break;
		case "回覆價格":
			switch(witch) {
			case 1:
				sinf = inf.get("ticketPrice");
				break;
			case 2:
				sinf = inf.get("Price");
				break;
			case 3:
				sinf = "不用價錢";
				break;
			case 4:
				sinf = inf.get("cost");
				break;
			case 5:
				sinf = inf.get("Spec");
				break;
			}
			break;
		case "回覆特色":
			switch(witch) {
			case 1:
				sinf = inf.get("type");
				break;
			case 2:
				sinf = inf.get("Feature");
				break;
			case 3:
				sinf = inf.get("Description");
				break;
			case 4:
				sinf = inf.get("description");
				break;
			case 5:
				sinf = inf.get("Description");
				break;
			}
			break;
		case "回覆票券資訊":
			switch(witch) {
			case 1:
				sinf = inf.get("ticketPrice");
				break;
			case 2:
				sinf = inf.get("Price");
				break;
			case 3:
				sinf = "不用價錢";
				break;
			case 4:
				sinf = inf.get("cost");
				break;
			case 5:
				sinf = inf.get("Spec");
				break;
			}
			break;
		}
	
		return sinf;
	}
}
