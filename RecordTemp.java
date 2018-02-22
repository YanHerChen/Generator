import java.util.HashMap;

public class RecordTemp {
	// �����C��"�H�Ʈɦa��"
	private static HashMap<String, HashMap<String, String>> Datatemp = new HashMap<String, HashMap<String, String>>();

	RecordTemp() {
		Datatemp = new HashMap<String, HashMap<String, String>>();
	}

	public static void add(String name, HashMap<String, String> ad) {
		Datatemp.put(name, ad);
	}

	/*
	 * Data������@5���A���O�a�}���лx���n�X��(locate�Badd��)
	 * �t�ͦ��y�l�y�z�]���n�X��(��~�ɶ��B�}��ɶ�)
	 */
	public static String get(String name, String type) {
		int witch = Data.WitchData(name);
		HashMap<String,String> inf = Datatemp.get(name);
		String sinf = "";
		
		switch(type) {
		case "�^�ж}��ɶ�":
			switch(witch) {
			case 1://emapAction
				sinf = inf.get("openTime");
				break;
			case 2://ODwsvMovingRoad
				sinf = "24�p��";
				break;
			case 3://Activity
				sinf = inf.get("Start") + "~"+inf.get("End");
				break;
			case 4://FoodShop
				sinf = inf.get("openhour");
				break;
			case 5://Hotel
				sinf = inf.get("24�p��");
				break;
			}
			break;
		case "�^�д��I��T":
			switch(witch) {
			case 1:
				sinf = inf.get("type");
				break;
			case 2:
				sinf = inf.get("Feature");
				break;
			case 3:
				sinf = inf.get("Description");
				break;
			case 4:
				sinf = inf.get("description");
				break;
			case 5:
				sinf = inf.get("Description");
				break;
			}
			break;
		case "�^�Цa�I":
			switch(witch) {
			case 1:
				sinf = inf.get("cityName");
				break;
			case 2:
				sinf = inf.get("City");
				break;
			case 3:
				sinf = inf.get("Location");
				break;
			case 4:
				sinf = inf.get("locate");
				break;
			case 5:
				sinf = inf.get("Add");
				break;
			}
			break;
		case "�^�Цa�}":
			switch(witch) {
			case 1:
				sinf = inf.get("address");
				break;
			case 2:
				sinf = inf.get("City")+inf.get("Town");
				break;
			case 3:
				sinf = inf.get("Add");
				break;
			case 4:
				sinf = inf.get("address");
				break;
			case 5:
				sinf = inf.get("Add");
				break;
			}
			break;
		case "�^�Э�����T"://�����S��
			sinf = inf.get("classify");
			break;
		case "�^�л���":
			switch(witch) {
			case 1:
				sinf = inf.get("ticketPrice");
				break;
			case 2:
				sinf = inf.get("Price");
				break;
			case 3:
				sinf = "���λ���";
				break;
			case 4:
				sinf = inf.get("cost");
				break;
			case 5:
				sinf = inf.get("Spec");
				break;
			}
			break;
		case "�^�ЯS��":
			switch(witch) {
			case 1:
				sinf = inf.get("type");
				break;
			case 2:
				sinf = inf.get("Feature");
				break;
			case 3:
				sinf = inf.get("Description");
				break;
			case 4:
				sinf = inf.get("description");
				break;
			case 5:
				sinf = inf.get("Description");
				break;
			}
			break;
		case "�^�в����T":
			switch(witch) {
			case 1:
				sinf = inf.get("ticketPrice");
				break;
			case 2:
				sinf = inf.get("Price");
				break;
			case 3:
				sinf = "���λ���";
				break;
			case 4:
				sinf = inf.get("cost");
				break;
			case 5:
				sinf = inf.get("Spec");
				break;
			}
			break;
		}
	
		return sinf;
	}
}
