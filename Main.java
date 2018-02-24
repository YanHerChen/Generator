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
	private static int ThistotalSentence;// �����y��
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
	 * ���]�wRounds�]�w���� �H���ͦ�20~25�B�H�@�������y�Ƥ�]�w
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
					"please input args[0]:Rounds(number type) && args[1]:nowItem in C:\\Users\\River\\Desktop\\��Ѿ����H(�G�H)\\New");
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
			System.out.println(st[2] + " " + st[0] + " " + st[1]);
		}
		System.out.println("\n===========================\n");
		ArrayList<String> NewThing = RecordKeyN.rknarraygetAll();
		for (String st : NewThing)
			System.out.println(st);
		WriteFile();// �g��
	}

	// �g�� //��?newthing?���ηs���a�I�A�H�K�аO
	private static void WriteFile() {
		int i = 0;
		try {
			File file = new File("C:\\Users\\River\\Desktop\\��Ѿ����H(�G�H)\\New\\" + filename + ".txt");// �إ��ɮסA�ǳƼg��
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(file, true), "utf8"));// �]�w��BIG5�榡

			ArrayList<String[]> Record = rl.rlgetAll();
			ArrayList<String> NewThing = RecordKeyN.rknarraygetAll();
			for (String st[] : Record) {
				if (i < RecordKeyN.rknarraySize() && st[0].contains(NewThing.get(i))) {
					writer.write(st[2] + "	" + st[0] + "	" + st[1] + "?newthing?" + NewThing.get(i));
					writer.newLine(); // �g�J����
					i++;
				} else {
					writer.write(st[2] + "	" + st[0] + "	" + st[1]);
					writer.newLine(); // �g�J����
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