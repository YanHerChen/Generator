import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class RobotReply {
	private static HashMap<String, ArrayList<String>> Question = new HashMap<String, ArrayList<String>>();
	private static HashMap<String, ArrayList<String>> Answer = new HashMap<String, ArrayList<String>>();
	private static ArrayList<String> Qfname = new ArrayList<String>();
	private static ArrayList<String> Afname = new ArrayList<String>();
	private static String path = "C:\\Users\\River\\Desktop\\Sentence_Generator\\";

	// 此class需讀取Robot資料夾的所有回覆、問題等，以便做回應
	RobotReply() {
		Qfilename();
		Afilename();
	}

	private static void Qfilename() {
		File f = new File(path + "機器人問");
		File[] f1 = f.listFiles();
		for (int i = 0; i < f.listFiles().length; i++)
			Qfname.add(f1[i].getName());
		ReadQuestion();
		ReadNormal();
	}

	private static void Afilename() {
		File f = new File(path + "機器人回覆");
		File[] f1 = f.listFiles();
		for (int i = 0; i < f.listFiles().length; i++)
			Afname.add(f1[i].getName());
		ReadAnswer();
	}

	private static void ReadNormal() {
		String normal = "一般句.txt";
		ArrayList<String> temp = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(path + "機器人一般句\\一般句.txt"), "utf8"));
			while (br.ready()) {
				String brStr = br.readLine();
				temp.add(brStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Question.put(normal, temp);
	}

	private static void ReadQuestion() {
		String line;
		for (String fn : Qfname) {
			ArrayList<String> temp = new ArrayList<String>();
			try {
				BufferedReader br = new BufferedReader(
						new InputStreamReader(new FileInputStream(path + "機器人問\\" + fn), "utf8"));
				while (br.ready()) {
					String brStr = br.readLine();
					temp.add(brStr);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			Question.put(fn, temp);
		}
	}

	private static void ReadAnswer() {
		String line;
		for (String fn : Afname) {
			ArrayList<String> temp = new ArrayList<String>();
			try {
				BufferedReader br = new BufferedReader(
						new InputStreamReader(new FileInputStream(path + "機器人回覆\\" + fn), "utf8"));
				while (br.ready()) {
					String brStr = br.readLine();
					temp.add(brStr);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			Answer.put(fn, temp);
		}
	}

	public static String[] getRandomQuestion(String[] type) {
		int typeindex = (int) (Math.random() * type.length);
		String ReplyType = type[typeindex];

		// 如果問題種類已經出現過，就重新取亂數，隨機產生
		if (Recordtype.contain(ReplyType))
			do {
				int repeat = (int) (Math.random() * type.length);
				ReplyType = type[repeat];
			} while (Recordtype.contain(ReplyType));

		ArrayList<String> ArrayQuestion = Question.get(ReplyType + ".txt");
		int index = (int) (Math.random() * ArrayQuestion.size());

		// 判斷問題種類，搜尋相對應地方名稱
		String QuestopnArea = "";
		if (ReplyType.contains("景點")) {// RKN編碼1 or 2(目前統一取2)
			QuestopnArea = RecordKeyN.rknget(2);
		} else if (ReplyType.contains("食物")) {// RKN編碼4
			QuestopnArea = RecordKeyN.rknget(4);
		} else if (ReplyType.contains("活動")) {// RKN編碼3
			QuestopnArea = RecordKeyN.rknget(3);
		} else if (ReplyType.contains("住宿")) {// RKN編碼5
			QuestopnArea = RecordKeyN.rknget(5);
		} else {
			QuestopnArea = RecordKeyN.RandomGetRecord();
			//QuestopnArea = RecordKeyN.rknarrayget(RecordKeyN.rknarraySize() - 1);
		}

		String[] Reply = new String[3];
		Reply[0] = ArrayQuestion.get(index).replace("__", QuestopnArea);
		Reply[1] = ReplyType;
		Reply[2] = "Robot";
		// 一般句可以重複
		if (ReplyType.equals("一般句")) {
		} else
			Recordtype.rtadd(ReplyType);

		return Reply;
	}

	public static String getRandomAnswer(String type) {
		ArrayList<String> ArrayAnswer = Answer.get(type + ".txt");
		int index = (int) (Math.random() * ArrayAnswer.size());

		String Reply = "";
		if (type.contains("食物")) {
			String foodcord = RecordKeyN.rknget(4);// RKN編碼4
			String food = Data.SearchFooshop(Data.getLocation());// 名稱

			Reply = RecordTemp.get(food, type);// 取得詳細資訊
			if (Reply == "") {
				Reply = ArrayAnswer.get(index).replace("__", food);
				RecordKeyN.rknadd(food, 4);
				RecordKeyN.rknarrayadd(food);//新增新地點
			}
		} else if (type.contains("活動")) {
			String Actcode = RecordKeyN.rknget(3);// RKN編碼1
			String Act = Data.SearchFooshop(Data.getLocation());// 名稱

			Reply = RecordTemp.get(Act, type);// 取得詳細資訊
			if (Reply == "") {
				Reply = ArrayAnswer.get(index).replace("__", Act);
				RecordKeyN.rknadd(Act, 3);
				RecordKeyN.rknarrayadd(Act);//新增新地點
			}
		} else if (type.contains("景點") && !type.contains("資訊") || type.contains("行程")) {
			int code = (int) (Math.random() * 2);
			String viewcode = RecordKeyN.rknget(code);// RKN編碼1 or 2
			String view = Data.SeachView(Data.getLocation());// 名稱

			Reply = RecordTemp.get(view, type);// 取得詳細資訊
			if (Reply == "") {
				Reply = ArrayAnswer.get(index).replace("__", view);
				RecordKeyN.rknadd(view, 2);
				RecordKeyN.rknarrayadd(view);//新增新地點
			}
		} else {
			String name = RecordKeyN.rknarrayget(RecordKeyN.rknarraySize() - 1);
			if (type.contains("開放時間"))
				Reply = RecordTemp.get(name, type);
			else if (type.contains("地點"))
				Reply = RecordTemp.get(name, type);
			else if (type.contains("地址"))
				Reply = RecordTemp.get(name, type);
			else if (type.contains("景點資訊")) {
				name = RecordKeyN.rknget(2);
				Reply = RecordTemp.get(name, type);
				System.out.println("***********RR175*************");
			}
			if (Reply == "")
				Reply = ArrayAnswer.get(index).replace("__", name);
		}
		return Reply;
	}
}
