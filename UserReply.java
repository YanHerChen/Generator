import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class UserReply {
	private static HashMap<String, ArrayList<String>> Question = new HashMap<String, ArrayList<String>>();
	private static HashMap<String, ArrayList<String>> Answer = new HashMap<String, ArrayList<String>>();
	private static ArrayList<String> Qfname = new ArrayList<String>();
	private static ArrayList<String> Afname = new ArrayList<String>();
	private static String path = "C:\\Users\\River\\Desktop\\Sentence_Generator\\";

	// ��class��Ū��User��Ƨ����Ҧ��^�СB���D���A�H�K���^��
	UserReply() {
		Qfilename();
		Afilename();
	}

	private static void Qfilename() {
		File f = new File(path + "�ϥΪ̰�");
		File[] f1 = f.listFiles();
		for (int i = 0; i < f.listFiles().length; i++)
			Qfname.add(f1[i].getName());
		ReadQuestion();
		ReadNormal();
	}

	private static void Afilename() {
		File f = new File(path + "�ϥΪ̦^��");
		File[] f1 = f.listFiles();
		for (int i = 0; i < f.listFiles().length; i++)
			Afname.add(f1[i].getName());
		ReadAnswer();
	}

	private static void ReadNormal() {
		String normal = "�@��y.txt";
		ArrayList<String> temp = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(path + "�ϥΪ̤@��y\\�@��y.txt"), "utf8"));
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
						new InputStreamReader(new FileInputStream(path + "�ϥΪ̰�\\" + fn), "utf8"));
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
						new InputStreamReader(new FileInputStream(path + "�ϥΪ̦^��\\" + fn), "utf8"));
				while (br.ready()) {
					String brStr = br.readLine();
					temp.add(brStr);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			Answer.put(fn, temp);
		}
		ArrayList<String> tt = Answer.get("�^�Ь���.txt");
	}

	public static String[] getRandomQuestion(String[] type) {
		int typeindex = (int) (Math.random() * type.length);
		String ReplyType = type[typeindex];

		// �p�G���D�����w�g�X�{�L�A�N���s���üơA�H������
		if (Recordtype.contain(ReplyType))
			do {
				int repeat = (int) (Math.random() * type.length);
				ReplyType = type[repeat];
			} while (Recordtype.contain(ReplyType));

		// ���������y�l�A�H������y�l
		ArrayList<String> ArrayQuestion = Question.get(ReplyType + ".txt");
		int index = (int) (Math.random() * ArrayQuestion.size());

		String[] Reply = new String[3];
		Reply[0] = ArrayQuestion.get(index).replace("__", RecordKeyN.rknarrayget(RecordKeyN.rknSize()-1));
		Reply[1] = ReplyType;
		Reply[2] = "User";
		//�@��y�i�H����
		if(ReplyType.equals("�@��y")) {}
		else
			Recordtype.rtadd(ReplyType);

		return Reply;
	}

	public static String getRandomAnswer(String type) {
		ArrayList<String> ArrayAnswer = Answer.get(type + ".txt");
		int index = (int) (Math.random() * ArrayAnswer.size());

		String Reply = "";
		if (type.contains("����")) {
			String view = RecordKeyN.rknget(4);// RKN�s�X4
			String food = Data.SearchFooshop(Data.SearchViewlocate(view));// �W��
			
			Reply = RecordTemp.get(food, type);// ���o�ԲӸ�T
			if (Reply == "")
				Reply = ArrayAnswer.get(index).replace("__", food);
		} else if (type.contains("����")) {
			String view = RecordKeyN.rknget(3);// RKN�s�X3
			String Act = Data.SearchAct(Data.SearchViewlocate(view));// �W��
			
			Reply = RecordTemp.get(Act, type);// ���o�ԲӸ�T
			if (Reply == "")
				Reply = ArrayAnswer.get(index).replace("__", Act);
		} else if (type.contains("���I") || type.contains("��{")) {
			int code = (int) (Math.random() * 2);
			String view = RecordKeyN.rknget(code);// RKN�s�X1 or 2
			String sview = Data.SeachView(Data.SearchViewlocate(view));// �W��
			
			Reply = RecordTemp.get(sview, type);// ���o�ԲӸ�T
			if (Reply == "")
				Reply = ArrayAnswer.get(index).replace("__", sview);
		} else if (type.contains("��J")) {
			String view = RecordKeyN.rknget(5);// RKN�s�X5
			String sview = Data.SeachHotel(Data.SearchViewlocate(view));// �W��
			
			Reply = RecordTemp.get(sview, type);// ���o�ԲӸ�T
			if (Reply == "")
				Reply = ArrayAnswer.get(index).replace("__", sview);
		} else {
			String name = RecordKeyN.rknarrayget(RecordKeyN.rknSize()-1);
			if (type.contains("�}��ɶ�"))
				Reply = RecordTemp.get(name, type);
			else if (type.contains("�a�I"))
				Reply = RecordTemp.get(name, type);
			else if (type.contains("�a�}"))
				Reply = RecordTemp.get(name, type);
			if (Reply == "")
				Reply = ArrayAnswer.get(index).replace("__", name);
		}

		return Reply;
	}
}
