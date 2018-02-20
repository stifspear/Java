/*
 * Program Description:
 * Date Created: Mon 25 Sep 2017 09:40:41 AM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class BinaryToDLink
{
	AVLNode tree;
	public BinaryToDLink(AVLNode tree){
		this.tree = tree;
	}
	public void traverse(AVLNode node) {
		if(node == null)
			return;
		traverse(node.left);
		System.out.println(node.data);
		traverse(node.right);
	}
}

