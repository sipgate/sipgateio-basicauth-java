package sipgateio.personalaccesstoken;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Base64;


public class PersonalAccessToken {
	private static final String baseUrl = "https://api.sipgate.com/v2";

	public static void main(String[] args) {
		String tokenId = "SIPGATE_TOKEN_ID";
		String token = "SIPGATE_TOKEN";

		String credentials = tokenId + ":" + token;
		String base64EncodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());

		try {
			HttpResponse<String> response = Unirest.get(baseUrl + "/account")
					.header("Authorization", "Basic " + base64EncodedCredentials)
					.asString();
			System.out.println("Status: " + response.getStatus());
			System.out.println("Body: " + response.getBody());
		} catch (UnirestException e) {
			System.out.println(e.getMessage());
		}
	}
}
