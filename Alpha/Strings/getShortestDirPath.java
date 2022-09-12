package Alpha.Strings;

public class getShortestDirPath {
    public static float getSortestPath(String path){
        int x = 0 , y = 0;
        for (int i = 0; i < path.length(); i++) {
            char curr = path.charAt(i);
            //South
            if(curr == 'S'){
                y--;
            }
            //North
            else if(curr == 'N'){
                y++;
            }
            //West
            else if(curr == 'W'){
                x--;
            }
            //East
            else{
                x++;
            }
        }
        int X2 = x*x;
        int Y2 = y*y;
        return (float)Math.sqrt(X2+Y2);
    }
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(getSortestPath(path));
    }
}
