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
	}

	private static void Afilename() {
		File f = new File(path + "�ϥΪ̦^��");
		File[] f1 = f.listFiles();
		for (int i = 0; i < f.listFiles().length; i++)
			Afname.add(f1[i].getName());
		ReadAnswer();
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
			temp.clear();
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
		// �B�ztype�A�^�к����A�קK����
		int typeindex = (int) (Math.random() * type.length);
		String ReplyType = type[typeindex];
		if (Recordtype.contain(ReplyType)) {
			for (String name : type) {
				if (!Recordtype.contain(name))
					ReplyType = name;
			}
		}

		// ���������y�l�A�H������y�l
		ArrayList<String> ArrayQuestion = Question.get(ReplyType + ".txt");
		int index = (int) (Math.random() * ArrayQuestion.size());

		String[] Reply = new String[3];
		Reply[0] = ArrayQuestion.get(index).replace("__", RecordKeyN.rknarrayget((RecordKeyN.rknSize() - 1)));
		Reply[1] = ReplyType;
		Reply[2] = "User";
		Recordtype.rtadd(ReplyType);

		return Reply;
	}

	public static String getRandomAnswer(String type) {
		ArrayList<String> ArrayAnswer = Answer.get(type + ".txt");
		int index = (int) (Math.random() * ArrayAnswer.size());
		
		String Reply = "";
		if (type.contains("����")) {
			String view = RecordKeyN.rknget(4);
			String food = Data.SearchFooshop(Data.SearchViewlocate(view));
			Reply = ArrayAnswer.get(index).replace("__", food);
		} else if (type.contains("����")) {
			String view = RecordKeyN.rknget(1);
			String Act = Data.SearchAct(Data.SearchViewlocate(view));
			Reply = ArrayAnswer.get(index).replace("__", Act);
		} else if (type.contains("���I") || type.contains("��{") ) {
			String view = RecordKeyN.rknget(1);
			String Act = Data.SeachView(Data.SearchViewlocate(view));
			Reply = ArrayAnswer.get(index).replace("__", Act);
		} else {
			Reply = ArrayAnswer.get(index).replace("__", RecordKeyN.rknarrayget(RecordKeyN.rknSize()-1));
		}

		return Reply;
	}
}
