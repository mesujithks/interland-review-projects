package rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

public class RestClient {

	public static void main(String[] args) {
		
	

	  try {

		URL url = new URL("http://localhost:8090/OnlineCourse/API/users");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Accept", "application/json");

			
			/*
			 * String input = "{\n" + "    \"id\": null,\n" +
			 * "    \"name\": \"SUJITH K S new Updated\",\n" +
			 * "    \"email\": \"mesujithks3@gmail.com\",\n" +
			 * "    \"mobile\": \"9656008103\"\n" + "}";
			 * 
			 * OutputStream os = conn.getOutputStream(); os.write(input.getBytes());
			 * os.flush();
			 * 
			 */
		System.out.println("Request to Server .... \n\n"+url);
		

		if (conn.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
			throw new RuntimeException("Failed, No users found : HTTP error code : "
				+ conn.getResponseCode());
		}else if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output,json="";
			System.out.println("\nOutput from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				json+=output;
			}
				/*
				 * Gson gson = new Gson(); UserModel user = gson.fromJson(json,
				 * UserModel.class); System.out.println("\nConverted to java object .... \n");
				 * System.out.println(user);
				 */
		}

		

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	 }

	}

}
