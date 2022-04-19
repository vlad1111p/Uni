
public class Aufzugsteuerung {

	int currentFloor = 0;
	int minFloor = 0;
	int maxFloor = 0;
	boolean open = false;
	IntQueue q = new IntQueue();
	
	//Konstruktor	
	Aufzugsteuerung (int currentFloor, int minFloor, int maxFloor) {
		this.currentFloor=currentFloor;
		this.minFloor=minFloor;
		this.maxFloor=maxFloor;
		this.open=true;
	}
	
	//Methoden
	void request (int floor) {
		this.q.enqueue(floor);
	}
	
	int action() {
		
		if (this.q.isEmpty()==true) {
			return 0;
		}
		
		if (this.q.peek()!=this.currentFloor && this.open==true) {
			this.open=false;
			return 4;
		}
		
		if (this.q.peek()!=this.currentFloor && this.open==false) {
			if (this.q.peek()<this.currentFloor) {
				this.currentFloor--;
				return 2;
			}
			
			if(this.q.peek()>this.currentFloor) {
				this.currentFloor++;
				return 1;
			}
		}
		
		if (this.q.peek()==this.currentFloor && this.open==true) {
			this.open=false;
			return 4;
		}
		
		if (this.q.peek()==this.currentFloor && this.open==false) {
			this.q.dequeue();
			this.open=true;
			return 3;
		}
				
		return 0;
		
	}
	
	public static void main(String[] args) {
		
		
		//Eigener Test / how to use
		Aufzugsteuerung a= new Aufzugsteuerung(0, 0, 10);
		System.out.println("Start.");
		a.request(5);
		a.request(3);
		a.request(7);
		a.request(0);

		while(a.action()!=0) {
			System.out.println(a.action());
		}
		
    }

}

