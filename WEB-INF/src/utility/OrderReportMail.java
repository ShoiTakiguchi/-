package utility;
//新規依頼メール作成
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


public class OrderReportMail {
    public void Mail(String username,ArrayList<String> addr,int reqId,String goodsname) throws IOException {
    	System.out.println("hoge");

        Properties objPrp=new Properties();

        objPrp.put("mail.smtp.host","sapphire.u-gakugei.ac.jp"); // SMTPサーバ名

        objPrp.put("mail.host","sapphire.u-gakugei.ac.jp"); // 接続するホスト名
        // メールセッションを確立
        Session session=Session.getDefaultInstance(objPrp,null);

        // 送信メッセージを生成
        MimeMessage objMsg=new MimeMessage(session);

        //
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
        objMsg.setSubject("新規依頼登録","ISO-2022-JP");//ISO-2022-JPはエンコード
        String text =  "送信者："+ username + "\n\n依頼ID " + reqId + "\n名称 " + goodsname + "\n\n新しい依頼が登録されました。";
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
