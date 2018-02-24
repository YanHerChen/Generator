import java.util.ArrayList;
import java.util.HashMap;

public class User {
	// ������User���ܧY�i�I�s��class�A�åB����Robot�^��
	public static String[] UserSelect(String type) {
		System.out.println("User  "+type);
		if (type.contains("�^��"))
			return UserReply(type);
		else if (type.contains("��"))
			return UserQuestion(type);
		else
			return normal();
	}

	private static String[] normal() {
		String[] normaltype = {"�ݻ���","�ݷP��","�ݶ}��ɶ�","�ݴ��I","�ݮȹC�z��","�ݮȹC�ɶ�","�ݮȹC�P��","�ݮȹC�覡","�ݭ���","�ݬ���","�ݦ�J"};

		return RobotReply.getRandomQuestion(normaltype);
	}
	
	//�ﶵ��User���ܺ����A�ﶵ���e������Robot�^��
	private static String[] UserReply(String type) {
		int index;
		String Reply[] = null;
		switch (type) {
		case "�^�Ц�J":
			String[] room = {   "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y","�ݦ�J��T" };
			Reply = RobotReply.getRandomQuestion(room);
			break;
		case "�^�Цa�}":
			String[] locates = {   "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y","�ݦ�J"};
			Reply = RobotReply.getRandomQuestion(locates);
			break;
		case "�^�Х�q��T":
			String[] traffic = {   "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y","�ݦ�J"};
			Reply = RobotReply.getRandomQuestion(traffic);
			break;
		case "�^�Ц�{":
			String[] schedule = {  "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y","�ݦ�J"};
			Reply = RobotReply.getRandomQuestion(schedule);
			break;
		case "�^�Ц�J��T":
			String[] roominf = {   "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y","�ݦ�J"};
			Reply = RobotReply.getRandomQuestion(roominf);
			break;
		case "�^�Щ��a��T":
			String[] shopinf = {   "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y","�ݦ�J"};
			Reply = RobotReply.getRandomQuestion(shopinf);
			break;
		case "�^�Ь��ʸ�T":
			String[] actinf = {   "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y","�ݦ�J"};
			Reply = RobotReply.getRandomQuestion(actinf);
			break;
		case "�^�Ь���":
			String[] act = {   "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y","�ݦ�J","�ݬ��ʸ�T"};
			Reply = RobotReply.getRandomQuestion(act);
			break;
		case "�^�Э���":
			String[] food = {   "�ݬ���", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y","�ݦ�J","�ݭ�����T"};
			Reply = RobotReply.getRandomQuestion(food);
			break;
		case "�^�Э�����T":
			String[] foodinf = {   "�ݬ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y","�ݦ�J"};
			Reply = RobotReply.getRandomQuestion(foodinf);
			break;
		case "�^�ЮȹC�覡":
			String[] travel = {   "�ݬ���", "�ݭ���", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y","�ݦ�J"};
			Reply = RobotReply.getRandomQuestion(travel);
			break;
		case "�^�ЮȹC�P��":
			String[] travelpar = {   "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y","�ݦ�J"};
			Reply = RobotReply.getRandomQuestion(travelpar);
			break;
		case "�^�ЮȹC�ɶ�":
			String[] traveltime = {   "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y","�ݦ�J"};
			Reply = RobotReply.getRandomQuestion(traveltime);
			break;
		case "�^�ЮȹC�z��":
			String[] travelreason = {   "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݴ��I", "�ݷP��", "�@��y","�ݦ�J"};
			Reply = RobotReply.getRandomQuestion(travelreason);
			break;
		case "�^�ж}��ɶ�":
			String[] travelopen = {   "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y","�ݦ�J"};
			Reply = RobotReply.getRandomQuestion(travelopen);
			break;
		case "�^�в�����T":
			String[] tickets = {   "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y","�ݦ�J"};
			Reply = RobotReply.getRandomQuestion(tickets);
			break;
		case "�^�д��I":
			String[] view = {   "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݷP��", "�@��y","�ݦ�J"};
			Reply = RobotReply.getRandomQuestion(view);
			break;
		case "�^�зPı":
			String[] feel = {   "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�@��y","�ݦ�J"};
			Reply = RobotReply.getRandomQuestion(feel);
			break;
		case "�^�л���":
			String[] pay = {   "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y","�ݦ�J"};
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