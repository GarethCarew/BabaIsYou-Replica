/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babaisyou;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author scien
 */
public class Images {
    
    public final Image text_IS;
    public final Image text_BABA;
    public final Image text_YOU;
    public final Image text_WIN;
    public final Image text_FLAG;
    public final Image text_STOP;
    public final Image text_WALL;
    public final Image text_ROCK;
    public final Image text_PUSH;
    public final Image EMPTY;
    public final Image object_BABA;
    public final Image object_FLAG;
    public final Image object_WALL_noC;
    public final Image object_ROCK;
    
    public Images() throws IOException {
        
        text_IS = ImageIO.read(new File("src/objects/text_is_0_1.png"));
        text_BABA = ImageIO.read(new File("src/objects/text_baba_0_1.png"));
        text_YOU = ImageIO.read(new File("src/objects/text_you_0_1.png"));
        text_WIN = ImageIO.read(new File("src/objects/text_win_0_1.png"));
        text_FLAG = ImageIO.read(new File("src/objects/text_flag_0_1.png"));
        text_STOP = ImageIO.read(new File("src/objects/text_stop_0_1.png"));
        text_WALL = ImageIO.read(new File("src/objects/text_wall_0_1.png"));
        text_ROCK = ImageIO.read(new File("src/objects/text_rock_0_1.png"));
        text_PUSH = ImageIO.read(new File("src/objects/text_push_0_1.png"));
        EMPTY = ImageIO.read(new File("src/objects/empty_0_1.png"));
        object_BABA = ImageIO.read(new File("src/objects/baba_0_1.png"));
        object_FLAG = ImageIO.read(new File("src/objects/flag_0_1.png"));
        object_WALL_noC = ImageIO.read(new File("src/objects/wall_0_1.png"));
        object_ROCK = ImageIO.read(new File("src/objects/rock_0_1.png"));
        
    }
}
