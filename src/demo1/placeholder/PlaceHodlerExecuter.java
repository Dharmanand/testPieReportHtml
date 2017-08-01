package demo1.placeholder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PlaceHodlerExecuter {

	static Map<String, String> placeHolderSum = new HashMap<String, String>();
	static Map<String, Integer> placeRepeats = new HashMap<String, Integer>();
	static Set<Map<String, String>> allLink = new HashSet<Map<String, String>>();
	static void setValues() {
		placeHolderSum.put("@-totalTestCount", "19");
		placeHolderSum.put("@-passedTotal", "14");
		placeHolderSum.put("@-failedTotal", "3");
		placeHolderSum.put("@-errorTotal", "2");
		placeHolderSum.put("@-totalTime", "15.52");
		// placeHolderSum.put(, "");

		placeRepeats.put("@-repeatStart", 0);
		placeRepeats.put("@-repeatEnd", 0);
	
		Map<String, String> link = new HashMap<String, String>();
		link.put("@-sl", "1");
		link.put("@-testReportName", "Youtube");
		link.put("@-hrefUrl", "http://Youtube.com");
		link.put("@-testCount", "8");
		link.put("@-passCount", "6");
		link.put("@-failCount", "1");
		link.put("@-errorCount", "1");
		link.put("@-timeTaken", "4.52");
		link.put("@-timeStamp", "---");
		allLink.add(link);
		link = new HashMap<String, String>();
		link.put("@-sl", "2");
		link.put("@-testReportName", "Google");
		link.put("@-hrefUrl", "http://google.com");
		link.put("@-testCount", "8");
		link.put("@-passCount", "6");
		link.put("@-failCount", "1");
		link.put("@-errorCount", "1");
		link.put("@-timeTaken", "4.52");
		link.put("@-timeStamp", "---");
		allLink.add(link);
	}

}
