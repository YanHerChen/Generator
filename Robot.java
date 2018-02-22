import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Robot {
	// ������Robot���ܧY�i�I�s��class�A�åB����User�^��
	public static String[] RobotSelect(String type) {
		System.out.println("Robot "+type);
		if (type.contains("�^��"))
			return RobotReply(type);
		else if (type.contains("��"))
			return RobotQuestion(type);
		else
			return normal(type);

	}
	
	private static String[] normal(String type) {
		String ReplyType;
		String Reply[] = null;
		String[] normaltype = {"�ݦa�I","�ݦa�}","�ݭ���","�ݴ��I","�ݴ��I��T","�ݶ}��ɶ�"};

		return UserReply.getRandomQuestion(normaltype);
	}
	
	//�ﶵ��Robot���ܺ����A�ﶵ���e������User�^��
	private static String[] RobotReply(String type) {
		String RepyType;
		String[] Reply = null;
		int index;
		switch (type) {
		case "�^�Цa�}":
			String[] locates = { "�ݦa�I", "�ݭ���", "�ݶ}��ɶ�", "�ݴ��I��T", "�@��y" };
			Reply = UserReply.getRandomQuestion(locates);
			break;
		case "�^�Щ��a��T":
			String[] shop = { "�ݦa�}", "�ݦa�I", "�ݭ���", "�ݶ}��ɶ�", "�ݴ��I��T", "�@��y" };
			Reply = UserReply.getRandomQuestion(shop);
			break;
		case "�^�Цa�I":
			String[] locat = { "�ݦa�}", "�ݶ}��ɶ�", "�ݴ��I", "�ݴ��I��T", "�@��y" };
			Reply = UserReply.getRandomQuestion(locat);
			break;
		case "�^�Э���":
			String[] food = { "�ݦa�}", "�ݦa�I", "�ݶ}��ɶ�", "�ݴ��I��T", "�@��y" };
			Reply = UserReply.getRandomQuestion(food);
			break;
		case "�^�д��I��T":
			String[] viewinf = { "�ݶ}��ɶ�", "�ݭ���", "�ݦa�I", "�ݦa�}", "�@��y" };
			Reply = UserReply.getRandomQuestion(viewinf);
			break;
		case "�^�д��I":
			String[] view = { "�ݶ}��ɶ�", "�ݭ���", "�ݦa�I", "�ݦa�}", "�ݴ��I��T", "�@��y" };
			Reply = UserReply.getRandomQuestion(view);
			break;
		case "�^�ж}��ɶ�":
			String[] open = { "�ݭ���", "�ݦa�I", "�ݦa�}", "�ݴ��I��T", "�ݴ��I", "�@��y" };
			Reply = UserReply.getRandomQuestion(open);
			break;

		}

		return Reply;
	}
	
	private static String[] RobotQuestion(String type) {
		String ReplyType;
		int index;
		String Reply[] = new String[3];
		Reply[2] = "User";
		switch (type) {
		case "�ݦ�{":
			String[] schedule = { "�^�Ц�{" };
			index = (int) (Math.random() * schedule.length);
			ReplyType = schedule[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "�ݬ���":
			String[] act = { "�^�Ь���" };
			index = (int) (Math.random() * act.length);
			ReplyType = act[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "�ݭ���":
			String[] food = { "�^�Э���" };
			index = (int) (Math.random() * food.length);
			ReplyType = food[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "�ݭ�����T":
			String[] foodinf = { "�^�Э�����T" };
			index = (int) (Math.random() * foodinf.length);
			ReplyType = foodinf[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "�ݮȹC�覡":
			String[] traveltraffic = { "�^�ЮȹC�覡" };
			index = (int) (Math.random() * traveltraffic.length);
			ReplyType = traveltraffic[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "�ݮȹC�P��":
			String[] travelpar = { "�^�ЮȹC�P��" };
			index = (int) (Math.random() * travelpar.length);
			ReplyType = travelpar[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "�ݮȹC�ɶ�":
			String[] traveltime = { "�^�ЮȹC�ɶ�" };
			index = (int) (Math.random() * traveltime.length);
			ReplyType = traveltime[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "�ݮȹC�z��":
			String[] travelreason = { "�^�ЮȹC�z��" };
			index = (int) (Math.random() * travelreason.length);
			ReplyType = travelreason[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "�ݲ�����T":
			String[] ticket = { "�^�в�����T" };
			index = (int) (Math.random() * ticket.length);
			ReplyType = ticket[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "�ݴ��I":
			String[] view = { "�^�д��I" };
			index = (int) (Math.random() * view.length);
			ReplyType = view[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "�ݶ}��ɶ�":
			String[] open = { "�^�ж}��ɶ�" };
			index = (int) (Math.random() * open.length);
			ReplyType = open[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "�ݷP��":
			String[] feel = { "�^�зPı" };
			index = (int) (Math.random() * feel.length);
			ReplyType = feel[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "�ݻ���":
			String[] pay = { "�^�л���" };
			index = (int) (Math.random() * pay.length);
			ReplyType = pay[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "�ݦ�J��T":
			String[] roominf = { "�^�Ц�J��T" };
			index = (int) (Math.random() * roominf.length);
			ReplyType = roominf[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		}
		
		return Reply;
	}
}
