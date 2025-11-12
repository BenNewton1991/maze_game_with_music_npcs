public class NPC {
    private int health; 
    private String name; 
    private String token; 
    private int x_pos; 
    private int y_pos; 
    private boolean alive = true; 

    // Token refers to the icon for NPC on grid. 
    public NPC(int health, String name, String token, int x, int y)
    {
        this.health = health; 
        this.name = name; 
        this.token = token; 
        this.x_pos = x; 
        this.y_pos = y; 
    }

    // Can replace with story or events of your choice. 
    public void dialogue_1()
    {
        System.out.println(name + " says RAAARRRHHH");
    }
    
    public void dialogue_2()
    {
        System.out.println(name + "AAAAAAAAAAHHHH");
    }

    public void live()
    {
        alive = true; 
    }

    public void die()
    {
        alive = false; 
    }

    public void increase_x()
    {
        if (x_pos < 15)
        {
            x_pos ++; 
        }
    }

    public void decrease_x()
    {
        if (x_pos > 0)
        {
            x_pos --;
        }
    }

    public void increase_y()
    {
        if (y_pos < 15)
        {
            y_pos --;
        }
    }

    public void decrease_y()
    {
        if (y_pos > 0)
        {
            y_pos --;
        }
    }

    public int get_health()
    {
        return this.health; 
    }

    public String get_name()
    {
        return this.name; 
    }

    public String get_token()
    {
        return token; 
    }

    public boolean get_life()
    {
        return alive; 
    }

    public int get_x()
    {
        return this.x_pos;
    }

    public int get_y()
    {
        return this.y_pos;
    }

    

    



}
