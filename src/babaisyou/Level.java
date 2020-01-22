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
    
    private Block[][][] map;
    
    public Level()
    {
        map = new Block[0][0][5];
    }
    
    public Level(int xSize, int ySize)
    {
        map = new Block[ ySize ][ xSize ][5];
        
        for(int y = 0; y < map.length; y++)
        {
            for(int x = 0; x < map[y].length; x++)
            {
                map[y][x][0] = Block.EMPTY;
            }
        }
    }
    
    public void addBlock(Block b, int xPos, int yPos)
    {
        int i = 0;
        
        while(map[yPos][xPos][i] != null)
        {
            i++;
        }
        map[yPos][xPos][i] = b;
    }

    public Block[][][] getMap()
    {
        return map;
    }

    public void setMap(Block[][][] map)
    {
        this.map = map;
    }
    
    
}
