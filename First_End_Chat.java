import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class First_End_Chat {
	private static ArrayList<String[]> First = new ArrayList<String[]>();
	private static ArrayList<String[]> End = new ArrayList<String[]>();
	private static String[] file = { "first", "end" };
	private static String path = "C:\\Users\\River\\Desktop\\Sentence_Generator\\";
	private static int play, eat, act;

	First_End_Chat() {
		First = new ArrayList<String[]>();
		End = new ArrayList<String[]>();
		ReadFirst();
		ReadEnd();
	}

	// 目前取得資料先用hashmap，之後可能要改linkedhashmap在索引上較快速
	public static String[] getFirst() {
		int i = (int) (Math.random() * First.size());
		String[] st = First.get(i);
		
		if (i < 5) {
			System.out.println("開場類型:玩, 隨機句型參考：" + i);
			st[1] = "回覆景點";
			//隨機取遊樂景點
			int getindex;
			int type = (int) (Math.random() * (2 - 1 + 1)) + 1;
			switch(type) {
			case 1:
				HashMap<String, HashMap<String, String>> emapAction = Data.getData("emapAction");
				getindex = (int) (Math.random() * emapAction.size());
				int index1 = 0;
				for (String name : emapAction.keySet()) {
					if (index1 == getindex) {
						st[0] = st[0].replace("__", name);
						
						//rknadd分別依照食衣住行儲存
						RecordKeyN.rknadd(name, 2);
						//arrayadd是全部在一起存，照順序
						RecordKeyN.rknarrayadd(name);
						//Temp.add 是儲存該景點所有資訊
						RecordTemp.add(name, emapAction.get(name));
						//直接紀錄景點位置(縣市)，本場全部都依照此縣市
						Data.Searchlocate(name);
						break;
					}
					index1++;
				}
				break;
			case 2:
				HashMap<String, HashMap<String, String>> ODwsvMovingRoad = Data.getData("ODwsvMovingRoad");
				getindex = (int) (Math.random() * ODwsvMovingRoad.size());
				int index2 = 0;
				for (String name : ODwsvMovingRoad.keySet()) {
					if (index2 == getindex) {
						st[0] = st[0].replace("__", name);
						
						//rknadd分別依照食衣住行儲存
						RecordKeyN.rknadd(name, 2);
						//arrayadd是全部在一起存，照順序
						RecordKeyN.rknarrayadd(name);
						//Temp.add 是儲存該景點所有資訊
						RecordTemp.add(name, ODwsvMovingRoad.get(name));
						//直接紀錄景點位置(縣市)，本場全部都依照此縣市
						Data.Searchlocate(name);
						break;
					}
					index2++;
				}
				break;
			}
		} else if (i >= 5 && i < 10) {
			System.out.println("開場類型:吃, 隨機句型參考：" + i);
			st[1] = "回覆食物";
			//隨機取食物
			HashMap<String, HashMap<String, String>> foodshop = Data.getData("FoodShop");
			int getindex = (int) (Math.random() * foodshop.size());
			int index3 = 0;
			for (String name : foodshop.keySet()) {
				if (index3 == getindex) {
					st[0] = st[0].replace("__", name);
					
					//rknadd分別依照食衣住行儲存
					RecordKeyN.rknadd(name, 4);
					//arrayadd是全部在一起存，照順序
					RecordKeyN.rknarrayadd(name);
					//Temp.add 是儲存該景點所有資訊
					RecordTemp.add(name, foodshop.get(name));
					//直接紀錄景點位置(縣市)，本場全部都依照此縣市
					Data.Searchlocate(name);
					break;
				}
				index3++;
			}
			Recordtype.rtadd("問食物");//避免重複問
		} else if(i>=10 && i<15){
			System.out.println("開場類型:活動, 隨機句型參考：" + i);

			st[1] = "回覆活動";
			//隨機取食物
			HashMap<String, HashMap<String, String>> Activity = Data.getData("Activity");
			int getindex = (int) (Math.random() * Activity.size());
			int index4 = 0;
			for (String name : Activity.keySet()) {
				if (index4 == getindex) {
					st[0] = st[0].replace("__", name);

					//rknadd分別依照食衣住行儲存
					RecordKeyN.rknadd(name, 1);
					//arrayadd是全部在一起存，照順序
					RecordKeyN.rknarrayadd(name);
					//Temp.add 是儲存該景點所有資訊
					RecordTemp.add(name, Activity.get(name));
					//直接紀錄景點位置(縣市)，本場全部都依照此縣市
					Data.Searchlocate(name);
					break;
				}
				index4++;
			}
			Recordtype.rtadd("問活動");//避免重複問
		} else if(i > 15) {
			System.out.println("開場類型:住宿, 隨機句型參考：" + i);

			st[1] = "回覆住宿";
			//隨機取食物
			HashMap<String, HashMap<String, String>> Hotel = Data.getData("Hotel");
			int getindex = (int) (Math.random() * Hotel.size());
			int index4 = 0;
			for (String name : Hotel.keySet()) {
				if (index4 == getindex) {
					st[0] = st[0].replace("__", name);

					//rknadd分別依照食衣住行儲存
					RecordKeyN.rknadd(name, 5);
					//arrayadd是全部在一起存，照順序
					RecordKeyN.rknarrayadd(name);
					//Temp.add 是儲存該景點所有資訊
					RecordTemp.add(name, Hotel.get(name));
					//直接紀錄景點位置(縣市)，本場全部都依照此縣市
					Data.Searchlocate(name);
					break;
				}
				index4++;
			}
			Recordtype.rtadd("問住宿");//避免重複問
		}
		return st;
	}

	public static String[] getEnd() {
		int i = (int) (Math.random() * End.size());
		return End.get(i);
	}

	// 為了區隔play 跟 eat句型，設置play && eat紀錄索引，在亂數生成時避開。
	private static void ReadFirst() {
		int i = 0;
		String type = "回覆景點";
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(path + file[0] + "\\" + file[0] + ".txt"), "utf8"));
			while (br.ready()) {
				String brStr = br.readLine();
				if (brStr.equals("玩")) {
					type = "回覆景點";
					play = i;
				} else if (brStr.equals("吃")) {
					type = "回覆食物";
					eat = i;
				} else if (brStr.equals("活動")) {
					type = "回覆食物";
					act = i;
				}
				if (i == play || i == eat || i == act) {
				} else {
					String[] stemp = new String[3];
					stemp[0] = brStr;
					stemp[1] = type;
					stemp[2] = "User";
					First.add(stemp);
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void ReadEnd() {
		String type = "一般句";
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(path + file[1] + "\\" + file[1] + ".txt"), "utf8"));
			while (br.ready()) {
				String brStr = br.readLine();

				String[] stemp = new String[3];
				stemp[0] = brStr;
				stemp[1] = type;
				stemp[2] = "Robot";
				End.add(stemp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
