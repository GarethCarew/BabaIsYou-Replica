/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babaisyou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    private ArrayList<String> stop = new ArrayList<>();
    private ArrayList<String> push = new ArrayList<>();
    private ArrayList<String> win = new ArrayList<>();
    
    private ArrayList<String> cords_text = new ArrayList<>();
    private ArrayList<String> cords_obj = new ArrayList<>();
    private ArrayList<String> cords_is = new ArrayList<>();
    
    private Boolean won = false;
    
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