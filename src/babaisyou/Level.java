/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.a
 */
package babaisyou;


/**
 *
 * @author scien
 */
class Level
{
    
    private Block[][] map;

    private String[][] properties;
         
    public Level()
    {
        map = new Block[0][0];
        properties = new String[0][0];
    }
    
    public Level(int xSize, int ySize)
    {
        map         = new Block[    xSize ][ ySize ];
        properties  = new String[   xSize ][ ySize ];
    }
    
    public void addBlock(Block b, int xPos, int yPos)
    {
        map[yPos][xPos] = b;
    }

    public Block[][] getMap()
    {
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

    public void setMap(Block[][] map)
    {
        this.map = map;
    }
    
    
}
