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
			return normal(type);

	}

	private static String[] normal(String type) {
		String ReplyType;
		String Reply[] = null;
		String[] normaltype = {"�ݦ�J��T","�ݻ���","�ݷP��","�ݶ}��ɶ�","�ݴ��I","�ݦ�{","�ݲ�����T","�ݮȹC�z��","�ݮȹC�ɶ�","�ݮȹC�P��","�ݮȹC�覡","�ݭ�����T","�ݭ���","�ݬ���","�ݩ��a"};

		return RobotReply.getRandomQuestion(normaltype);
	}

	//�ﶵ��User���ܺ����A�ﶵ���e������Robot�^��
	private static String[] UserReply(String type) {
		int index;
		String Reply[] = null;
		switch (type) {
		case "�^�Цa�}":
			String[] locates = { "�ݦ�J��T", "�ݦ�{", "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y" };
			Reply = RobotReply.getRandomQuestion(locates);
			break;
		case "�^�Х�q��T":
			String[] traffic = { "�ݦ�J��T", "�ݦ�{", "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y" };
			Reply = RobotReply.getRandomQuestion(traffic);
			break;
		case "�^�Ц�{":
			String[] schedule = { "�ݦ�J��T", "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y" };
			Reply = RobotReply.getRandomQuestion(schedule);
			break;
		case "�^�Ц�J��T":
			String[] roominf = { "�ݦ�J��T", "�ݦ�{", "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y" };
			Reply = RobotReply.getRandomQuestion(roominf);
			break;
		case "�^�Щ��a��T":
			String[] shopinf = { "�ݦ�J��T", "�ݦ�{", "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y" };
			Reply = RobotReply.getRandomQuestion(shopinf);
			break;
		case "�^�Ь���":
			String[] act = { "�ݦ�J��T", "�ݦ�{", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y" };
			Reply = RobotReply.getRandomQuestion(act);
			break;
		case "�^�Э���":
			String[] food = { "�ݦ�J��T", "�ݦ�{", "�ݬ���", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y" };
			Reply = RobotReply.getRandomQuestion(food);
			break;
		case "�^�Э�����T":
			String[] foodinf = { "�ݦ�J��T", "�ݦ�{", "�ݬ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y" };
			Reply = RobotReply.getRandomQuestion(foodinf);
			break;
		case "�^�ЮȹC�覡":
			String[] travel = { "�ݦ�J��T", "�ݦ�{", "�ݬ���", "�ݭ���", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y" };
			Reply = RobotReply.getRandomQuestion(travel);
			break;
		case "�^�ЮȹC�P��":
			String[] travelpar = { "�ݦ�J��T", "�ݦ�{", "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y" };
			Reply = RobotReply.getRandomQuestion(travelpar);
			break;
		case "�^�ЮȹC�ɶ�":
			String[] traveltime = { "�ݦ�J��T", "�ݦ�{", "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y" };
			Reply = RobotReply.getRandomQuestion(traveltime);
			break;
		case "�^�ЮȹC�z��":
			String[] travelreason = { "�ݦ�J��T", "�ݦ�{", "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݴ��I", "�ݷP��", "�@��y" };
			Reply = RobotReply.getRandomQuestion(travelreason);
			break;
		case "�^�ж}��ɶ�":
			String[] travelopen = { "�ݦ�J��T", "�ݦ�{", "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y" };
			Reply = RobotReply.getRandomQuestion(travelopen);
			break;
		case "�^�в�����T":
			String[] tickets = { "�ݦ�J��T", "�ݦ�{", "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y" };
			Reply = RobotReply.getRandomQuestion(tickets);
			break;
		case "�^�д��I":
			String[] view = { "�ݦ�J��T", "�ݦ�{", "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݷP��", "�@��y" };
			Reply = RobotReply.getRandomQuestion(view);
			break;
		case "�^�зPı":
			String[] feel = { "�ݦ�J��T", "�ݦ�{", "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�@��y" };
			Reply = RobotReply.getRandomQuestion(feel);
			break;
		case "�^�л���":
			String[] pay = { "�ݦ�J��T", "�ݦ�{", "�ݬ���", "�ݭ���", "�ݮȹC�覡", "�ݮȹC�P��", "�ݮȹC�ɶ�", "�ݮȹC�z��", "�ݴ��I", "�ݷP��", "�@��y" };
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
		case "�ݦa�}":
			String[] locats = { "�^�Цa�}" };
			index = (int) (Math.random() * locats.length);
			ReplyType = locats[index];
			Reply[0] = RobotReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
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