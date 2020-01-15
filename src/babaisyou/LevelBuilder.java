/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babaisyou;

import java.awt.Canvas;
import java.awt.Graphics;
import java.io.IOException;

/**
 *
 * @author scien
 */
public class LevelBuilder extends Canvas{
    
    Images images;
    
    public LevelBuilder() throws IOException
    {
        images = new Images();
    }

    public void paint(Graphics g, Level level) {
        Block[][] b = level.getMap();
        
        for(int y = 0; y < b.length; y++)
        {
            for(int x = 0; x < b[y].length; x++)
            {
                if(null != b[y][x])
                    switch (b[y][x]) {
                    case object_EMPTY:
                        g.drawImage(images.object_EMPTY, 191 + x*24, y*24, 24, 24, this);
                        //System.out.print(" | \u001B[31m" + Block.object_EMPTY.name() + "\u001B[0m | ");
                        break;
                    case text_IS:
                        g.drawImage(images.text_IS, 191 + x*24, y*24, 24, 24, this);
                        //System.out.print(" | " + Block.text_IS.name() + "      | ");
                        break;
                    case text_BABA:
                        g.drawImage(images.text_BABA, 191 + x*24, y*24, 24, 24, this);
                        //System.out.print(" | " + Block.text_BABA.name() + "    | ");
                        break;
                    case text_YOU:
                        g.drawImage(images.text_YOU, 191 + x*24, y*24, 24, 24, this);
                        //System.out.print(" | " + Block.text_YOU.name() + "     | ");
                        break;
                    case text_WIN:
                        g.drawImage(images.text_WIN, 191 + x*24, y*24, 24, 24, this);
                        //System.out.print(" | " + Block.text_WIN.name() + "     | ");
                        break;
                    case text_FLAG:
                        g.drawImage(images.text_FLAG, 191 + x*24, y*24, 24, 24, this);
                        //System.out.print(" | " + Block.text_FLAG.name() + "    | ");
                        break;
                    case text_STOP:
                        g.drawImage(images.text_STOP, 191 + x*24, y*24, 24, 24, this);
                        //System.out.print(" | " + Block.text_STOP.name() + "    | ");
                        break;
                    case text_WALL:
                        g.drawImage(images.text_WALL, 191 + x*24, y*24, 24, 24, this);
                        //System.out.print(" | " + Block.text_WALL.name() + "    | ");
                        break;
                    case text_ROCK:
                        g.drawImage(images.text_ROCK, 191 + x*24, y*24, 24, 24, this);
                        //System.out.print(" | " + Block.text_ROCK.name() + "    | ");
                        break;
                    case text_PUSH:
                        g.drawImage(images.text_PUSH, 191 + x*24, y*24, 24, 24, this);
                        //System.out.print(" | " + Block.text_PUSH.name() + "    | ");
                        break;
                    case object_BABA:
                        g.drawImage(images.object_BABA, 191 + x*24, y*24, 24, 24, this);
                        //System.out.print(" | " + Block.object_BABA.name() + "  | ");
                        break;
                    case object_FLAG:
                        g.drawImage(images.object_FLAG, 191 + x*24, y*24, 24, 24, this);
                        //System.out.print(" | " + Block.object_FLAG.name() + "  | ");
                        break;
                    case object_WALL:
                        g.drawImage(images.object_WALL_noC, 191 + x*24, y*24, 24, 24, this);
                        //System.out.print(" | " + Block.object_WALL.name() + "  | ");
                        /*if(b[x-1][y] == Block.object_ROCK && b[x+1][y] == Block.object_ROCK && b[x][y-1] == Block.object_ROCK && b[x][y+1] == Block.object_ROCK)
                        {
                            //Wall with 4 connections
                        }
                        else if(b[x-1][y] == Block.object_ROCK && b[x+1][y] == Block.object_ROCK && b[x][y-1] == Block.object_ROCK && b[x][y+1] != Block.object_ROCK)
                        {
                            //Wall missing connection on bottom.
                        }
                        else if(b[x-1][y] == Block.object_ROCK && b[x+1][y] == Block.object_ROCK && b[x][y-1] != Block.object_ROCK && b[x][y+1] == Block.object_ROCK)
                        {
                            //Wall missing connection on top.
                        }
                        else if(b[x-1][y] == Block.object_ROCK && b[x+1][y] != Block.object_ROCK && b[x][y-1] == Block.object_ROCK && b[x][y+1] == Block.object_ROCK)
                        {
                            //Wall missing connection on right.
                        }
                        else if(b[x-1][y] != Block.object_ROCK && b[x+1][y] == Block.object_ROCK && b[x][y-1] == Block.object_ROCK && b[x][y+1] == Block.object_ROCK)
                        {
                            //Wall missing connection on left.
                        }
                        else if(b[x-1][y] != Block.object_ROCK && b[x+1][y] == Block.object_ROCK && b[x][y-1] != Block.object_ROCK && b[x][y+1] == Block.object_ROCK)
                        {
                            //Wall missing connection on left & top.
                        }
                        else if(b[x-1][y] != Block.object_ROCK && b[x+1][y] == Block.object_ROCK && b[x][y-1] == Block.object_ROCK && b[x][y+1] != Block.object_ROCK)
                        {
                            //Wall missing connection on left & bottom.
                        }
                        else if(b[x-1][y] == Block.object_ROCK && b[x+1][y] != Block.object_ROCK && b[x][y-1] != Block.object_ROCK && b[x][y+1] == Block.object_ROCK)
                        {
                            //Wall missing connection on right & top.
                        }
                        else if(b[x-1][y] == Block.object_ROCK && b[x+1][y] != Block.object_ROCK && b[x][y-1] == Block.object_ROCK && b[x][y+1] != Block.object_ROCK)
                        {
                            //Wall missing connection on right & bottom.
                        }
                        else if(b[x-1][y] != Block.object_ROCK && b[x+1][y] != Block.object_ROCK && b[x][y-1] == Block.object_ROCK && b[x][y+1] == Block.object_ROCK)
                        {
                            //Wall missing connection on left & right.
                        }
                        else if(b[x-1][y] == Block.object_ROCK && b[x+1][y] == Block.object_ROCK && b[x][y-1] != Block.object_ROCK && b[x][y+1] != Block.object_ROCK)
                        {
                            //Wall missing connection on top & bottom.
                        }
                        else if(b[x-1][y] == Block.object_ROCK && b[x+1][y] != Block.object_ROCK && b[x][y-1] != Block.object_ROCK && b[x][y+1] != Block.object_ROCK)
                        {
                            //Wall missing connection on all but left.
                        }
                        else if(b[x-1][y] != Block.object_ROCK && b[x+1][y] == Block.object_ROCK && b[x][y-1] != Block.object_ROCK && b[x][y+1] != Block.object_ROCK)
                        {
                            //Wall missing connection on all but right.
                        }
                        else if(b[x-1][y] != Block.object_ROCK && b[x+1][y] != Block.object_ROCK && b[x][y-1] != Block.object_ROCK && b[x][y+1] != Block.object_ROCK)
                        {
                            //Wall missing connection on all but top.
                        }
                        else if(b[x-1][y] != Block.object_ROCK && b[x+1][y] != Block.object_ROCK && b[x][y-1] != Block.object_ROCK && b[x][y+1] == Block.object_ROCK)
                        {
                            //Wall missing connection on all but bottom.
                        }*/
                            
                        break;
                    case object_ROCK:
                        g.drawImage(images.object_ROCK, 191 + x*24, y*24, 24, 24, this);
                        //System.out.print(" | " + Block.object_ROCK.name() + "  | ");
                        break;
                    default:
                        break;
                }
            }
            //System.out.println("");
        }
    }
}
