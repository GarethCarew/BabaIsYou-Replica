/* a
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babaisyou;

import java.awt.Graphics;
import java.io.IOException;

/**
 *
 * @author scien
 */
public class LevelUpdater {
    
    private final Graphics g;
    private final Images images;

    public LevelUpdater() throws IOException {
        g = null;
        images = new Images();
    }

    public LevelUpdater(Graphics g) throws IOException {
        this.g = g;
        images = new Images();
    }

    public void updateLevel(Block[][] map)
    {
        for (int x = 0; x < map.length; x++)
        {
            for(int y = 0; y < map[x].length; y++)
            {
                if(null != map[x][y])
                    switch (map[x][y]) {
                    case object_BABA:
                        g.drawImage(images.object_BABA, x*24, y*24, 24, 24, null);
                        break;
                    case object_EMPTY:
                        g.drawImage(images.object_EMPTY, x*24, y*24, 24, 24, null);
                        break;
                    case object_FLAG:
                        g.drawImage(images.object_FLAG, x*24, y*24, 24, 24, null);
                        break;
                    case object_ROCK:
                        g.drawImage(images.object_ROCK, x*24, y*24, 24, 24, null);
                        break;
                    case object_WALL:
                        g.drawImage(images.object_WALL, x*24, y*24, 24, 24, null);
                        break;
                    case text_BABA:
                        g.drawImage(images.text_BABA, x*24, y*24, 24, 24, null);
                        break;
                    case text_FLAG:
                        g.drawImage(images.text_FLAG, x*24, y*24, 24, 24, null);
                        break;
                    case text_IS:
                        g.drawImage(images.text_IS, x*24, y*24, 24, 24, null);
                        break;
                    case text_PUSH:
                        g.drawImage(images.text_PUSH, x*24, y*24, 24, 24, null);
                        break;
                    case text_ROCK:
                        g.drawImage(images.text_ROCK, x*24, y*24, 24, 24, null);
                        break;
                    case text_STOP:
                        g.drawImage(images.text_STOP, x*24, y*24, 24, 24, null);
                        break;
                    case text_WALL:
                        g.drawImage(images.text_WALL, x*24, y*24, 24, 24, null);
                        break;
                    case text_WIN:
                        g.drawImage(images.text_WIN, x*24, y*24, 24, 24, null);
                        break;
                    case text_YOU:
                        g.drawImage(images.text_YOU, x*24, y*24, 24, 24, null);
                        break;
                    default:
                        break;
                }
            }
        }
    } 
}
