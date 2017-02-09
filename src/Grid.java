/**
 * Created by Eriwyr on 07/02/2017.
 */
public class Grid {

    char[][] grid;

    public Grid(){
        this.grid = new char[3][3];
        for(int i = 0; i<3;i++){
            for(int j = 0 ; j<3 ; j++){
                grid[i][j]='n';
            }
        }
    }

    public void printGrid(){
        for(int i = 0; i<3;i++){
            for(int j = 0 ; j<3 ; j++){
                System.out.print(grid[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println("\n");
    }

    public void setXY(int x, int y, char carac){
            grid[x][y] = carac;
    }

    public boolean isEmpty()
    {
        for(int i = 0; i<3;i++){
            for(int j = 0 ; j<3 ; j++){
                if(grid[i][j] != 'n') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isFull()
    {
        for(int i = 0; i<3;i++){
            for(int j = 0 ; j<3 ; j++){
                if(grid[i][j] == 'n') {
                    return false;
                }
            }
        }
        return true;
    }

    public char getXY(int x, int y){
        return grid[x][y];
    }
}
