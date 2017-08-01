package demo1.placeholder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

public class TempletRdWt {

	public static void main(String[] args) {
		fileRead();
	}

	private static void fileRead() {
		try {
			PlaceHodlerExecuter.setValues();
			BufferedReader b = new BufferedReader(new FileReader(new File("templet/index.html")));

			String readLine = "";

			System.out.println("Reading file using Buffered Reader");
			File output = new File("report/index.html");
			if (output.exists())
				output.delete();

			PrintWriter writer = new PrintWriter(output);
			StringBuffer buffer = new StringBuffer();
			while ((readLine = b.readLine()) != null) {
				placeHolderValueMerger(writer, readLine, buffer, PlaceHodlerExecuter.allLink);
			}
			writer.close();
			b.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void placeHolderValueMerger(PrintWriter writer, String line, StringBuffer buffer,
			Set<Map<String, String>> rows) {

		if (line.contains("@-repeatStart")) {
			PlaceHodlerExecuter.placeRepeats.put("@-repeatStart",
					PlaceHodlerExecuter.placeRepeats.get("@-repeatStart") + 1);
			return;
		}

		if (PlaceHodlerExecuter.placeRepeats.get("@-repeatStart") == 0) {
			String[] section = null;
			for (String key : PlaceHodlerExecuter.placeHolderSum.keySet()) {
				if (line.contains(key)) {
					section = line.split(key);
					line = section[0] + PlaceHodlerExecuter.placeHolderSum.get(key) + section[1];
					System.out.println("---->>>>>" + line);
				}
			}
			writer.println(line);

		} else if (!line.contains("@-repeatEnd")) {
			buffer.append(line + "\n");
		} else {
			PlaceHodlerExecuter.placeRepeats.put("@-repeatStart",
					PlaceHodlerExecuter.placeRepeats.get("@-repeatStart") - 1);

			if (PlaceHodlerExecuter.placeRepeats.get("@-repeatStart") == 0) {
				String[] lines = buffer.toString().split("\n");
				for (Map<String, String> row : rows) {
					String[] section = null;

					for (String stLine : lines) {
						String temp = stLine;
						for (String str : row.keySet()) {
							if (stLine.contains(str)) {
								section = stLine.split(str);
								temp = section[0] + row.get(str) + section[1];
							}
						}
						if (stLine.equals(temp)) {
							System.out.println(temp);
							writer.println(stLine);
						} else {
							System.out.println(temp);
							writer.println(temp);
						}
					}

				}
			}
		}

	}

}
