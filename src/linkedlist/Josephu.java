package linkedlist;

public class Josephu {

	public static void main(String[] args) {
		SingleCircleLinkedList singleCircleLinkedList = new SingleCircleLinkedList();
		singleCircleLinkedList.addChild(125);
		singleCircleLinkedList.showChild();
		singleCircleLinkedList.countChild(10, 20, 125);
	}

}


class SingleCircleLinkedList{
	private Child first =  null;
	
	public void addChild(int nums) {
		if(nums<1) {
			System.out.println("nums值不正确");
			return;
		}
		Child curChlid = null;
		for(int i=1;i<=nums;i++) {
			Child child = new Child(i);
			if(i==1) {
				first = child;
				first.setNext(first);
				curChlid=first;
			}else {
				curChlid.setNext(child);
				child.setNext(first);
				curChlid=child;
			}
		}
	}
	
	public void showChild() {
		if(first==null) {
			System.out.println("没有任何小孩");
			return;
		}
		Child curChild = first;
		while(true) {
			System.out.printf("小孩的编号%d\n", curChild.getNo());
			if(curChild.getNext()==first) 
				break;
			curChild=curChild.getNext();
		}
	}
	
	public void countChild(int startNo, int countNum, int nums) {
		if(first==null||startNo<1||startNo>nums) {
			System.out.println("参数输入有误，请重新输入");
			return;
		}
		Child helper=first;
		while(true) {
			if(helper.getNext()==first) {
				break;
			}
			helper=helper.getNext();
		}
		for (int i = 0; i < startNo-1; i++) {
			first=first.getNext();
			helper=helper.getNext();
		}
		while(true) {
			if(helper==first) {
				break;
			}
			for (int i = 0; i < countNum-1; i++) {
				first=first.getNext();
				helper=helper.getNext();
			}
			System.out.printf("小孩%d出圈\n",first.getNo());
			first=first.getNext();
			helper.setNext(first);
		}
		System.out.printf("剩下的最后一个小孩的编号是%d\n",first.getNo());
	}
}


class Child{
	private int no;
	private Child next;
	
	public Child(int no) {
		this.no=no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Child getNext() {
		return next;
	}

	public void setNext(Child next) {
		this.next = next;
	}
	
}