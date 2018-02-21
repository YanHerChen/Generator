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
	public static String[] RobotSelect(String type) {
		if (type.contains("回覆")) {
			return UserReply(type);
		} else {
			return RobotQuestion(type);
		}
	}

	private static String[] UserReply(String type) {
		String RepyType;
		String[] Reply = null;
		int index;
		switch (type) {
		case "回覆店家資訊":
			String[] shop = { "問交通資訊", "問地址", "問地點", "問食物", "問開放時間", "問景點資訊" };
			Reply = UserReply.getRandomQuestion(shop);
			break;
		case "回覆地點":
			String[] locat = { "問地址", "問開放時間", "問景點", "問景點資訊", "問交通資訊" };
			Reply = UserReply.getRandomQuestion(locat);
			break;
		case "回覆食物":
			String[] food = { "問地址", "問地點", "問交通資訊", "問開放時間", "問景點資訊" };
			Reply = UserReply.getRandomQuestion(food);
			break;
		case "回覆景點資訊":
			String[] viewinf = { "問開放時間", "問食物", "問地點", "問地址", "問交通資訊" };
			Reply = UserReply.getRandomQuestion(viewinf);
			break;
		case "回覆景點":
			String[] view = { "問開放時間", "問食物", "問地點", "問地址", "問交通資訊", "問景點資訊" };
			Reply = UserReply.getRandomQuestion(view);
			break;
		case "回覆開放時間":
			String[] open = { "問食物", "問地點", "問地址", "問交通資訊", "問景點資訊", "問景點" };
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
		case "問交通資訊":
			String[] traffic = { "回覆交通資訊" };
			index = (int) (Math.random() * traffic.length);
			ReplyType = traffic[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問行程":
			String[] schedule = { "回覆行程" };
			index = (int) (Math.random() * schedule.length);
			ReplyType = schedule[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問店家":
			String[] shop = { "回覆店家資訊" };
			index = (int) (Math.random() * shop.length);
			ReplyType = shop[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問活動":
			String[] act = { "回覆活動" };
			index = (int) (Math.random() * act.length);
			ReplyType = act[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問食物":
			String[] food = { "回覆食物" };
			index = (int) (Math.random() * food.length);
			ReplyType = food[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問食物資訊":
			String[] foodinf = { "回覆食物資訊" };
			index = (int) (Math.random() * foodinf.length);
			ReplyType = foodinf[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問旅遊方式":
			String[] traveltraffic = { "回覆旅遊方式" };
			index = (int) (Math.random() * traveltraffic.length);
			ReplyType = traveltraffic[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問旅遊同伴":
			String[] travelpar = { "回覆旅遊同伴" };
			index = (int) (Math.random() * travelpar.length);
			ReplyType = travelpar[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問旅遊時間":
			String[] traveltime = { "回覆旅遊時間" };
			index = (int) (Math.random() * traveltime.length);
			ReplyType = traveltime[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問旅遊理由":
			String[] travelreason = { "回覆旅遊理由" };
			index = (int) (Math.random() * travelreason.length);
			ReplyType = travelreason[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問票卷資訊":
			String[] ticket = { "回覆票卷資訊" };
			index = (int) (Math.random() * ticket.length);
			ReplyType = ticket[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問景點":
			String[] view = { "回覆景點" };
			index = (int) (Math.random() * view.length);
			ReplyType = view[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問開放時間":
			String[] open = { "回覆開放時間" };
			index = (int) (Math.random() * open.length);
			ReplyType = open[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問感受":
			String[] feel = { "回覆感覺" };
			index = (int) (Math.random() * feel.length);
			ReplyType = feel[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問價格":
			String[] pay = { "回覆價位" };
			index = (int) (Math.random() * pay.length);
			ReplyType = pay[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問住宿資訊":
			String[] roominf = { "回覆住宿資訊" };
			index = (int) (Math.random() * roominf.length);
			ReplyType = roominf[index];
			Reply[0] = UserReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		}

		return Reply;
	}
}
