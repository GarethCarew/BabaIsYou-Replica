/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babaisyou;

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
    
    Images i;
    
    public LevelBuilder() throws IOException
    {
        Images images = new Images();
    }

    public void paint(Graphics g, Level level) {
        Block[][] b = level.getMap();
        
        for(int x = 0; x < b.length; x++)
        {
            for(int y = 0; y < b[x].length; y++)
            {
                if(null != b[x][y])
                                        switch (b[x][y]) {
                    case object_EMPTY:
                        //g.drawImage(object_EMPTY, x*24, y*24, 24, 24, this);
                        System.out.print(" | \u001B[31m" + Block.object_EMPTY.name() + " | ");
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
    }
}
