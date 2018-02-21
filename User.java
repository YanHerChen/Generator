import java.util.ArrayList;
import java.util.HashMap;

public class User {
	//本次為User說話即可呼叫此class，並且執行Robot回應
	public static String[] UserSelect(String type) {
		if (type.contains("回覆")) {
			return	UserReply(type);
		} else {
			return	UserQuestion(type);
		}
	}

	private static String[] UserReply(String type) {
		String Reply[] = new String[3];
		Reply[2] = "Robot";
		switch (type) {
		case "回覆交通資訊":
			break;
		case "回覆行程":
			break;
		case "回覆住宿資訊":
			break;
		case "回覆店家資訊":
			break;
		case "回覆活動":
			break;
		case "回覆食物":
			String ReplyType = "問食物";
			Reply[0] = RobotReply.getRandomQuestion(ReplyType);
			Reply[1] = ReplyType;
		case "回覆食物資訊":
			break;
		case "回覆旅遊方式":
			break;
		case "回覆旅遊同伴":
			break;
		case "回覆旅遊時間":
			break;
		case "回覆旅遊理由":
			break;
		case "回覆開放時間":
			break;
		case "回覆票卷資訊":
			break;
		case "回覆景點":
			break;
		case "回覆感覺":
			break;
		case "回覆價位":
			break;
		}
		
		return Reply;
	}

	private static String[] UserQuestion(String type) {
		String Reply[] = new String[3];
		Reply[2] = "Robot";
		switch (type) {
		case "問交通資訊":
			break;
		case "問地址":
			break;
		case "問地點":
			break;
		case "問食物":
			Reply[0] = RobotReply.getRandomAnswer(type);
			Reply[1] = type;
			break;
		case "問景點":
			break;
		case "問景點資訊":
			break;
		case "問開放時間":
			break;
		}
		
		return Reply;
	}
}
