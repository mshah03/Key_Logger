import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class KeyLogger {
    private static final String fName = "keyStrokes.txt";
    
    public static void main(String[] args) {
        startKeyLogging();
    }

    private static void startKeyLogging() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(fName, true));
            Scanner sc = new Scanner(System.in);

            while (true) {
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                String timeStamp = getCurrentTimeStamp();
                pw.println(timeStamp+ ": "+ input);
                pw.flush();
            }

            pw.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getCurrentTimeStamp() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sDateFormat.format(new Date());
    }
}
