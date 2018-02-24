import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	private static Data data;
	private static User user;
	private static Robot robot;
	private static UserReply userReply;
	private static RobotReply robotReply;
	private static RecordList rl;
	private static RecordKeyN rkn;
	private static Recordtype rt;
	private static First_End_Chat fec;
	private static int ThistotalSentence;// 本場句數
	private static int Rounds;
	private static int filename;

	Main(int filename) {
		data = new Data();
		user = new User();
		robot = new Robot();
		userReply = new UserReply();
		robotReply = new RobotReply();
		rl = new RecordList();
		rkn = new RecordKeyN();
		rt = new Recordtype();
		this.filename = filename;
		Start();
	}

	/*
	 * 先設定Rounds設定場數 隨機生成20~25、以作為本場句數支設定
	 */
	public static void main(String[] args) {

		int now = 0;
		try {
			now = Integer.valueOf(0);// args[1]);

			Rounds = Integer.valueOf(16);// args[0]);
			for (int r = 1; r <= Rounds; r++) {
				Main m = new Main(r + now);
			}
		} catch (Exception e) {
			System.out.println(
					"please input args[0]:Rounds(number type) && args[1]:nowItem in C:\\Users\\River\\Desktop\\聊天機器人(二人)\\New");
		}
	}

	private static void Start() {
		fec = new First_End_Chat();

		// 亂數產thistotalsentence
		ThistotalSentence = (int) (Math.random() * (25 - 20 + 1)) + 20;
		System.out.println("本場對話數：" + ThistotalSentence);

		FirstSpeech();
		for (int i = 0; i < ThistotalSentence; i++) {
			HowToReply();
		}

		ArrayList<String[]> Record = rl.rlgetAll();
		String[] finalz = Record.get(Record.size() - 1);
		if (finalz[0].contains("?") || !finalz[2].equals("User")) {
			while (true) {
				HowToReply();
				Record = rl.rlgetAll();
				finalz = Record.get(Record.size() - 1);
				System.out.println("重複取倒數第二句 " + finalz[0] + " " + finalz[2]);
				if (!finalz[0].contains("?") && finalz[2].equals("User"))
					break;
			}
		}

		FinalSpeech();
		Write();
	}

	/*
	 * pre[0]:句子 ，pre[1]:種類(問、回覆)，pre[2]:說話者(User、Robot)
	 */
	private static void HowToReply() {
		// 上一句的回覆者、內容、種類
		String[] pre = rl.rlget(rl.rlSize());
		switch (pre[2]) {
		case "User":
			// 假設上一句為User，進入判斷User回覆種類、並且指派Robot回覆的種類
			String[] Useradd = user.UserSelect(pre[1]);
			rl.rladd(Useradd);
			break;
		case "Robot":
			String[] Robotadd = robot.RobotSelect(pre[1]);
			rl.rladd(Robotadd);
			break;
		default:
			System.out.println("Main777 ?");
			break;
		}
	}

	private static void FirstSpeech() {
		String[] first = fec.getFirst();
		first[2] = "User";
		rl.rladd(first);
	}

	private static void FinalSpeech() {
		String[] first = fec.getEnd();
		rl.rladd(first);
	}

	/*
	 * 回覆地址 要改為 回覆店家資訊
	 */
	private static void Write() {
		System.out.println();
		ArrayList<String[]> Record = rl.rlgetAll();
		for (String st[] : Record) {
			System.out.println(st[2] + " " + st[0] + " " + st[1]);
		}
		System.out.println("\n===========================\n");
		ArrayList<String> NewThing = RecordKeyN.rknarraygetAll();
		for (String st : NewThing)
			System.out.println(st);
		WriteFile();// 寫檔
	}

	// 寫檔 //用?newthing?分割新的地點，以便標記
	private static void WriteFile() {
		int i = 0;
		try {
			File file = new File("C:\\Users\\River\\Desktop\\聊天機器人(二人)\\New\\" + filename + ".txt");// 建立檔案，準備寫檔
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(file, true), "utf8"));// 設定為BIG5格式

			ArrayList<String[]> Record = rl.rlgetAll();
			ArrayList<String> NewThing = RecordKeyN.rknarraygetAll();
			for (String st[] : Record) {
				if (i < RecordKeyN.rknarraySize() && st[0].contains(NewThing.get(i))) {
					writer.write(st[2] + "	" + st[0] + "	" + st[1] + "?newthing?" + NewThing.get(i));
					writer.newLine(); // 寫入換行
					i++;
				} else {
					writer.write(st[2] + "	" + st[0] + "	" + st[1]);
					writer.newLine(); // 寫入換行
				}
			}

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rl.rlclear();
	}
}