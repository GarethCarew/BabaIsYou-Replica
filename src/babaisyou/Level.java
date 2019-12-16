/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babaisyou;

import java.io.Serializable;

/**
 *
 * @author scien
 */
class Level implements Serializable{
    
    private Block[][] map;
    private String name;
         
    public Level()
    {
        name = "00";
        map = new Block[0][0];
    }
    
    public Level(String levName, int xSize, int ySize)
    {
        name = levName;
        map = new Block[xSize][ySize];

    }
    
    public void addBlock(Block b, int xPos, int yPos)
    {
        map[yPos][xPos] = b;
    }

    public Block[][] getMap() {
        for (int x = 0; x < map.length; x++)
        {
            for(int y = 0; y < map[x].length; y++)
            {
                if(map[x][y] == null)
                {
                    map[x][y] = Block.object_EMPTY;
                }
            }
        }
        return map;
    }

    public void setMap(Block[][] map) {
        this.map = map;
    }
    
    public String getName()
    {
        return name;
    }
}
