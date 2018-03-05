package zn.web.wrapper;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author 	Andy Hung
 * @version v1.0
 * 實作請求包裹器，重新包裝getParameter編碼
 */

public class EncodingWrapper extends HttpServletRequestWrapper{

	private String Encoding;
	//一定要實作建構子
	public EncodingWrapper(HttpServletRequest request, String ENCODING) {
		super(request);
		this.Encoding = ENCODING;
	}
	
	//重新定義getParameter
	@Override
	public String getParameter(String name) {
		String value = getRequest().getParameter(name);
		if(value != null) {
			try {
				byte[] b = value.getBytes();
				value = new String(b, this.Encoding);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		return value;
	}
	
}
