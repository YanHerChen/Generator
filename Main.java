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
	private static int ThistotalSentence;// �����y��
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
	 * ���]�wRounds�]�w���� �H���ͦ�15~20�B�H�@�������y�Ƥ�]�w
	 */
	public static void main(String[] args) {
		Main m = new Main();
	}

	private static void Start() {
		Rounds = Integer.valueOf(1);

		for (int r = 0; r < Rounds; r++) {
			fec = new First_End_Chat();

			// �üƲ�thistotalsentence
			ThistotalSentence = (int) (Math.random() * (20 - 15 + 1)) + 15;
			System.out.println("������ܼơG" + ThistotalSentence);

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
	 * pre[0]:�y�l �Apre[1]:����(�ݡB�^��)�Apre[2]:���ܪ�(User�BRobot)
	 */
	private static void HowToReply() {
		// �W�@�y���^�Ъ̡B���e�B����
		String[] pre = rl.rlget(rl.rlSize() - 1);
		switch (pre[2]) {
		case "User":
			// ���]�W�@�y��User�A�i�J�P�_User�^�к����B�åB����Robot�^�Ъ�����
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
