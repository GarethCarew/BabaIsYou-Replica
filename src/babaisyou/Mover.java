/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babaisyou;

//import java.text.DecimalFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author scien
 */
class Mover {

    private final ArrayList<  Block  >   nouns       = new ArrayList<>( Arrays.asList( Block.text_BABA, Block.text_FLAG, Block.text_WALL, Block.text_ROCK         ));
    private final ArrayList<  Block  >   verbs       = new ArrayList<>( Arrays.asList( Block.text_YOU, Block.text_WIN, Block.text_STOP, Block.text_PUSH           ));
    private final ArrayList<  Block  >   objects      = new ArrayList<>( Arrays.asList( Block.object_BABA, Block.object_FLAG, Block.object_ROCK, Block.object_WALL));
    
    private ArrayList<  int[]  >   toBeMoved   = new ArrayList<>();
    private ArrayList<  Block  >   you         = new ArrayList<>();
    private ArrayList<  Block  >   stop        = new ArrayList<>();
    private ArrayList<  Block  >   push        = new ArrayList<>();
    private ArrayList<  Block  >   win         = new ArrayList<>();
    
    private Boolean                 won         = false;
    
    private Block[][][]             map;
   
    Mover(Level lev)
    {
        setMap(lev.getMap());

        findProps();
        getTBM();
    }
    
    public void move (String dir)
    {
        switch (dir)
        {
            case "up":
                go("up");
                break;
            case "down":
                go("down");
                break;
            case "left":
                go("left");
                break;
            case "right":
                go("right");
                break;
        }
    }

    public Block[][][] getMap() 
    {
        return map;
    }

    private void setMap(Block[][][] map) 
    {
        this.map = map;
    }

    private boolean hasProp(Block b, Block prop)
    {
        boolean has = false;
        
        switch (prop) {
            case text_YOU:
                if(you.contains(b))
                    has = true;
                break;
            case text_PUSH:
                if(push.contains(b))
                    has = true;
                break; 
            case text_STOP:
                if(stop.contains(b))
                    has = true;
                break;
            case text_WIN:
                if(win.contains(b))
                    has = true;
            default:
                break;
        }
        
        return has;
    }

    private void findProps()
    {
        for(int y = 0; y < map.length; y++)
        {
            for(int x = 0; x < map[y].length; x++)
            {
                for(int z = 0; z < map[y][x].length; z++)
                {
                    if(map[y][x][z] == Block.text_IS)
                    {
                        Block up = null;
                        Block down = null;
                        Block left = null;
                        Block right = null;
                        
                        for(int t = 0; t < 5; t++)
                        {
                            if(map[y-1][x][t] != null)
                            {
                                if(map[y-1][x][t].toString().contains("text_"))
                                    up = map[y-1][x][t];
                            }
                            if(map[y+1][x][t] != null)
                            {
                                if(map[y+1][x][t].toString().contains("text_"))
                                    down = map[y+1][x][t];
                            }
                            if(map[y][x-1][t] != null)
                            {
                                if(map[y][x-1][t].toString().contains("text_"))
                                    left = map[y][x-1][t];
                            }
                            if(map[y][x+1][t] != null)
                            {
                                if(map[y][x+1][t].toString().contains("text_"))
                                    right = map[y][x+1][t];
                            }
                        }

                        if(up != null && down != null)
                        {
                            addProp(up, down);
                        }
                        
                        if(left != null && right != null)
                        {
                            addProp(left, right);
                        }
                    }
                }
            }
        }
    }

    private void addProp(Block obj, Block prop) {
        Block toBeAdded = null;

        switch (obj)
        {
            case text_BABA:
                toBeAdded = Block.object_BABA;
                break;
            case text_WALL:
                toBeAdded = Block.object_WALL;
                break;
            case text_ROCK:
                toBeAdded = Block.object_ROCK;
                break;
            case text_FLAG:
                toBeAdded = Block.object_FLAG;
                break;
            default:
                break;
        }

        switch (prop)
        {
            case text_YOU:
                you.add(toBeAdded);
                break;
            case text_STOP:
                stop.add(toBeAdded);
                break;
            case text_PUSH:
                push.add(toBeAdded);
                break;
            case text_WIN:
                win.add(toBeAdded);
                break;
            default:
                break;
        }
    }

    private boolean canGo(String dir, int x, int y) {
        boolean canMove = true;
        
        if(isStopped(dir, x, y))
            canMove = false;
        if(onEdge(dir, x, y))
            canMove = false;
        return canMove;
    }
    
