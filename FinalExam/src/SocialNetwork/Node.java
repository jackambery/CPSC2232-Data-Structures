package SocialNetwork;


import java.util.ArrayList;
import java.util.List;

class Node<T>
{
	T data;
	boolean visited;
	List<Node<T>> friends;

	Node(T data)
	{
		this.data=data;
		this.friends=new ArrayList<>();

	}
	public void addFriend(Node<T> friend)
	{
		this.friends.add(friend);
	}
	public List<Node<T>> getFriends() {
		return friends;
	}
	public void setNeighbours(List<Node<T>> friends) {
		this.friends = friends;
	}
}
