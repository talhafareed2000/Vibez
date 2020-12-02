import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//User will enter the artist and song name
//Will scrape AZ Lyrics for the lyrics to that particular song

public class lyrics {

    public static void main(String[] args) {

        Scanner scan= new Scanner(System.in);
        System.out.println("Enter Artist Name: ");
        String artist=scan.nextLine();
        System.out.println("Enter Song Name: ");
        String songName=scan.nextLine();



        artist=artist.toLowerCase().replace(" ", "").trim();
        songName=songName.toLowerCase().replace(" ", "").trim();

        String urlText = "http://www.azlyrics.com/lyrics/"+artist+"/"+songName+".html";
        BufferedReader in = null;
        String lyrics = "";
        try {
            URL url = new URL(urlText);
            in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                  System.out.println(inputLine);
                lyrics+=inputLine;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // The lyrics are stored between these two strings in the html file
        String up_boundary="<!-- Usage of azlyrics.com content by any third-party lyrics provider is prohibited by our licensing agreement. Sorry about that. -->";
       String lower_boundary="<!-- MxM banner -->";

       lyrics=lyrics.split(up_boundary)[1];
       lyrics=lyrics.split(lower_boundary)[0];
       lyrics=lyrics.replace("<br>", "\n").replace("</div>", "").replace("</br>", " ").replace("<i>", " ").replace("</i>", "\n").trim();


        try {
            //This will clear the console before printing the lyrics
            Runtime.getRuntime().exec("cmd /c cls");
        } catch (IOException ex) {
            Logger.getLogger(lyrics.class.getName()).log(Level.SEVERE, null, ex);
        }



        System.out.print(lyrics);
    }
}