    private void go(String dir) {
        Block b = null;
        
        int x, y, z = 0;

        int[] coords = new int[3];
        
        Iterator it = toBeMoved.iterator();
        
        while(it.hasNext())
        {
            coords = (int[])it.next();
            x = coords[0];
            y = coords[1];
            z = coords[2];
            
            if(canGo(dir, x, y))
            {
                b = map[y][x][z];

                map[y][x][z] = null; //after basics is done add optimization: move all other blocks on that Z-coord down.

                z = 0;

                switch (dir)
                {
                    case "up":
                        y--;
                        break;
                    case "down":
                        y++;
                        break;
                    case "left":
                        x--;
                        break;
                    case "right":
                        x++;
                        break;
                    default:
                        break;
                }

                while(map[y][x][z] != null)
                {
                    z++;
                }
                map[y][x][z] = b;
            }
        }
    }

    private boolean onEdge(String dir, int x, int y) {
        boolean isOnEdge = false;
        switch(dir)
        {
            case "up":
                if(y == 0)
                    isOnEdge = true;
                break;
            case "down":
                if(y == map.length)
                    isOnEdge = true;
                break;
            case "left":
                if(x == 0)
                    isOnEdge = true;
                break;
            case "right":
                if(x == map[y].length)
                    isOnEdge = true;
                break;
        }
        return isOnEdge;
    }

    private boolean isStopped(String dir, int x, int y) {
        boolean isBeingStopped = false;
        for(int z = 0; z < 5; z++)
        {
            switch(dir)
            {
                case "up":
                    if(stop.contains(map[y-1][x][z]))
                        isBeingStopped = true;
                    break;
                case "down":
                    if(stop.contains(map[y+1][x][z]))
                        isBeingStopped = true;
                    break;
                case "left":
                    if(stop.contains(map[y][x-1][z]))
                        isBeingStopped = true;
                    break;
                case "right":
                    if(stop.contains(map[y][x+1][z]))
                        isBeingStopped = true;
                    break;
            }
        }
        return isBeingStopped;
    }

