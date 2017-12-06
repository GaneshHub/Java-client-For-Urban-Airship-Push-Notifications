package com.prototype.UrbanAirship;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import net.sf.json.JSONSerializer;
import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PushNotifier {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
	    {
	        String responseString = "";
	        String outputString = "";
	        String userName = "api key";
	        String password = "password";
	        String authString = userName +":"+password;
	        String authStringBase64 = new String(Base64.encodeBase64(authString.getBytes()));
	        authStringBase64 = authStringBase64.trim();

	        URL url = new URL("https://go.urbanairship.com/api/push/");
	        URLConnection urlConnection = url.openConnection();
	        HttpURLConnection httpConn = (HttpURLConnection)urlConnection;
	        ByteArrayOutputStream bout = new ByteArrayOutputStream();

	    // String temp = "[{\"device_type\": \"android\",\"opt_in\": true,\"push_address\": \"d3kqICyK2Sc:APA91bFDSnR_DCPtN4TdNWxMWq4xynDAzIwVfs80Y6XKxKFUp_b2wqIcKGEkCBkuVO_yRz8yuoMbuIfhjYjIL1kWjb3WSBAcFgHgAYoXfoBCTigx6usRjNKxD41OYcMU06Ge86PjTLh9\"}]";
	       //String postData = "{\"audience\": {\"android_channel\": \"460281aa-7160-4519-80c7-37e38c422608\"},\"android\": {\"alert\": \"Hello from JAVA!\"}}";
	        JSONObject dataToSend = new JSONObject();
	        JSONObject audience = new JSONObject();

			StringBuffer sb = new StringBuffer();
	        sb.append("Item : Dell LAP" + "\n");
	        sb.append("Type :Electonics" + "\n");
	        sb.append("Price : 500 USD" + "\n");
	        sb.append("COD  :Available" + "\n");
	        sb.append("Start Time : Jul 29, 2018 17:03:59" + "\n");
	  
	        // audience.put("android_channel", "all");
	        JSONObject notification = new JSONObject();
	        JSONObject androidNotification = new JSONObject();
	       JSONObject iosNotification = new JSONObject();
	        JSONObject action = new JSONObject();
	        JSONObject openPage = new JSONObject();
	        openPage.put("type", "url");
	        openPage.put("content","http://207.189.100.207:8888/SiteScope/docs/images/linechart1.gif");
	        action.put("open", openPage);
	        JSONObject ddaction = new JSONObject();
	        JSONObject opendd = new JSONObject();
	        opendd.put("type", "url");
	        opendd.put("content","http://www.aspen-systems.net/wp-content/uploads/2015/01/eG_Monitor_1_Home.png");
	        ddaction.put("open", opendd);
	        JSONObject interactiveButtons = new JSONObject();
	        JSONObject buttonActions= new JSONObject();
	        JSONObject shareButton= new JSONObject();
	        //JSONObject haiButton= new JSONObject();
	       // haiButton.put("share","Look at me! I'm on a boat.");
	       // JSONObject helloButton= new JSONObject();
	       //shareButton.put("share",sampledata);
	       // buttonActions.put("Share", shareButton);
	       // buttonActions.put("Graph", action);
	        //buttonActions.put("DD", ddaction);
	       // buttonActions.put("share",shareButton);
	       // interactiveButtons.put("type","custom group");
	        //interactiveButtons.put("button_actions",buttonActions);
	   
	        androidNotification.put("title", "Eg APP - Critical Alarm fgfgfgfgfg");
	       iosNotification.put("title", "Amazon Alert");
			androidNotification.put("alert", sampledata);
	      androidNotification.put("priority", 1);
	      androidNotification.put("interactive", interactiveButtons);
	      JSONObject extra = new JSONObject();
	      extra.put("story_id","1234");
	     /* "extra": {
	            "url": "http://example.com",
	            "story_id": "1234",
	            "moar": "{\"key\": \"value\"}"
	         }*/
	     // androidNotification.put("extra", extra);
	     // androidNotification.put("summary", "High");
	      //androidNotification.put("category", "email");
	     // androidNotification.put("priority", 1);
	      JSONObject style = new JSONObject();
	      style.put("type", "big_text");
	      style.put("big_text", sampledata);
	      style.put("summary", "Major");
	      //https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSrfvENklGZ7kfrUCLnl6moRxKbd3ZykYUS9KmvlFX7AtF2jqR
	    // androidNotification.put("actions", action);
	      //androidNotification.put("style", style);
	     //androidNotification.put("interactive", interactiveButtons);
	      iosNotification.put("alert", sampledata);
	     // iosNotification.put("interactive", interactiveButtons);
	       //androidNotification.put("collapse_key", "Message");
	      // androidNotification.put("delay_while_idle" , new Boolean(true));
	        notification.put("android", androidNotification);
	        notification.put("ios", iosNotification);
	        JSONArray deviceTypes = new JSONArray();
	        deviceTypes.add("android");
	        deviceTypes.add("ios");
	        dataToSend.put("audience","all");
	       dataToSend.put("notification", notification);
	       // dataToSend.put("interactive", interactiveButtons);
	       // dataToSend.put("in_app",androidInApp);
	        dataToSend.put("device_types", deviceTypes); 
	        //a3ea1ddc-ad1a-4d0a-86ff-ca2b99b64adb

	      // String postData =  "{\"audience\":\"all\",\"in_app\": { \"alert\":"+resultantJson.toString()+",\"display_type\": \"banner\",\"display\": {\"position\": \"top\"}}, \"device_types\": [\"android\"]}";
	       /* Component Name : manager_8.15:7077
	        Component Type : eG Manager
	        Layer Name : eG Access

	        	Service : NONE
	        	Test : HTTP
	        	Description - : Web page is unavailable {HomePage}
	        	Measurement Host : eGDP007
	        Priority : Critical
	        Start Time : Jul 29, 2016 17:03:59 */
	     String  postData = dataToSend.toString();
	        byte[] buffer = new byte[postData.length()];
	        buffer = postData.getBytes("UTF8");
	        bout.write(buffer);
	        byte[] b = bout.toByteArray();
	       System.out.println("length:"+String.valueOf(b.length));
	        httpConn.setRequestProperty("Content-Length",String.valueOf(b.length));
	        httpConn.setRequestProperty ("Authorization", "Basic " + authStringBase64);
	        httpConn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
	        httpConn.setRequestProperty("Accept", "application/vnd.urbanairship+json;version=3;");

	        httpConn.setRequestMethod("POST");

	        httpConn.setDoOutput(true);
	        httpConn.setDoInput(true);
	        OutputStream out = httpConn.getOutputStream();
	        out.write(b);
	        out.flush();
	        out.close();
	        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
	        BufferedReader in = new BufferedReader(isr);
	        while ((responseString = in.readLine()) != null) 
	        {
	        	//System.out.println("Response String : " + responseString);
	            outputString = outputString + responseString;
	        }
	        System.out.println(outputString);
	      int responseCode = httpConn.getResponseCode();
		  System.out.println("Response Code : " + responseCode);
	       if(outputString!=null)
	        {
	    	   net.sf.json.JSONObject o = (net.sf.json.JSONObject) JSONSerializer.toJSON(outputString); 
	        	 if(o!=null && !o.isEmpty() && o.containsKey("ok") && o.getBoolean("ok") == true)
	        	 {
	        		 net.sf.json.JSONArray push_ids = o.getJSONArray("push_ids");
	        		System.out.println(push_ids.toString());
	        	 }
	        	 
	        }
	      
	    }
	    catch (MalformedURLException e) 
	    {
	        e.printStackTrace();
	    }
	    catch (IOException e1) 
	    {
	        e1.printStackTrace();
	    }

	}
	
	
	


}

 //"{\"Application\":\"eG Manager\",\"Component\":\"monitor:8000\",\"Details\":[{\"Test\":[\"HTTP\",\"HTTP\",\"HTTP\"],\"Measure\":[\"Tcp connection availability\",\"Availability\"],\"Problem\":[\"TCP connection failed\",\"Web is unavailable\",\"HTTP\"],\"Info\":[\"HomePage\",\"HomePage\"]}],\"Layer\":\"eG Access\",\"StartTime\":\"Oct 01, 2013 12:55:21\",\"Priority":\"HIGH\"}";
