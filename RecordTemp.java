import java.util.HashMap;

public class RecordTemp {
	// 紀錄每個"人事時地物"，進行(景點、活動、食物店家、住宿)詳細資訊查詢
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
				sinf = "可能要打電話去問，電話是"+inf.get("Tel");;
				break;
			}
			break;
		case "回覆景點資訊":
			sinf = "是"+inf.get("type")+"很特別";
			if(sinf.length()<6)
				sinf = inf.get("Feature");
			break;
		case "回覆活動資訊":
				sinf = inf.get("Description");
			break;
		case "回覆住宿資訊":
				sinf = "風景很漂亮"+inf.get("Description");
				if(sinf.length()<8) {
					sinf="可能要到官方網站查詢喔!";
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
				if(sinf.length()<3)
					sinf = inf.get("Location");
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
			sinf = inf.get("description");
			break;
		case "回覆價位":
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
				if(sinf==" ")
					sinf = "不知道，可能要打電話過去問";
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
