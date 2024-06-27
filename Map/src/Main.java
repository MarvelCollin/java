import java.util.Iterator;
import java.util.Scanner;

public class Main {
	int ySize = 15;
    int xSize = 15;
    
    Scanner s = new Scanner(System.in);
    
    char[][] map = new char[ySize][xSize];
    int yCamera = 3, xCamera = 3;
    int yPlayer = 1, xPlayer = 2;
    
	public Main() {
		initializeMap(map);
		displayMap(map);
		
		while(true) {
			printCamera();
			move();
		}
	}
	
	void move() {
		String input;
		
		System.out.print(">> ");
		input = s.nextLine();
		
		int shadowX = 0, shadowY = 0;
		
		if(input.equals("w")) {
			shadowY = -1;
		} else if(input.equals("d")) {
			shadowX = 1;
		} else if(input.equals("s")) {
			shadowY = 1;
		} else if(input.equals("a")) {
			shadowX = -1;
		} else {
			move();
			return;
		}
		
		// checker
		
		yPlayer += shadowY;
		xPlayer += shadowX;
	}
	
    public void initializeMap(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = '.';
            }
        }

        map[1][1] = '#'; 
        map[2][3] = 'T';
        map[3][5] = 'P'; 
    }

    public void displayMap(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
            		System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    void printCamera() {
    	int yAngle = yCamera / 2;
    	int xAngle = xCamera / 2;
    	
    	// 1,1 -> 3,3 
    	for (int i = yPlayer - yAngle; i <= yPlayer + yAngle; i++) {
    		for (int j = xPlayer - xAngle; j <= xPlayer + xAngle; j++) {
    			if(i == yPlayer && j == xPlayer) {
    				System.out.print("X ");
    			} else {
    				System.out.print(map[i][j] + " ");
    			}
    		}
    		System.out.println();
		}
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
