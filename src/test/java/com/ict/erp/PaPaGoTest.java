package com.ict.erp;
 import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
 import org.junit.Test;
 import com.fasterxml.jackson.databind.ObjectMapper;
 public class PaPaGoTest {
	private String clientId = "cB8NkIYOd2vf2ZzQz4BA";
	private String clientSecret = "R_oB447JUq";
	@Test
	public void test() {
		HttpURLConnection huc = null;
		BufferedReader br = null;
		String text = "this is a naver api.";
		try {
			URL url = new URL("https://openapi.naver.com/v1/papago/n2mt");
			huc = (HttpURLConnection) url.openConnection();
			huc.setRequestMethod("POST");
			huc.setRequestProperty("X-Naver-Client-Id", clientId);
			huc.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			String param = "source=en&target=ko&text=" + text;
			
			huc.setDoOutput(true);
			DataOutputStream dos = new DataOutputStream(huc.getOutputStream());
			dos.writeBytes(param);
			dos.flush();
			dos.close();
			
			int status = huc.getResponseCode();
			
			br = new BufferedReader(new InputStreamReader(huc.getInputStream()));
			String result;
			StringBuffer sb = new StringBuffer();
			while((result=br.readLine())!=null) {
				sb.append(result);
			}
			br.close();
			if(status!=200) {
				System.out.println(sb.toString());
				throw new IOException(sb.toString());
			}
			ObjectMapper om = new ObjectMapper();
			Map<String,Map<String,Map>> nm = om.readValue(sb.toString(), Map.class);
			System.out.println(nm);
			System.out.println(text + " 번역=> " + nm.get("message").get("result").get("translatedText"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 }