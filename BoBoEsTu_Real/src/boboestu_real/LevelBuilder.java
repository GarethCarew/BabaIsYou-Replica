/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boboestu_real;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author scien
 */
public class LevelBuilder extends Canvas{
    
    private final Image text_IS;
    private final Image text_BABA;
    private final Image text_YOU;
    private final Image text_WIN;
    private final Image text_FLAG;
    private final Image text_STOP;
    private final Image text_WALL;
    private final Image text_ROCK;
    private final Image text_PUSH;
    private final Image object_EMPTY;
    private final Image object_BABA;
    private final Image object_FLAG;
    private final Image object_WALL;
    private final Image object_ROCK;
        
    public LevelBuilder() throws IOException {
        text_IS = ImageIO.read(new File("src/objects/text_is_0_1.png"));
        text_BABA = ImageIO.read(new File("src/objects/text_baba_0_1.png"));
        text_YOU = ImageIO.read(new File("src/objects/text_you_0_1.png"));
        text_WIN = ImageIO.read(new File("src/objects/text_win_0_1.png"));
        text_FLAG = ImageIO.read(new File("src/objects/text_flag_0_1.png"));
        text_STOP = ImageIO.read(new File("src/objects/text_stop_0_1.png"));
        text_WALL = ImageIO.read(new File("src/objects/text_wall_0_1.png"));
        text_ROCK = ImageIO.read(new File("src/objects/text_rock_0_1.png"));
        text_PUSH = ImageIO.read(new File("src/objects/text_push_0_1.png"));
        object_EMPTY = ImageIO.read(new File("src/objects/empty_0_1.png"));
        object_BABA = ImageIO.read(new File("src/objects/baba_0_1.png"));
        object_FLAG = ImageIO.read(new File("src/objects/flag_0_1.png"));
        object_WALL = ImageIO.read(new File("src/objects/wall_0_1.png"));
        object_ROCK = ImageIO.read(new File("src/objects/rock_0_1.png"));
    }

    public void paint(Graphics g, Level level) {
        Block[][] b = level.getMap();
        
        for(int x = 0; x < b.length; x++)
        {
            for(int y = 0; y < b[x].length; y++)
            {
                 switch (b[x][y])
                 {
                    case object_EMPTY:
                        //g.drawImage(object_EMPTY, x*24, y*24, 24, 24, this);
                        System.out.print(" | \u001B[31m" + Block.object_EMPTY.name() + "\u001B[0m | ");
                        break;
                    case text_IS:
                        //g.drawImage(text_IS, x*24, y*24, 24, 24, this);
                        System.out.print(" | " + Block.text_IS.name() + "      | ");
                        break;
                    case text_BABA:
                        //g.drawImage(text_IS, x*24, y*24, 24, 24, this);
                        System.out.print(" | " + Block.text_BABA.name() + "    | ");
                        break;
                    case text_YOU:
                        //g.drawImage(text_IS, x*24, y*24, 24, 24, this);
                        System.out.print(" | " + Block.text_YOU.name() + "     | ");
                        break;
                    case text_WIN:
                        //g.drawImage(text_IS, x*24, y*24, 24, 24, this);
                        System.out.print(" | " + Block.text_WIN.name() + "     | ");
                        break;
                    case text_FLAG:
                        //g.drawImage(text_IS, x*24, y*24, 24, 24, this);
                        System.out.print(" | " + Block.text_FLAG.name() + "    | ");
                        break;
                    case text_STOP:
                        //g.drawImage(text_IS, x*24, y*24, 24, 24, this);
                        System.out.print(" | " + Block.text_STOP.name() + "    | ");
                        break;
                    case text_WALL:
                        //g.drawImage(text_IS, x*24, y*24, 24, 24, this);
                        System.out.print(" | " + Block.text_WALL.name() + "    | ");
                        break;
                    case text_ROCK:
                        //g.drawImage(text_IS, x*24, y*24, 24, 24, this);
                        System.out.print(" | " + Block.text_ROCK.name() + "    | ");
                        break;
                    case text_PUSH:
                        //g.drawImage(text_IS, x*24, y*24, 24, 24, this);
                        System.out.print(" | " + Block.text_PUSH.name() + "    | ");
                        break;
                    case object_BABA:
                        //g.drawImage(text_IS, x*24, y*24, 24, 24, this);
                        System.out.print(" | " + Block.object_BABA.name() + "  | ");
                        break;
                    case object_FLAG:
                        //g.drawImage(text_IS, x*24, y*24, 24, 24, this);
                        System.out.print(" | " + Block.object_FLAG.name() + "  | ");
                        break;
                    case object_WALL:
                        //g.drawImage(text_IS, x*24, y*24, 24, 24, this);
                        System.out.print(" | " + Block.object_WALL.name() + "  | ");
                        break;
                    case object_ROCK:
                        //g.drawImage(text_IS, x*24, y*24, 24, 24, this);
                        System.out.print(" | " + Block.object_ROCK.name() + "  | ");
                        break;
                    default:
                        break;
                }  
            }
            System.out.println("");
        }
        System.out.println( "_________________________________________________________________________________________________________________________________________________________" );
        System.out.println( "_________________________________________________________________________________________________________________________________________________________" );
        System.out.println( "_________________________________________________________________________________________________________________________________________________________" );
        System.out.println( "_________________________________________________________________________________________________________________________________________________________" );

    }
}
