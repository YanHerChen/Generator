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
		if(type.contains("回覆")) {
			return RobotReply(type);
		}else {
			return RobotQuestion(type);
		}
	}
	private static String[] RobotReply(String type) {
		String Reply[] = new String[3];
		Reply[2] = "User";
		switch (type) {
		case "回覆店家資訊":
			break;
		case "回覆地點":
			break;
		case "回覆食物":
			break;
		case "回覆景點資訊":
			break;
		case "回覆景點":
			break;
		case "回覆開放時間":
			break;
		}
		
		return Reply;
	}

	private static String[] RobotQuestion(String type) {

		String Reply[] = new String[3];
		Reply[2] = "User";
		switch (type) {
		case "問交通資訊":
			break;
		case "問地址":
			break;
		case "問地點":
			break;
		case "問行程":
			break;
		case "問店家":
			break;
		case "問活動":
			break;
		case "問食物":
			break;
		case "問食物資訊":
			break;
		case "問旅遊方式":
			break;
		case "問旅遊同伴":
			break;
		case "問旅遊時間":
			break;
		case "問旅遊理由":
			break;
		case "問旅遊費用":
			break;
		case "問旅遊準備情形":
			break;
		case "問旅遊購買資訊":
			break;
		case "問時間":
			break;
		case "問票卷資訊":
			break;
		case "問景點":
			break;
		case "問景點資訊":
			break;
		case "問距離":
			break;
		case "問開放時間":
			break;
		case "問感受":
			break;
		case "問價格":
			break;
		}
		
		return Reply;
	}
}
