import java.util.ArrayList;
import java.util.HashMap;

public class User {
	// 本次為User說話即可呼叫此class，並且執行Robot回應
	public static String[] UserSelect(String type) {
		if (type.contains("問")) {
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
		case "回覆交通資訊":
			String[] traffic = { "問行程",  "問活動", "問食物", "問旅遊方式", "問旅遊同伴", "問旅遊時間", "問旅遊理由",  
					  "問景點",  "問感受" };
			Reply = RobotReply.getRandomQuestion(traffic);
			break;
		case "回覆行程":
			String[] schedule = {  "問活動", "問食物", "問旅遊方式", "問旅遊同伴", "問旅遊時間", "問旅遊理由",  
					  "問景點",  "問感受" };
			Reply = RobotReply.getRandomQuestion(schedule);
			break;
		case "回覆住宿資訊":
			String[] roominf = { "問行程", "問活動", "問食物", "問旅遊方式", "問旅遊同伴", "問旅遊時間", "問旅遊理由",   
					 "問景點",  "問感受" };
			Reply = RobotReply.getRandomQuestion(roominf);
			break;
		case "回覆店家資訊":
			String[] shopinf = { "問行程",  "問活動", "問食物", "問旅遊方式", "問旅遊同伴", "問旅遊時間", "問旅遊理由",  
					  "問景點",  "問感受" };
			Reply = RobotReply.getRandomQuestion(shopinf);
			break;
		case "回覆活動":
			String[] act = { "問行程",  "問食物", "問旅遊方式", "問旅遊同伴", "問旅遊時間", "問旅遊理由",   
					 "問景點",  "問感受" };
			Reply = RobotReply.getRandomQuestion(act);
			break;
		case "回覆食物":
			String[] food = { "問行程",  "問活動", "問旅遊同伴", "問旅遊時間", "問旅遊理由",   
					 "問景點",  "問感受" };
			Reply = RobotReply.getRandomQuestion(food);
			break;
		case "回覆食物資訊":
			String[] foodinf = { "問行程",  "問活動", "問旅遊方式", "問旅遊同伴", "問旅遊時間", "問旅遊理由",  
					  "問景點",  "問感受" };
			Reply = RobotReply.getRandomQuestion(foodinf);
			break;
		case "回覆旅遊方式":
			String[] travel = { "問行程",  "問活動", "問食物", "問旅遊同伴", "問旅遊時間", "問旅遊理由",   
					 "問景點",  "問感受" };
			Reply = RobotReply.getRandomQuestion(travel);
			break;
		case "回覆旅遊同伴":
			String[] travelpar = { "問行程",  "問活動", "問食物", "問旅遊方式", "問旅遊時間", "問旅遊理由",  
					  "問景點",  "問感受" };
			Reply = RobotReply.getRandomQuestion(travelpar);
			break;
		case "回覆旅遊時間":
			String[] traveltime = { "問行程",  "問活動", "問食物", "問旅遊方式", "問旅遊同伴", "問旅遊時間", "問旅遊理由", 
					   "問景點",  "問感受" };
			Reply = RobotReply.getRandomQuestion(traveltime);
			break;
		case "回覆旅遊理由":
			String[] travelreason = { "問行程",  "問活動", "問食物", "問旅遊方式", "問旅遊同伴", "問旅遊時間",  
					  "問景點",  "問感受" };
			Reply = RobotReply.getRandomQuestion(travelreason);
			break;
		case "回覆開放時間":
			String[] travelopen = { "問行程",  "問活動", "問食物", "問旅遊方式", "問旅遊同伴", "問旅遊時間", "問旅遊理由", 
					   "問景點",  "問感受" };
			Reply = RobotReply.getRandomQuestion(travelopen);
			break;
		case "回覆票卷資訊":
			String[] tickets = { "問行程",  "問活動", "問食物", "問旅遊方式", "問旅遊同伴", "問旅遊時間", "問旅遊理由",  
					  "問景點",  "問感受" };
			Reply = RobotReply.getRandomQuestion(tickets);
			break;
		case "回覆景點":
			String[] view = { "問行程",  "問活動", "問食物", "問旅遊方式", "問旅遊同伴", "問旅遊時間", "問旅遊理由",  
					   "問感受" };
			Reply = RobotReply.getRandomQuestion(view);
			break;
		case "回覆感覺":
			String[] feel = { "問行程",  "問活動", "問食物", "問旅遊方式", "問旅遊同伴", "問旅遊時間", "問旅遊理由",  
					  "問景點" };
			Reply = RobotReply.getRandomQuestion(feel);
			break;
		case "回覆價位":
			String[] pay = { "問行程",  "問活動", "問食物", "問旅遊方式", "問旅遊同伴", "問旅遊時間", "問旅遊理由",  
					  "問景點",  "問感受" };
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
		case "問地點":
			String[] locat = { "回覆地點" };
			index = (int) (Math.random() * locat.length);
			ReplyType = locat[index];
			Reply[0] = RobotReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問地址":
			String[] locats = { "回覆店家資訊" };
			index = (int) (Math.random() * locats.length);
			ReplyType = locats[index];
			Reply[0] = RobotReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問食物":
			String[] food = { "回覆食物" };
			index = (int) (Math.random() * food.length);
			ReplyType = food[index];
			Reply[0] = RobotReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問景點":
			String[] view = { "回覆景點" };
			index = (int) (Math.random() * view.length);
			ReplyType = view[index];
			Reply[0] = RobotReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問景點資訊":
			String[] viewinf = { "回覆景點資訊" };
			index = (int) (Math.random() * viewinf.length);
			ReplyType = viewinf[index];
			Reply[0] = RobotReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		case "問開放時間":
			String[] open = { "回覆開放時間" };
			index = (int) (Math.random() * open.length);
			ReplyType = open[index];
			Reply[0] = RobotReply.getRandomAnswer(ReplyType);
			Reply[1] = ReplyType;
			break;
		}

		return Reply;
	}
}