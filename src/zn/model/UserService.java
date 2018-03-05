package zn.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author 	Andy Hung
 * @version v1.0
 * 將IO相關方法搬進此類別中，方便維護。
 */

public class UserService {

	private String USERS;

	public UserService(String USERS) {
		this.USERS = USERS;
	}

	// 檢查使用者名稱
	public boolean isInvalidUsername(String username) {

		for (String file : new File(USERS).list()) {
			if (file.equals(username)) {
				return true;
			}
		}

		return false;
	}

	// 創建user相關資訊
	public void createUserData(String email, String username, String password) throws IOException {
		File userhome = new File(USERS + "/" + username);
		userhome.mkdir();
		BufferedWriter writer = new BufferedWriter(new FileWriter(userhome + "/profile"));
		writer.write(email + "\t" + password);
		writer.close();
	}

	// 檢查是否登入
	public boolean checkLogin(String username, String password) throws IOException {
		if (username != null && password != null) {
			for (String file : new File(USERS).list()) {
				if (file.equals(username)) {
					BufferedReader reader = new BufferedReader(new FileReader(USERS + "/" + file + "/profile"));
					String passwd = reader.readLine().split("\t")[1];
					if (passwd.equals(password)) {
						reader.close();
						return true;
					}
					reader.close();
				}
			}
		}
		return false;
	}

	// 篩選txt檔
	public class TxtFilenameFilter implements FilenameFilter {
		@Override
		public boolean accept(File dir, String name) {
			return name.endsWith(".txt");
		}
	}

	private TxtFilenameFilter filenameFilter = new TxtFilenameFilter();

	// 檔案按照日期排序
	public class DateComparator implements Comparator<Date> {
		@Override
		public int compare(Date d1, Date d2) {
			return -d1.compareTo(d2);
		}
	}

	private DateComparator comparator = new DateComparator();

	//讀取留言
	public List<Blah> getBlahs(Blah blah) throws IOException {
		File border = new File(USERS + "/" + blah.getUsername());
		String[] txts = border.list(filenameFilter);

		Map<Date, String> messages = new TreeMap<Date, String>(comparator);
		for (String txt : txts) {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(USERS + "/" + blah.getUsername() + "/" + txt), "UTF-8"));
			String text = null;
			StringBuilder builder = new StringBuilder();
			while ((text = reader.readLine()) != null) {
				builder.append(text);
			}
			Date date = new Date(Long.parseLong(txt.substring(0, txt.indexOf(".txt"))));
			messages.put(date, builder.toString());
			reader.close();
		}
		
		List<Blah> blahs = new ArrayList<Blah>();
		for(Date date:messages.keySet()) {
			String txt = messages.get(date);
			blahs.add(new Blah(blah.getUsername(), date, txt));
		}
		
		return blahs;
	}
	
	//新增留言
	public void addBlah(Blah blah) throws IOException {
		String file = USERS + "/" + blah.getUsername() + "/" + blah.getDate().getTime() + ".txt";
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
		writer.write(blah.getTxt());
		writer.close();
	}
	
	//刪除留言
	public void deleteBlah(Blah blah) throws IOException {
		File file = new File(USERS + "/" + blah.getUsername() + "/" + blah.getDate().getTime() + ".txt");
		if (file.exists()) {
			file.delete();
		}
	}
	
}
