package javaWebEE.excel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonExporter {
	public static void main(String[] args) throws JSONException {
		// Replace with the actual file path and copy the 'sample.txt' file to the actual path
		String filePath = "/Users/sample.txt";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line;
			String[] columns = null;
			JSONArray jsonData = new JSONArray();

			while ((line = reader.readLine()) != null) {
				columns = line.split(",");
				jsonData.put(columns);
			}
			reader.close();

			// Create a JSON object to wrap the data
			JSONObject result = new JSONObject();
			result.put("data", jsonData);

			// Print the JSON output
			System.out.println(result.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
