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

	// �ثe���o��ƥ���hashmap�A����i��n��linkedhashmap�b���ޤW���ֳt
	public static String[] getFirst() {
		int i = (int) (Math.random() * First.size());
		String[] st = First.get(i);
		
		if (i < 5) {
			System.out.println("�}������:��, �H���y���ѦҡG" + i);
			st[1] = "�^�д��I";
			//�H�����C�ִ��I
			int getindex;
			int type = (int) (Math.random() * (2 - 1 + 1)) + 1;
			switch(type) {
			case 1:
				HashMap<String, HashMap<String, String>> emapAction = Data.getData("emapAction");
				getindex = (int) (Math.random() * emapAction.size());
				int index1 = 0;
				for (String name : emapAction.keySet()) {
					if (index1 == getindex) {
						st[0] = st[0].replace("__", name);
						
						//rknadd���O�̷ӭ������x�s
						RecordKeyN.rknadd(name, 2);
						//arrayadd�O�����b�@�_�s�A�Ӷ���
						RecordKeyN.rknarrayadd(name);
						//Temp.add �O�x�s�Ӵ��I�Ҧ���T
						RecordTemp.add(name, emapAction.get(name));
						//�����������I��m(����)�A�����������̷Ӧ�����
						Data.Searchlocate(name);
						break;
					}
					index1++;
				}
				break;
			case 2:
				HashMap<String, HashMap<String, String>> ODwsvMovingRoad = Data.getData("ODwsvMovingRoad");
				getindex = (int) (Math.random() * ODwsvMovingRoad.size());
				int index2 = 0;
				for (String name : ODwsvMovingRoad.keySet()) {
					if (index2 == getindex) {
						st[0] = st[0].replace("__", name);
						
						//rknadd���O�̷ӭ������x�s
						RecordKeyN.rknadd(name, 2);
						//arrayadd�O�����b�@�_�s�A�Ӷ���
						RecordKeyN.rknarrayadd(name);
						//Temp.add �O�x�s�Ӵ��I�Ҧ���T
						RecordTemp.add(name, ODwsvMovingRoad.get(name));
						//�����������I��m(����)�A�����������̷Ӧ�����
						Data.Searchlocate(name);
						break;
					}
					index2++;
				}
				break;
			}
		} else if (i >= 5 && i < 10) {
			System.out.println("�}������:�Y, �H���y���ѦҡG" + i);
			st[1] = "�^�Э���";
			//�H��������
			HashMap<String, HashMap<String, String>> foodshop = Data.getData("FoodShop");
			int getindex = (int) (Math.random() * foodshop.size());
			int index3 = 0;
			for (String name : foodshop.keySet()) {
				if (index3 == getindex) {
					st[0] = st[0].replace("__", name);
					
					//rknadd���O�̷ӭ������x�s
					RecordKeyN.rknadd(name, 4);
					//arrayadd�O�����b�@�_�s�A�Ӷ���
					RecordKeyN.rknarrayadd(name);
					//Temp.add �O�x�s�Ӵ��I�Ҧ���T
					RecordTemp.add(name, foodshop.get(name));
					//�����������I��m(����)�A�����������̷Ӧ�����
					Data.Searchlocate(name);
					break;
				}
				index3++;
			}
			Recordtype.rtadd("�ݭ���");//�קK���ư�
		} else if(i>=10 && i<15){
			System.out.println("�}������:����, �H���y���ѦҡG" + i);

			st[1] = "�^�Ь���";
			//�H��������
			HashMap<String, HashMap<String, String>> Activity = Data.getData("Activity");
			int getindex = (int) (Math.random() * Activity.size());
			int index4 = 0;
			for (String name : Activity.keySet()) {
				if (index4 == getindex) {
					st[0] = st[0].replace("__", name);

					//rknadd���O�̷ӭ������x�s
					RecordKeyN.rknadd(name, 1);
					//arrayadd�O�����b�@�_�s�A�Ӷ���
					RecordKeyN.rknarrayadd(name);
					//Temp.add �O�x�s�Ӵ��I�Ҧ���T
					RecordTemp.add(name, Activity.get(name));
					//�����������I��m(����)�A�����������̷Ӧ�����
					Data.Searchlocate(name);
					break;
				}
				index4++;
			}
			Recordtype.rtadd("�ݬ���");//�קK���ư�
		} else if(i > 15) {
			System.out.println("�}������:��J, �H���y���ѦҡG" + i);

			st[1] = "�^�Ц�J";
			//�H��������
			HashMap<String, HashMap<String, String>> Hotel = Data.getData("Hotel");
			int getindex = (int) (Math.random() * Hotel.size());
			int index4 = 0;
			for (String name : Hotel.keySet()) {
				if (index4 == getindex) {
					st[0] = st[0].replace("__", name);

					//rknadd���O�̷ӭ������x�s
					RecordKeyN.rknadd(name, 5);
					//arrayadd�O�����b�@�_�s�A�Ӷ���
					RecordKeyN.rknarrayadd(name);
					//Temp.add �O�x�s�Ӵ��I�Ҧ���T
					RecordTemp.add(name, Hotel.get(name));
					//�����������I��m(����)�A�����������̷Ӧ�����
					Data.Searchlocate(name);
					break;
				}
				index4++;
			}
			Recordtype.rtadd("�ݦ�J");//�קK���ư�
		}
		return st;
	}

	public static String[] getEnd() {
		int i = (int) (Math.random() * End.size());
		return End.get(i);
	}

	// ���F�Ϲjplay �� eat�y���A�]�mplay && eat�������ޡA�b�üƥͦ����׶}�C
	private static void ReadFirst() {
		int i = 0;
		String type = "�^�д��I";
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(path + file[0] + "\\" + file[0] + ".txt"), "utf8"));
			while (br.ready()) {
				String brStr = br.readLine();
				if (brStr.equals("��")) {
					type = "�^�д��I";
					play = i;
				} else if (brStr.equals("�Y")) {
					type = "�^�Э���";
					eat = i;
				} else if (brStr.equals("����")) {
					type = "�^�Э���";
					act = i;
				}
				if (i == play || i == eat || i == act) {
				} else {
					String[] stemp = new String[3];
					stemp[0] = brStr;
					stemp[1] = type;
					stemp[2] = "User";
					First.add(stemp);
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void ReadEnd() {
		String type = "�@��y";
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
