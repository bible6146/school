package go;

//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TextConverter extends JFrame implements ActionListener{
	String responseBody;
	 String hey;
	JTextArea t1=new JTextArea(10,14);
	JTextArea t2=new JTextArea(10,30);
	JButton b1,b2;
	public TextConverter() {
		JPanel j1=new JPanel();
		JPanel j2=new JPanel();
		
		b1=new JButton("����");
		b2=new JButton("Ȯ��");
		
		b1.addActionListener(this);
		j1.add(t1);
		//t1.setBackground(Color.black);
		j1.add(t2);
		this.add(j1,BorderLayout.CENTER);
		
		j2.add(b1);
		j2.add(b2);
		this.add(j2,BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane(t2);
		j1.add(scrollPane);
		
	

		
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		Map<String, String> requestHeaders = new HashMap<>();
	}
	public static void main(String[] args) {
		new TextConverter();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			String temp= toEnglish(t1.getText());
			t1.setText("");
			t2.setText(temp);
			System.out.println(temp);
		}
		
	}
	public String toEnglish(String a) {
		hey=t1.getText();
		return go();
	}
	
	
	
	public String go() {
   	 String clientId = "dSxq7JARAm_gvGuINIPl";//���ø����̼� Ŭ���̾�Ʈ ���̵�";
        String clientSecret = "_mPJrcnp2y";//���ø����̼� Ŭ���̾�Ʈ ��ũ����";

        String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
        String text;
        try {
            text = URLEncoder.encode(hey, "UTF-8");//text�� UTF-8= �����ڵ�� ��ȯ��Ŵ
            		//������ ���α׷��� ����� ���� �������ڿ��� ����µ� ���Ǵ� �޼ҵ�
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("���ڵ� ����", e);
        }

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);

        String responseBody = post(apiURL, requestHeaders, text);
       // String str=responseBody.substring(responseBody.indexOf("translatedText")+"translatedText".substring(6+responseBody.length()));
        //���� ��Ʈ������ �� ���� �غ���
////        JsonParser p=new JsonParser(); 
        JsonParser jsonParser = new JsonParser();
        JsonObject JsonObject=(JsonObject)jsonParser.parse(responseBody);
        JsonObject message=JsonObject.getAsJsonObject("message");
        JsonObject result=message.getAsJsonObject("result");
        
        JsonElement taranslated=result.get("translatedText");
        String sum=taranslated.getAsString();
        return sum;
       // System.out.println(responseBody);

//        JsonParser jsonParser = new JsonParser();
//        JsonObject jsonObject = (JsonObject) jsonParser.parse(responseBody);
//        JsonObject message = jsonObject.getAsJsonObject("message");
//        JsonObject result = message.getAsJsonObject("result");
//
//        JsonElement translatedTextJson = result.get("translatedText");
//        String translatedText = translatedTextJson.getAsString();
//        return translatedText;
   }

   public static String post(String apiUrl, Map<String, String> requestHeaders, String text){
       HttpURLConnection con = connect(apiUrl);
       String postParams = "source=ko&target=en&text=" + text; //�������: �ѱ��� (ko) -> �������: ���� (en)
       try {
           con.setRequestMethod("POST");
           for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
               con.setRequestProperty(header.getKey(), header.getValue());
           }

           con.setDoOutput(true);
           try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
               wr.write(postParams.getBytes());
               wr.flush();
           }

           int responseCode = con.getResponseCode();
           if (responseCode == HttpURLConnection.HTTP_OK) { // ���� ����
               return readBody(con.getInputStream());
           } else {  // ���� ����
               return readBody(con.getErrorStream());
           }
       } catch (IOException e) {
           throw new RuntimeException("API ��û�� ���� ����", e);
       } finally {
           con.disconnect();
       }
   }

   public static HttpURLConnection connect(String apiUrl){
       try {
           URL url = new URL(apiUrl);
          return (HttpURLConnection)url.openConnection();
       } catch (MalformedURLException e) {
           throw new RuntimeException("API URL�� �߸��Ǿ����ϴ�. : " + apiUrl, e);
       } catch (IOException e) {
           throw new RuntimeException("������ �����߽��ϴ�. : " + apiUrl, e);
       }
   }

   public static String readBody(InputStream body){
       InputStreamReader streamReader = new InputStreamReader(body);

       try (BufferedReader lineReader = new BufferedReader(streamReader)) {
           StringBuilder responseBody = new StringBuilder();

           String line;
           while ((line = lineReader.readLine()) != null) {
               responseBody.append(line);
           }

           return responseBody.toString();
       } catch (IOException e) {
           throw new RuntimeException("API ������ �дµ� �����߽��ϴ�.", e);
       }
   }

}
