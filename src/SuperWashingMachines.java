public class SuperWashingMachines {
	public static void main(String[] args) {
		System.out.println(new SuperWashingMachines().
			findMinMoves(new int[] {4,0,0,4})); //2
		System.out.println(new SuperWashingMachines().
				findMinMoves(new int[] {1,0,5})); //3 
		System.out.println(new SuperWashingMachines().
				findMinMoves(new int[] {0,3,0})); //2 
		System.out.println(new SuperWashingMachines().
				findMinMoves(new int[] {0,0,14,0,10,0,0,0})); //11
		System.out.println(new SuperWashingMachines().
				findMinMoves(new int[] {3,1,0,4})); //2
	}
    public int findMinMoves(int[] machines) {
        int total = 0; 
        for(int i: machines) total+=i;
        if(total%machines.length!=0) return -1;
        int avg = total/machines.length, cnt = 0, max = 0;
        for(int load: machines){
            cnt += load-avg; //load-avg is "gain/lose"
            max = Math.max(Math.max(max, Math.abs(cnt)), load-avg);
        }
        return max;
    }
}
