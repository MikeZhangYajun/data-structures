package linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		System.out.println("双向链表的测试~~");
		HeroNode2 hero1 = new HeroNode2(1,"宋江","及时雨");
		HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
		HeroNode2 hero3 = new HeroNode2(3,"吴用","智多星");
		HeroNode2 hero4 = new HeroNode2(4,"林冲","豹子头");
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(hero1);
		doubleLinkedList.add(hero2);
		doubleLinkedList.add(hero3);
		doubleLinkedList.add(hero4);
		doubleLinkedList.list();
		
		HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
		doubleLinkedList.update(newHeroNode);
		System.out.println("修改后的双向链表~~");
		doubleLinkedList.list();
		
		doubleLinkedList.del(2);
		System.out.println("删除后的双向链表~~");
		doubleLinkedList.list();
		
		doubleLinkedList.addByOrder(hero2);
		System.out.println("顺序加入后的双向链表~~");
		doubleLinkedList.list();
	}

}

class DoubleLinkedList{
	private HeroNode2 head = new HeroNode2(0,"","");
	
	public HeroNode2 getHead() {
		return head;
	}
	
	public void list() {
		if(head.next==null) {
			System.out.println("链表为空~~");
			return;
		}
		HeroNode2 temp = head.next;
		while(true) {
			if(temp==null) {
				break;
			}
			System.out.println(temp);
			temp=temp.next;
		}
	}
	
	public void add(HeroNode2 heronode) {
		HeroNode2 temp = head;
		while(true) {
			if(temp.next==null) {
				break;
			}
			temp=temp.next;
		}
		temp.next = heronode;
		heronode.pre = temp;
	}
	
	public void addByOrder(HeroNode2 heronode) {
		HeroNode2 temp = head;
		boolean flag = false;
		while(true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no>heronode.no) {
				break;
			}else if(temp.next.no==heronode.no) {
				flag = true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			System.out.printf("准备插入的英雄编号%d已经存在，不能加入\n", heronode.no);
		}else {
			heronode.next=temp.next;
			temp.next=heronode;
			heronode.next.pre=heronode;
			heronode.pre=temp;
		}
	}
	
	public void update(HeroNode2 heronode) {
		if(head.next==null) {
			System.out.println("链表为空~~");
			return;
		}
		HeroNode2 temp = head.next;
		boolean flag = false;
		while(true) {
			if(temp==null) {
				break;
			}
			if(temp.no==heronode.no) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			temp.name=heronode.name;
			temp.nickname=heronode.nickname;
		}else {
			System.out.printf("没有找到编号%d的节点，不能修改", heronode.no);
		}
		
	}
	
	public void del(int no) {
		if(head.next==null) {
			System.out.println("链表为空，无法删除");
			return;
		}
		HeroNode2 temp = head.next;
		boolean flag = false;
		while(true) {
			if(temp == null) {
				break;
			}
			if(temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			temp.pre.next = temp.next;
			if (temp.next != null) {
				temp.next.pre=temp.pre;
			}
		}else {
			System.out.printf("要删除的%d节点不存在\n", no);
		}
		
	}
	
	
	
}

class HeroNode2{
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;
	public HeroNode2 pre;
	
	public HeroNode2(int no, String name, String nickname) {
		this.no=no;
		this.name=name;
		this.nickname=nickname;
	}
	
	public String toString() {
		return "HeroNode2 [no=" + no + ",name=" + name + ",nickname=" + nickname + "]";
	}
	
}