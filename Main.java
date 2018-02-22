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
	 * ���]�wRounds�]�w���� �H���ͦ�20~25�B�H�@�������y�Ƥ�]�w
	 */
	public static void main(String[] args) {

		Rounds = Integer.valueOf(20);

		for (int r = 0; r < Rounds; r++) {
			Main m = new Main();
		}
	}

	private static void Start() {
		fec = new First_End_Chat();

		// �üƲ�thistotalsentence
		ThistotalSentence = (int) (Math.random() * (25 - 20 + 1)) + 20;
		System.out.println("������ܼơG" + ThistotalSentence);

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
				System.out.println("���ƨ��˼ƲĤG�y " + finalz[0] + " " + finalz[2]);
				if (!finalz[0].contains("?") && finalz[2].equals("User"))
					break;
			}
		}

		FinalSpeech();

		Write();
	}

	/*
	 * pre[0]:�y�l �Apre[1]:����(�ݡB�^��)�Apre[2]:���ܪ�(User�BRobot)
	 */
	private static void HowToReply() {
		// �W�@�y���^�Ъ̡B���e�B����
		String[] pre = rl.rlget(rl.rlSize());
		switch (pre[2]) {
		case "User":
			// ���]�W�@�y��User�A�i�J�P�_User�^�к����B�åB����Robot�^�Ъ�����
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
	 * �^�Цa�} �n�אּ �^�Щ��a��T
	 */
	private static void Write() {
		System.out.println();
		ArrayList<String[]> Record = rl.rlgetAll();
		for (String st[] : Record) {
			System.out.println(st[2] + " " + st[0] + " (" + st[1] + ")");
		}
		System.out.println("\n===========================\n");
		rl.rlclear();
	}

}
