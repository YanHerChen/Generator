import java.util.ArrayList;
import java.util.HashMap;

public class User {
	// ������User���ܧY�i�I�s��class�A�åB����Robot�^��
	public static String[] UserSelect(String type) {
		if (type.contains("��")) {
			return UserQuestion(type);
		} else {
			return RobotReply(type);
		}
	}

	private static String[] RobotReply(String type) {
		String ReplyType;
		int index;
		String Reply[] = null;
		switch (type) {
		case "�^�Х�q��T":
			String[] traffic = { "�ݦ�{",  "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��",  
					  "�ݴ��I",  "�ݷP��" };
			Reply = RobotReply.getRandomQuestion(traffic);
			break;
		case "�^�Ц�{":
			String[] schedule = {  "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��",  
					  "�ݴ��I",  "�ݷP��" };
			Reply = RobotReply.getRandomQuestion(schedule);
			break;
		case "�^�Ц�J��T":
			String[] roominf = { "�ݦ�{", "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��",   
					 "�ݴ��I",  "�ݷP��" };
			Reply = RobotReply.getRandomQuestion(roominf);
			break;
		case "�^�Щ��a��T":
			String[] shopinf = { "�ݦ�{",  "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��",  
					  "�ݴ��I",  "�ݷP��" };
			Reply = RobotReply.getRandomQuestion(shopinf);
			break;
		case "�^�Ь���":
			String[] act = { "�ݦ�{",  "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��",   
					 "�ݴ��I",  "�ݷP��" };
			Reply = RobotReply.getRandomQuestion(act);
			break;
		case "�^�Э���":
			String[] food = { "�ݦ�{",  "�ݬ���", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��",   
					 "�ݴ��I",  "�ݷP��" };
			Reply = RobotReply.getRandomQuestion(food);
			break;
		case "�^�Э�����T":
			String[] foodinf = { "�ݦ�{",  "�ݬ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��",  
					  "�ݴ��I",  "�ݷP��" };
			Reply = RobotReply.getRandomQuestion(foodinf);
			break;
		case "�^�ЮȹC�覡":
			String[] travel = { "�ݦ�{",  "�ݬ���", "�ݭ���", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��",   
					 "�ݴ��I",  "�ݷP��" };
			Reply = RobotReply.getRandomQuestion(travel);
			break;
		case "�^�ЮȹC�P��":
			String[] travelpar = { "�ݦ�{",  "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�ɶ�", "�ݮȹC�z��",  
					  "�ݴ��I",  "�ݷP��" };
			Reply = RobotReply.getRandomQuestion(travelpar);
			break;
		case "�^�ЮȹC�ɶ�":
			String[] traveltime = { "�ݦ�{",  "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", 
					   "�ݴ��I",  "�ݷP��" };
			Reply = RobotReply.getRandomQuestion(traveltime);
			break;
		case "�^�ЮȹC�z��":
			String[] travelreason = { "�ݦ�{",  "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�",  
					  "�ݴ��I",  "�ݷP��" };
			Reply = RobotReply.getRandomQuestion(travelreason);
			break;
		case "�^�ж}��ɶ�":
			String[] travelopen = { "�ݦ�{",  "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", 
					   "�ݴ��I",  "�ݷP��" };
			Reply = RobotReply.getRandomQuestion(travelopen);
			break;
		case "�^�в�����T":
			String[] tickets = { "�ݦ�{",  "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��",  
					  "�ݴ��I",  "�ݷP��" };
			Reply = RobotReply.getRandomQuestion(tickets);
			break;
		case "�^�д��I":
			String[] view = { "�ݦ�{",  "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��",  
					   "�ݷP��" };
			Reply = RobotReply.getRandomQuestion(view);
			break;
		case "�^�зPı":
			String[] feel = { "�ݦ�{",  "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��",  
					  "�ݴ��I" };
			Reply = RobotReply.getRandomQuestion(feel);
			break;
		case "�^�л���":
			String[] pay = { "�ݦ�{",  "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��",  
					  "�ݴ��I",  "�ݷP��" };
			Reply = RobotReply.getRandomQuestion(pay);
			break;
		}

		return Reply;
	}

	private static String[] UserQuestion(String type) {
		String ReplyType;
		int index;
		String Reply[] = new String[3];
		Reply[2] = "Robot";
		switch (type) {
		case "�ݦa�I":
			String[] locat = { "�^�Цa�I" };
			index = (int) (Math.random() * locat.length);
			ReplyType = locat[index];
			Reply[0] = RobotReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "�ݦa�}":
			String[] locats = { "�^�Щ��a��T" };
			index = (int) (Math.random() * locats.length);
			ReplyType = locats[index];
			Reply[0] = RobotReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "�ݭ���":
			String[] food = { "�^�Э���" };
			index = (int) (Math.random() * food.length);
			ReplyType = food[index];
			Reply[0] = RobotReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "�ݴ��I":
			String[] view = { "�^�д��I" };
			index = (int) (Math.random() * view.length);
			ReplyType = view[index];
			Reply[0] = RobotReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "�ݴ��I��T":
			String[] viewinf = { "�^�д��I��T" };
			index = (int) (Math.random() * viewinf.length);
			ReplyType = viewinf[index];
			Reply[0] = RobotReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "�ݶ}��ɶ�":
			String[] open = { "�^�ж}��ɶ�" };
			index = (int) (Math.random() * open.length);
			ReplyType = open[index];
			Reply[0] = RobotReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		}

		return Reply;
	}
}