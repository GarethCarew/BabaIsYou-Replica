/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babaisyou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author scien
 */
class Mover {

    private ArrayList<String> noun = new ArrayList<>( Arrays.asList( "text_BABA", "text_FLAG", "text_WALL", "text_ROCK" ) );
    private ArrayList<String> verb = new ArrayList<>( Arrays.asList( "text_YOU", "text_WIN", "text_STOP", "text_PUSH" ) );
    
    private ArrayList<Scanner> you = new ArrayList<>();
    private ArrayList<Scanner> stop = new ArrayList<>();
    private ArrayList<Scanner> push = new ArrayList<>();
    
    private ArrayList<String> cords_text = new ArrayList<>();
    private ArrayList<String> cords_obj = new ArrayList<>();
    private ArrayList<String> cords_is = new ArrayList<>();
    
    private Block[][] map;
    
    void moveRight( TreeMap<String,Level> LevelList, String currentLevel )
    {
        long timeElapsed = System.nanoTime();

        addCords( LevelList, currentLevel );

        checkEachIs();

        moveReal( "right" );

        long timeElapsed2 = System.nanoTime();

        System.out.println( timeElapsed2 - timeElapsed );
    }
    
    void moveLeft(TreeMap<String,Level> LevelList, String currentLevel)
    {
        long timeElapsed = System.nanoTime();

            addCords( LevelList, currentLevel );

            checkEachIs();
            
            moveReal( "left" );
            
            long timeElapsed2 = System.nanoTime();

            System.out.println( timeElapsed2 - timeElapsed );

    }
    
    void moveUp( TreeMap<String,Level> LevelList, String currentLevel )
    {
        long timeElapsed = System.nanoTime();

        addCords( LevelList, currentLevel );

        checkEachIs();

        moveReal( "up" );

        long timeElapsed2 = System.nanoTime();

        System.out.println( timeElapsed2 - timeElapsed );
    }

    void moveDown( TreeMap<String,Level> LevelList, String currentLevel )
    {
        long timeElapsed = System.nanoTime();

        addCords( LevelList, currentLevel );

        checkEachIs();

        moveReal( "down" );

        long timeElapsed2 = System.nanoTime();

        System.out.println( timeElapsed2 - timeElapsed );
    }
    
    private Scanner checkValidIs(String s)
    {
        Scanner scan = new Scanner( s );

        String type = scan.next();
        int x = scan.nextInt();
        int y = scan.nextInt();
        
        if( x > 0 && x < map.length )
        {
            if( noun.contains( map[x][y - 1].name() ) && verb.contains( map[x][y + 1].name() ) )
            {
                Scanner output = new Scanner( map[x][y - 1].name() + " " + map[x][y + 1].name() + " " + x + " " + y);
                return output;
            }
            else if( noun.contains( map[x - 1][y].name() ) && verb.contains( map[x + 1][y].name() ) )
            {
                Scanner output = new Scanner( map[x - 1][y].name() + " " + map[x + 1][y].name() + " " + x + " " + y);
                return output;
            }
        }
        return null;
    }

    private void addProp(String n, int x, int y)
    {
        switch(n)
        {
            case "text_YOU":
                you.add( new Scanner( x + " " + y ) );
                break;
            case "text_STOP":
                stop.add( new Scanner( x + " " + y ) );
                break;
            default:
                System.out.println("ERROR type not found");
        }
    }
    
    public Block[][] getMap()
    {
        return map;
    }

    private void addCords(TreeMap<String, Level> LevelList, String currentLevel)
    {
        map = LevelList.get( currentLevel ).getMap();

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
    }

    private void moveReal(String movement)
    {
        switch( movement )
        {
            case "right":
                for( Scanner s : you )
                {
                    int x = s.nextInt();
                    int y = s.nextInt();

                    for(Scanner ss : stop )
                    {
                        System.out.println( ss );
                    }
                    if( !stop.contains( new Scanner( x + " " + ( y + 1 ) ) ) && ( y < map[0].length - 1 ) )
                    {
                        map[x][y + 1] = map[x][y];
                        map[x][y] = Block.object_EMPTY;
                    }
                }
                break;

            case "left":
                for( Scanner s : you )
                {
                    int x = s.nextInt();
                    int y = s.nextInt();

                    if( !stop.contains( new Scanner( x + " " + ( y - 1 ) ) ) && ( y > 0 ) )
                    {
                        map[x][y - 1] = map[x][y];
                        map[x][y] = Block.object_EMPTY;
                    }
                }
                break;
            case "up":
                for( Scanner s : you )
                {
                    int x = s.nextInt();
                    int y = s.nextInt();

                    if( !stop.contains( new Scanner( ( x - 1 ) + " " + y ) ) && ( x > 0 ) )
                    {
                        map[x - 1][y] = map[x][y];
                        map[x][y] = Block.object_EMPTY;
                    }
                }
                break;
            case "down":
                for( Scanner s : you )
                {
                    int x = s.nextInt();
                    int y = s.nextInt();

                    if( !stop.contains( new Scanner( ( x + 1 ) + " " + y ) ) && ( x < map.length - 1 ) )
                    {
                        map[x + 1][y] = map[x][y];
                        map[x][y] = Block.object_EMPTY;
                    }
                }
                break;
        }
        
    }
}


/*
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