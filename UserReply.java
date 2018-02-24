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
		Readbachitalk();
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

	private static void Readbachitalk() {
		String bachitalk = "����.txt";
		ArrayList<String> temp = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(path + "����\\����.txt"), "utf8"));
			while (br.ready()) {
				String brStr = br.readLine();
				temp.add(brStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Question.put(bachitalk, temp);
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
		System.out.print(" UR103"+ReplyType+" ");
		ArrayList<String> ArrayQuestion = Question.get(ReplyType + ".txt");
		System.out.println(ArrayQuestion.size());
		int index = (int) (Math.random() * ArrayQuestion.size());

		//�P�_���D�����A�j�M�۹����a��W��
		String QuestopnArea = "";
		if(ReplyType.contains("���I")) {// RKN�s�X1 or 2(�ثe�Τ@��2)
			QuestopnArea = RecordKeyN.rknget(2);
		}else if(ReplyType.contains("����")) {// RKN�s�X4
			QuestopnArea = RecordKeyN.rknget(4);
		}else if(ReplyType.contains("����")) {// RKN�s�X3
			QuestopnArea = RecordKeyN.rknget(3);
		}else if(ReplyType.contains("��J")) {// RKN�s�X5
			QuestopnArea = RecordKeyN.rknget(5);
		}else {
			QuestopnArea = RecordKeyN.RandomGetRecord();
			//QuestopnArea = RecordKeyN.rknarrayget(RecordKeyN.rknarraySize()-1);
		}
		
		String[] Reply = new String[3];
		Reply[0] = ArrayQuestion.get(index).replace("__", QuestopnArea);
		Reply[1] = ReplyType;
		Reply[2] = "User";
		// �@��y�i�H����
		if (ReplyType.equals("�@��y")) {
		} else
			Recordtype.rtadd(ReplyType);

		return Reply;
	}

	// �j�M�w�s�b����ơA���j�M���GReply���šA�N��L��(���I/����/��J/�������a)��ơA�h�H���s�W�@��(���I/����/��J/�������a)���
	public static String getRandomAnswer(String type) {
		ArrayList<String> ArrayAnswer = Answer.get(type + ".txt");
		int index = (int) (Math.random() * ArrayAnswer.size());

		String Reply = "";
		if (type.contains("����") && !type.contains("��T")) {
			String foodcode = RecordKeyN.rknget(4);// RKN�s�X4
			String food = Data.SearchFooshop(Data.getLocation());// �W��

			Reply = RecordTemp.get(food, type);// ���o�ԲӸ�T

			// �p�G������ܵL�����a�I�A�H���s�W�B���x�s��RecordKeyN.rknadd
			if (Reply == "") {
				Reply = ArrayAnswer.get(index).replace("__", food);
				RecordKeyN.rknadd(food, 4);
				RecordKeyN.rknarrayadd(food);//�s�W�s�a�I
			}
		} else if (type.contains("����") && !type.contains("��T")) {
			String actcode = RecordKeyN.rknget(3);// RKN�s�X3
			String Act = Data.SearchAct(Data.getLocation());// �W��

			Reply = RecordTemp.get(Act, type);// ���o�ԲӸ�T

			// �p�G������ܵL���ʦa�I�A�H���s�W�B���x�s��RecordKeyN.rknadd
			if (Reply == "") {
				Reply = ArrayAnswer.get(index).replace("__", Act);
				RecordKeyN.rknadd(Act, 3);
				RecordKeyN.rknarrayadd(Act);//�s�W�s�a�I
			}
		} else if (type.contains("���I") && !type.contains("��T") || type.contains("��{")) {
			int code = (int) (Math.random() * 2);
			String viewcode = RecordKeyN.rknget(code);// RKN�s�X1 or 2
			String sview = Data.SeachView(Data.getLocation());// �W��

			Reply = RecordTemp.get(sview, type);// ���o�ԲӸ�T

			// �p�G������ܵL���I�a�I�A�H���s�W�B���x�s��RecordKeyN.rknadd
			if (Reply == "") {
				Reply = ArrayAnswer.get(index).replace("__", sview);
				RecordKeyN.rknadd(sview, code);
				RecordKeyN.rknarrayadd(sview);//�s�W�s�a�I
			}
		} else if (type.contains("��J") && !type.contains("��T")) {
			String roomcode = RecordKeyN.rknget(5);// RKN�s�X5
			String room = Data.SeachHotel(Data.getLocation());// �W��

			Reply = RecordTemp.get(room, type);// ���o�ԲӸ�T

			// �p�G������ܵL��J�a�I�A�H���s�W�B���x�s��RecordKeyN.rknadd
			if (Reply == "") {
				Reply = ArrayAnswer.get(index).replace("__", room);
				RecordKeyN.rknadd(room, 5);
				RecordKeyN.rknarrayadd(room);//�s�W�s�a�I
			}
		} else {
			String name = RecordKeyN.rknarrayget(RecordKeyN.rknarraySize() - 1);
			if (type.contains("�}��ɶ�"))
				Reply = RecordTemp.get(name, type);
			else if (type.contains("�a�I"))
				Reply = RecordTemp.get(name, type);
			else if (type.contains("�a�}"))
				Reply = RecordTemp.get(name, type);
			else if (type.contains("����"))
				Reply = RecordTemp.get(name, type);
			else if (type.contains("��J��T")) {
				name = RecordKeyN.rknget(5);
				Reply = RecordTemp.get(name, type);
			}else if (type.contains("���ʸ�T")) {
				name = RecordKeyN.rknget(3);
				Reply = RecordTemp.get(name, type);
			}else if (type.contains("������T")) {
				name = RecordKeyN.rknget(4);
				Reply = RecordTemp.get(name, type);
			}else if (type.contains("���I��T")) {
				name = RecordKeyN.rknget(2);
				Reply = RecordTemp.get(name, type);
				System.out.println("***********UR225*************");
			}
			if (Reply == "")
				Reply = ArrayAnswer.get(index).replace("__", name);
		}

		return Reply;
	}
}
