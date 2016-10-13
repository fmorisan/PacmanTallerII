// extraido de https://github.com/xSmallDeadGuyx/SimpleAStar.git
package org.xsmalldeadguyx.astar;

public class Node {
	int x, y;
	
	public Node(int i, int j) {
		x = i;
		y = j;
	}
	
	public int getX(){
		return this.x;
	}
	
	
	public int getY() {
		return y;
	}

	public boolean equals(Object obj) {
		if(obj instanceof Node) {
			Node n = (Node) obj;
			return (x == n.x && y == n.y);
		}
		else return false;
	}
}
