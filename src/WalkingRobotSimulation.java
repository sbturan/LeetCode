import java.util.HashSet;

public class WalkingRobotSimulation {
	/*-2: turn left 90 degrees
	-1: turn right 90 degrees
	1 <= x <= 9: move forward x units*/
	public int robotSim(int[] commands, int[][] obstacles) {
		int[] position = new int[] { 0, 0 };
		int direction = 0; // 0=>up,1=>right,2=>down,3=>left
		HashSet<String> obs=new HashSet<>();
		for(int i=0;i<obstacles.length;i++) {
			obs.add(obstacles[i][0]+","+obstacles[i][1]);
		}
		int max=0;
		for (int i = 0; i < commands.length; i++) {
			if (commands[i] == -1) {
				direction = (direction + 1) % 4;
			} else if (commands[i] == -2) {
				direction = (direction + 3) % 4;
			} else {
				for (int j = 0; j < commands[i]; j++) {
					int[] newPosition = new int[] { position[0], position[1] };
					switch (direction) {
					case 0:
						newPosition[1]++;
						break;
					case 1:
						newPosition[0]++;
						break;
					case 2:
						newPosition[1]--;
						break;
					case 3:
						newPosition[0]--;
						break;
					}
					if(obs.contains(newPosition[0]+","+newPosition[1])) {
						break;
					}
					position[0]=newPosition[0];
					position[1]=newPosition[1];
					max=Math.max(max, (int)(Math.pow(position[0], 2)+Math.pow(position[1], 2)));
				}
			}
		}
		
		return max;
	}
}
