package factory;

import java.util.HashMap;
import java.util.List;

import utilities.DataReader;

public class test {

	public static void main(String[] args) {

		String rows = "2";
		List<HashMap<String, String>> datamap; // Data driven
		datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\Opencart_LoginData.xlsx", "Sheet1");
		//int index = Integer.parseInt(rows) - 1;

		System.out.println(datamap.size());
		System.out.println(datamap);
//		for (int i = 0; i < datamap.size(); i++) {
//			System.out.println(datamap);
////			String email = datamap.get(i)//.get("username");
////			String pwd = datamap.get(index).get("password");
////			String exp_res = datamap.get(index).get("res");
//
//		}
	}

}
