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
		if (i == eat || i == play)
			i++;

		String[] st = First.get(i);
		if (i < eat) {
			HashMap<String, HashMap<String, String>> emapAction = Data.getData("emapAction");
			System.out.println("開場類型:玩, 隨機句型參考：" + i);
			int getindex = (int) (Math.random() * emapAction.size());
			int index = 0;
			for (String name : emapAction.keySet()) {
				if (index == getindex) {
					st[0] = st[0].replace("__", name);
					RecordKeyN.rknadd(name,2);
					RecordKeyN.rknarrayadd(name);
					break;
				}
				index++;
			}
		} else if (i > eat && i < act) {
			System.out.println("開場類型:吃, 隨機句型參考：" + i);
			HashMap<String, HashMap<String, String>> foodshop = Data.getData("FoodShop");
			int getindex = (int) (Math.random() * foodshop.size());
			int index = 0;
			for (String name : foodshop.keySet()) {
				if (index == getindex) {
					st[0] = st[0].replace("__", name);
					RecordKeyN.rknadd(name,4);
					RecordKeyN.rknarrayadd(name);
					break;
				}
				index++;
			}
		} else {
			System.out.println("開場類型:活動, 隨機句型參考：" + i);
			HashMap<String, HashMap<String, String>> Activity = Data.getData("Activity");
			int getindex = (int) (Math.random() * Activity.size());
			int index = 0;
			for (String name : Activity.keySet()) {
				if (index == getindex) {
					st[0] = st[0].replace("__", name);
					RecordKeyN.rknadd(name,1);
					RecordKeyN.rknarrayadd(name);
					break;
				}
				index++;
			}
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
				String[] stemp = new String[3];
				stemp[0] = brStr;
				stemp[1] = type;
				stemp[2] = "User";
				First.add(stemp);
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
