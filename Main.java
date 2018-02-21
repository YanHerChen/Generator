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

	Main() {
		data = new Data();
		user = new User();
		robot = new Robot();
		userReply = new UserReply();
		robotReply = new RobotReply();
		rl = new RecordList();
		rkn = new RecordKeyN();
		rt = new Recordtype();
		Start();
	}

	/*
	 * 先設定Rounds設定場數 隨機生成15~20、以作為本場句數支設定
	 */
	public static void main(String[] args) {
		Main m = new Main();
	}

	private static void Start() {
		Rounds = Integer.valueOf(1);

		for (int r = 0; r < Rounds; r++) {
			fec = new First_End_Chat();

			// 亂數產thistotalsentence
			ThistotalSentence = (int) (Math.random() * (20 - 15 + 1)) + 15;
			System.out.println("本場對話數：" + ThistotalSentence);

			FirstSpeech();
			for (int i = 0; i < ThistotalSentence; i++) {
				HowToReply();
			}
			FinalSpeech();

			Write();
			rl.rlclear();
		}
	}

	/*
	 * pre[0]:句子 ，pre[1]:種類(問、回覆)，pre[2]:說話者(User、Robot)
	 */
	private static void HowToReply() {
		// 上一句的回覆者、內容、種類
		String[] pre = rl.rlget(rl.rlSize() - 1);
		switch (pre[2]) {
		case "User":
			// 假設上一句為User，進入判斷User回覆種類、並且指派Robot回覆的種類
			String[] t = user.UserSelect(pre[1]);
			rl.rladd(t);
			break;
		case "Robot":
			String[] tt = robot.RobotSelect(pre[1]);
			rl.rladd(tt);
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

	private static void Write() {
		System.out.println();
		ArrayList<String[]> Record = rl.rlgetAll();
		for (String st[] : Record)
			System.out.println(st[0] + " (" + st[1] + "/" + st[2] + ")");
		System.out.println("\n===========================\n");
	}
}
