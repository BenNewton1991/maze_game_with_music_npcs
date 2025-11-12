import java.util.Scanner; 

public class Maze 
{
    String[][] maze = new String[16][16];
    int x_loc; 
    int y_loc; 
    int goal_x;
    int goal_y;
    Scanner scanner = new Scanner(System.in);
    String user_input;
    NPC npc_1;
    NPC npc_2;

    

    public Maze()
    {
        for (int i = 0; i < maze.length; i++)
        {
            for (int j = 0; j < maze[i].length; j++)
            {
                maze[i][j] = "#";
            }
        }

        int x = (int) (Math.random() * 16);
        int y = (int) (Math.random() * 16);
        maze[x][y] = "0";
        this.x_loc = x; 
        this.y_loc = y;

        
        this.goal_x = (int) (Math.random() * 16);
        this.goal_y = (int) (Math.random() * 16);

        while (goal_x == x_loc && goal_y == y_loc)
        {
            this.goal_x = (int) (Math.random() * 16);
            this.goal_y = (int) (Math.random() * 16);
        }

        maze[goal_x][goal_y] = "G";

    //NPC constructor(int health, String name, String token, int x, int y)

    int npc_1_x_loc = (int) (Math.random() * 16);
    int npc_1_y_loc = (int) (Math.random() * 16);
    
    while ((npc_1_x_loc == goal_x && npc_1_y_loc == goal_y) ||
    (npc_1_x_loc == x_loc && npc_1_y_loc == y_loc))
    {
        npc_1_x_loc = (int) (Math.random() * 16);
        npc_1_y_loc = (int) (Math.random() * 16);
    }
    //NPC constructor(int health, String name, String token, int x, int y)
    npc_1 = new NPC(10, "WALRUS", "W", npc_1_x_loc, npc_1_y_loc);

    int npc_2_x_loc = (int) (Math.random() * 16);
    int npc_2_y_loc = (int) (Math.random() * 16);
    
    while ((npc_2_x_loc == goal_x && npc_2_y_loc == goal_y) ||
    (npc_2_x_loc == x_loc && npc_2_y_loc == y_loc) || 
    (npc_2_x_loc == npc_1_x_loc && npc_2_y_loc == npc_1_y_loc))
    {
        npc_2_x_loc = (int) (Math.random() * 16);
        npc_2_y_loc = (int) (Math.random() * 16);
    }
    //NPC constructor(int health, String name, String token, int x, int y)
    npc_2 = new NPC(10, "SQUIRREL", "S", npc_2_x_loc, npc_2_y_loc);

    maze[npc_1.get_x()][npc_1.get_y()] = npc_1.get_token();
    maze[npc_2.get_x()][npc_2.get_y()] = npc_2.get_token();

}


    public void print_maze()
    {
        for (int i = 0; i < maze.length; i++)
        {
            for (int j = 0; j < maze[i].length; j++)
            {
                System.out.print(maze[i][j]);
            }

            System.out.println("");
        }
        System.out.println("-----------------");
    }

    public void user_int()
    {
        System.out.println("Welcome to maze game!");
        System.out.println("The circle represents your character");
        System.out.println("Your goal is to progress towards the goal");
        System.out.println("To move up press w, down s, left, a, right d");

        this.print_maze();

        while (x_loc != goal_x || y_loc != goal_y)
        {
            this.user_input = scanner.nextLine();
            while (!user_input.equals("w") && !user_input.equals("s") && !user_input.equals("a") && !user_input.equals("d"))
            {
                System.out.print("enter w, s, a, or d");
                this.user_input = scanner.nextLine();
            }
            if (this.user_input.equals("w"))
            {
                move_up();
            }
            else if (this.user_input.equals("s"))
            {
                move_down();
            }
            else if (this.user_input.equals("a"))
            {
                move_left();
            }
            else
            {
                move_right();
            }

            // Random character movement needs to use Math.random()
            // Currently both just move up/down respecively

            

            // Edit this for interaction with enemies. 
            // Can add some conditions, further dialgoue, etc. 
            // Could add points for killing enemies, etc. 
            // Could add fight simulation. 
            // How could you change this so it works within given character range?
            if (x_loc == npc_1.get_x() && y_loc == npc_1.get_y())
            {
                npc_1.dialogue_1();
                npc_1.dialogue_2();
                npc_1.die();
            }

            if (x_loc == npc_2.get_x() && y_loc == npc_2.get_y())
            {
                npc_2.dialogue_1();
                npc_2.dialogue_2();
                npc_2.die();
            }

            

            if (x_loc == goal_x && y_loc == goal_y)
            {
                System.out.print("You WIN!");
                break;
            }

        } 
       

        
    }

    
    public void move_up()
    {
        if (x_loc > 0)
        {
            x_loc --;

            maze[x_loc+1][y_loc] = "#";
            maze[x_loc][y_loc] = "0";
            print_maze();
        }
    }

    public void move_down()
    {
        if (x_loc < 15)
        {
            x_loc ++;

            maze[x_loc-1][y_loc] = "#";
            maze[x_loc][y_loc] = "0";
            print_maze();
        }
    }

    public void move_left()
    {
        if (y_loc > 0)
        {
            y_loc --;
            maze[x_loc][y_loc+1] = "#";
            maze[x_loc][y_loc] = "0";
            print_maze();
        }
    }

    public void move_right()
    {
        if (y_loc < 15)
        {
            y_loc ++;
            maze[x_loc][y_loc-1] = "#";
            maze[x_loc][y_loc] = "0";
            print_maze();
        }
    }
}