    private void getTBM() {
        for(int i = 0; i < you.size(); i ++)
        {
            for(int y = 0; y < map.length; y++)
            {
                for(int x = 0; x <map[y].length; x++)
                {
                    for(int z = 0; z < map[y][x].length; z++)
                    {
                        if(map[y][x][z] == you.get(i))
                        {
                            toBeMoved.add(new int[] {x,y,z});
                        }
                    }
                }
            }
        }
    }

}
    
    /*||||||||||||||||MOVE V2.0|||||||||||||||||||||||||||||||||||||||||||||||||
    void moveRight( TreeMap< String, Level > LevelList, String currentLevel )
    {
        addCords( LevelList, currentLevel );

        checkEachIs();

        moveReal( "right" );
    }
     
    void moveLeft( TreeMap< String, Level > LevelList, String currentLevel)
    {
        addCords( LevelList, currentLevel );

        checkEachIs();

        moveReal( "left" );
    }
    
    void moveUp( TreeMap< String, Level > LevelList, String currentLevel )
    {
        addCords( LevelList, currentLevel );

        checkEachIs();

        moveReal( "up" );
    }

    void moveDown( TreeMap< String, Level > LevelList, String currentLevel )
    {
        addCords( LevelList, currentLevel );

        checkEachIs();

        moveReal( "down" );
    }
    
    private Scanner checkValidIs( String s )
    {
        Scanner scan    = new Scanner( s );
        String  temp    = "";
        Scanner output  = null;

        String  type    = scan.next();
        int     x       = scan.nextInt();
        int     y       = scan.nextInt();

        if( x > 0 && x < map.length )
        {
            
            if( noun.contains( map[x][y - 1].toString() ) && verb.contains( map[x][y + 1].toString() ) )                                //compares if a noun and verb are horizontally next to an IS
            {
                temp += ( map[x][y - 1].toString() + " " + map[x][y + 1].toString());
            }
            else if( noun.contains( map[x - 1][y].toString() ) && verb.contains( map[x + 1][y].toString() ) )                           //compares if a noun and a verb are vertically next to an IS
            {
                temp += ( map[x - 1][y].toString() + " " + map[x + 1][y].toString());
            }
        }
        if( !temp.equals( "" ) )
            output = new Scanner( temp );

        return output;
    }

    private void addProp(String n, int x, int y)
    {
        switch(n)
        {
            case "text_YOU":
                you.add( new Scanner( x + " " + y ) );
                break;
            case "text_STOP":
                stop.add( x + " " + y );
                break;
            case "text_PUSH":
                push.add( x + " " + y );
                break;
            case "text_WIN":
                win.add( x + " " + y );
                break;
            default:
                System.out.println( "ERROR type not found: " + n );
        }
    }
    
    public Block[][][] getMap()
    {
        return map;
    }

    private void addCords(TreeMap<String, Level> LevelList, String currentLevel)
    {
        map = LevelList.get( currentLevel ).getMap();

            for( int y = 0; y < map.length; y++ )
            {
                for( int x = 0; x < map[y].length; x++ )
                {
                    for( int z = 0; z < map[y][x].length; z++)
                    {
                        if(map[y][x][z] == Block.text_IS )
                        {
                            cords_is.add("text_IS " + y + " " + x);
                        }
                        else if(map[y][x][z].toString().contains( "text" ) )
                        {
                            cords_text.add(map[y][x][z].toString() + " " + y + " " + x );
                        }
                        else if(map[y][x][z].toString().contains( "object" ) )
                        {
                            cords_obj.add(map[y][x][z].toString() + " " + y + " " + x );
                        }
                    }
                }
            }
    }

    private void checkEachIs()
    {
        for( String s : cords_is )
            {
                Scanner scan = checkValidIs( s );
                if( scan != null )
                {
                    scan.useDelimiter( "_" );
                    scan.next();
                    scan.useDelimiter( " " );

                    String v = scan.next();                                     //v == verb
                    String n = scan.next();                                     //n == noun

                    String v2 = "";
                    String n2 = "";

                    if( scan.hasNext() )                                        //if there is a next, then there MUST be a vertical IS aswell
                    {
                        scan.useDelimiter( "_" );
                        scan.next();
                        scan.useDelimiter( " " );

                        v2 = scan.next();                                       //v == verb
                        n2 = scan.next();                                       //n == noun
                    }
                    
                    for( String o : cords_obj )
                    {
                        Scanner temp = new Scanner( o );

                        temp.useDelimiter( "_" );
                        temp.next();
                        temp.useDelimiter( " " );
                        String check = temp.next();

                        int x = temp.nextInt();
                        int y = temp.nextInt();
                        
                        if( check.equals( v ) )
                        {
                            addProp( n, x, y );
                        }
                        if( check.equals( v2 ) )
                        {
                            addProp( n2, x, y );
                        }
                    }
                }
                
                Scanner scan2 = new Scanner( s );

                scan2.next();
                int x = scan2.nextInt();
                int y = scan2.nextInt();

                push.add( x + " " + y );
            }
        
        for( String s : cords_text )
        {
            Scanner scan = new Scanner( s );
            
            scan.next();
            int x = scan.nextInt();
            int y = scan.nextInt();
            
            push.add( x + " " + y );
        }
    }

    private void moveReal(String movement)
    {
        ArrayList<Scanner> pushing = new ArrayList<>();
        switch( movement )
        {
            case "right":
                for( Scanner s : you )
                {
                    int x = s.nextInt();
                    int y = s.nextInt();

                    pushing.add( new Scanner( x + " " + y ) );

                    while( true )
                    {
                        if( win.contains ( x + " " + ( y + 1 ) ) )
                        {
                            won = true;
                            break;
                        }
                        else if( push.contains( x + " " + ( y + 1 ) ) )
                        {
                            pushing.add( new Scanner( x + " " + ( y + 1 ) ) );
                            y++;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                
                Collections.reverse( pushing );
                for( Scanner s : pushing )
                {
                    int x = s.nextInt();
                    int y = s.nextInt();

                    if( !stop.contains( x + " " + ( y + 1 ) ) && ( y < map[0].length - 1 ) )
                    {
                        map[x][y + 1] = map[x][y];
                        map[x][y] = Block.object_EMPTY;
                    }
                    else
                    {
                        stop.add( x + " " + y );
                    }
                }
                break;

            case "left":
                for( Scanner s : you )
                {
                    int x = s.nextInt();
                    int y = s.nextInt();

                    pushing.add( new Scanner( x + " " + y ) );

                    while( true )
                    {
                        if( win.contains ( x + " " + ( y - 1 ) ) )
                        {
                            won = true;
                            break;
                        }
                        else if( push.contains( x + " " + ( y - 1 ) ) )
                        {
                            pushing.add( new Scanner( x + " " + ( y - 1 ) ) );
                            y--;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                
                Collections.reverse( pushing );
                for( Scanner s : pushing )
                {
                    int x = s.nextInt();
                    int y = s.nextInt();

                    if( !stop.contains( x + " " + ( y - 1 ) ) && ( y > 0 ) )
                    {
                        map[x][y - 1] = map[x][y];
                        map[x][y] = Block.object_EMPTY;
                    }
                    else
                    {
                        stop.add( x + " " + y );
                    }
                }
                break;

            case "up":
                for( Scanner s : you )
                {
                    int x = s.nextInt();
                    int y = s.nextInt();

                    pushing.add( new Scanner( x + " " + y ) );

                    while( true )
                    {
                        if( win.contains ( ( x - 1 ) + " " + y ) )
                        {
                            won = true;
                            break;
                        }
                        else if( push.contains( ( x - 1 ) + " " + y ) )
                        {
                            pushing.add( new Scanner( ( x - 1 ) + " " + y ) );
                            x--;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                
                Collections.reverse( pushing );
                for( Scanner s : pushing )
                {
                    int x = s.nextInt();
                    int y = s.nextInt();

                    if( !stop.contains( ( x - 1 ) + " " + y ) && ( x > 0 ) )
                    {
                        map[x - 1][y] = map[x][y];
                        map[x][y] = Block.object_EMPTY;
                    }
                    else
                    {
                        stop.add( x + " " + y );
                    }
                }
                break;

            case "down":
                for( Scanner s : you )
                {
                    int x = s.nextInt();
                    int y = s.nextInt();

                    pushing.add( new Scanner( x + " " + y ) );

                    while( true )
                    {
                        if( win.contains ( ( x + 1 ) + " " + y ) )
                        {
                            won = true;
                            break;
                        }
                        else if( push.contains( ( x + 1 ) + " " + y ) )
                        {
                            pushing.add( new Scanner( ( x + 1 ) + " " + y ) );
                            x++;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                
                 Collections.reverse( pushing );
                for( Scanner s : pushing )
                {
                    int x = s.nextInt();
                    int y = s.nextInt();

                    if( !stop.contains( ( x + 1 ) + " " + y ) && ( x < map.length ) )
                    {
                        map[x + 1][y] = map[x][y];
                        map[x][y] = Block.object_EMPTY;
                    }
                    else
                    {
                        stop.add( x + " " + y );
                    }
                }
                break;
        }
    }
    
    public Boolean hasWon()
    {
        return won;
    }
    
}
*/



