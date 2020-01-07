/* a
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babaisyou;

import java.util.TreeMap;

/**
 *
 * @author scien
 */
class Mover {

    void moveLeft(TreeMap<String,Level> LevelList, String currentLevel) {
        Block[][] map = LevelList.get(currentLevel).getMap();
        
        for(int x = 0; x < map.length; x++)
        {
            for(int y = 0; y < map[x].length; y++)
            {
                if(x > 2 && y > 2)
                {
                    if(check(map, x, y, Block.text_YOU))
                    {
                        if(check(map, x-1, y, Block.text_IS))
                        {
                            if(check(map, x-2, y, Block.text_BABA))
                            {

                            }
                            else if(check(map, x-2, y, Block.text_ROCK))
                            {

                            }
                            else if(check(map, x-2, y, Block.text_FLAG))
                            {

                            }
                        }
                    }
                }
            }
        }
    }

    private boolean check(Block[][] map, int x, int y, Block block) {

        if(map[x][y] == block)
            return true;
        return false;
        
    }
    
}
