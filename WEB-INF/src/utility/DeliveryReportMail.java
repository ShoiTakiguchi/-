package utility;
//納品報告メール作成
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class DeliveryReportMail {
	  public void Mail(String username,ArrayList<String> addr,int requestid,String goodsname) throws IOException {

	        Properties objPrp=new Properties();

	        objPrp.put("mail.smtp.host","sapphire.u-gakugei.ac.jp"); // SMTPサーバ名

	        objPrp.put("mail.host","sapphire.u-gakugei.ac.jp"); // 接続するホスト名
	        // メールセッションを確立
	        Session session=Session.getDefaultInstance(objPrp,null);

	        // 送信メッセージを生成
	        MimeMessage objMsg=new MimeMessage(session);

	      //String型の配列に適当なメールアドレスを格納
	        InternetAddress[] addrList =new InternetAddress[addr.size()];

	        for(int i=0; i<addr.size(); i++){
	        	try {
					addrList[i] = new InternetAddress(addr.get(i));
				} catch (AddressException e) {
					e.printStackTrace();
				}
	        }

	        try {
	        // 送信先（TOのほか、CCやBCCも設定可能）
	        objMsg.setRecipients(Message.RecipientType.TO,addrList);


	        // Fromヘッダ
	        InternetAddress objFrm=new InternetAddress("CQW15204@nifty.com","購入管理システム");
	        objMsg.setFrom(objFrm);

	        // 件名
	        objMsg.setSubject("お知らせ","ISO-2022-JP");//ISO-2022-JPはエンコード
	        String text =  "送信者："+ username + "\n\n依頼ID " + requestid + "\n名称 " + goodsname + "\n\nこの依頼物品は納品されました。";
	        // 本文
	        objMsg.setText(text);
	        Transport.send(objMsg);

	        System.out.println("メール送信完了しました！");

	        } catch (UnsupportedEncodingException e) {

	        e.printStackTrace();

	        } catch (MessagingException e) {

	        e.printStackTrace();

	        }

	  }
}