/* |||||||||||||||MOVE V 1.0||||||||||||||||||||||||||||||||||||||||||||||||||||
void moveRight( TreeMap<String,Level> LevelList, String currentLevel )
        {
        
            ArrayList<String> cords_text = new ArrayList<>();
            ArrayList<String> cords_obj = new ArrayList<>();
            ArrayList<String> cords_is = new ArrayList<>();

            map = LevelList.get( currentLevel ).getMap();

            long timeElapsed = System.nanoTime();

            for( int i = 0; i < map.length; i++ )
            {
                for( int e = 0; e < map[i].length; e++ )
                {
                    if( !map[i][e].name().equals( "object_EMPTY" ) && map[i][e].name().equals( "text_IS" ) )
                    {
                        cords_is.add(map[i][e].name() + " " + i + " " + e );
                    }
                    else if( !map[i][e].name().equals( "object_EMPTY" ) && map[i][e].name().contains( "text" ) )
                    {
                        cords_text.add(map[i][e].name() + " " + i + " " + e );
                    }
                    else if( !map[i][e].name().equals( "object_EMPTY" ) && map[i][e].name().contains( "object" ) )
                    {
                        cords_obj.add(map[i][e].name() + " " + i + " " + e );
                    }
                }
            }

            for( String s : cords_is )
            {
                Scanner scan = checkValidIs( s );
                if( scan != null )
                {
                    scan.useDelimiter( "_" );
                    scan.next();
                    scan.useDelimiter( " " );
                    String v = scan.next();                                     //v == verb
                    
                    
                    String n = scan.next();                                     //n == noun
                    
                    for( String o : cords_obj )
                    {
                        Scanner temp = new Scanner( o );

                        temp.useDelimiter( "_" );
                        temp.next();
                        temp.useDelimiter( " " );
                        String check = temp.next();

                        int x = temp.nextInt();
                        int y = temp.nextInt();
                        
                        if( check.equals( v ) )
                        {
                            addProp( n, x, y );
                        }
                    }
                }
            }
            
            for( Scanner s : you )
            {
                int x = s.nextInt();
                int y = s.nextInt();

                if( !stop.contains( new Scanner( x + " " + ( y + 1 ) ) ) )
                {
                    map[x][y + 1] = map[x][y];
                    map[x][y] = Block.object_EMPTY;
                }
            }

            long timeElapsed2 = System.nanoTime();

            System.out.println( timeElapsed2 - timeElapsed );
    }
*/