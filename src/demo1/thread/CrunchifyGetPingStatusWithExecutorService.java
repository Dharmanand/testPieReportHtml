package demo1.thread;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CrunchifyGetPingStatusWithExecutorService {
	private static final int MYTHREADS = 30;
	static String str = "";
	static Integer totalCount = 0;
	public static void main(String args[]) throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
		String[] hostList = { "https://crunchify.com", "http://yahoo.com",
				"http://www.ebay.com", "http://google.com",
				"http://www.example.co", "https://paypal.com",
				"http://bing.com/", "http://techcrunch.com/",
				"http://mashable.com/", "http://thenextweb.com/",
				"http://wordpress.com/", "http://wordpress.org/",
				"http://example.com/", "http://sjsu.edu/",
				"http://ebay.co.uk/", "http://google.co.uk/",
				"http://www.wikipedia.org/",
				"http://en.wikipedia.org/wiki/Main_Page" };
 
		for (int i = 0; i < hostList.length; i++) {
 
			String url = hostList[i];
			Runnable worker = new MyRunnable(url,i+1);
			executor.execute(worker);
		}
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {
 
		}
		System.out.println("\nFinished all threads");
		System.out.println(str);
		System.out.println(totalCount);
	}
 
	public static class MyRunnable implements Runnable {
		private final String url;
		private final Integer count;
 
		MyRunnable(String url, int count) {
			this.url = url;
			this.count = count;
		}
 
		public void run() {
			String result = "";
			int code = 200;
			try {
				URL siteURL = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) siteURL
						.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();
 
				code = connection.getResponseCode();
				if (code == 200) {
					result = "Green\t";
				}
			} catch (Exception e) {
				result = "->Red<-\t";
			}
			System.out.println(url + "\t\tStatus:" + result);
			str = str+url + "\t\tStatus:" + result+", ";
			totalCount = totalCount + count;
		}
	}
}
