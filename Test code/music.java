import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

//Displays all of the mp3 file paths located in the users music folder

public class music {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader
                (new InputStreamReader(System.in));
        System.out.println("Please enter your user account name where your mp3 files are stored:");
        String user = br.readLine();

        extract(new File("C:/Users/"+user+"/Music/"));

    }

    public static void extract(File dir) {
        File skip[] = dir.listFiles();

        if (skip == null) {
            //System.out.println("[This dir was skipped] " + dir);
            return;
        }

        for (File display : skip) {
            if (display.isDirectory())
                extract(display);
            if (display.isHidden() || !display.canRead())
                continue;
            else if (display.getName().endsWith(".mp3"))
                System.out.println(display.getPath());
        }

    }
}
