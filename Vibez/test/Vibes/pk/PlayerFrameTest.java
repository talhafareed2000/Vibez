
package Vibes.pk;

import jaco.mp3.player.MP3Player;
import java.io.File;
import javax.swing.JFileChooser;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 *
 *
 * @author ajtor
 */
public class PlayerFrameTest {
    MP3Player player;
        File songFile;
        String currentDirectory = "home.user";
        
    public PlayerFrameTest() {
        
        player = mp3Player();
        songFile = new File("") ;
        player.addToPlayList(songFile);
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class PlayerFrame.
     * @throws java.lang.Exception
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        PlayerFrame.main(args);
        
        
    }
    
    /* Test of the plyBtnMouseClicked method, of class PlayerFrame*/
    @Test
public void playBtnMouseClicked() {                                     
        
        player.play();
    }         

/* Test of the stopBtnMouseClicked method, of class PlayerFrame*/
@Test
public void stopBtnMouseClicked() {                                     
        
        player.stop();
    }         

/* Test of the pauseBtnMouseClicked method, of class PlayerFrame*/
@Test
 public void pauseBtnMouseClicked() {                                      
        
        player.pause();
    }          
 
 /* Test of the openBtnMouseClicked */
 @Test
public void openBtnMouseClicked() {                                     
        
        JFileChooser openFileChooser = new JFileChooser(currentDirectory);
        openFileChooser.setFileFilter(new FileTypeFilter(".mp3", "MP3 Files Only"));
        int result = openFileChooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            songFile = openFileChooser.getSelectedFile();
            player.addToPlayList(songFile);
            player.skipForward();
            currentDirectory = songFile.getAbsolutePath();
            
        }
}
    private MP3Player mp3Player(){
        MP3Player mp3Player = new MP3Player();
        return mp3Player;
    }


   
    
}
