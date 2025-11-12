public class Main {
    
    public static void main (String[] args)
    {
        // Added using background music player object
        // Just change file path with your sound track file path. 
        MusicPlayer music = new MusicPlayer();
        music.play("insects.wav");
        
        Maze maze = new Maze();

        maze.print_maze();

        maze.user_int();
    }
}
