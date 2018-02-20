/*
 * Program Description:
 * Date Created: Thu 17 Aug 2017 10:00:54 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class AVLNode
{
	int data,height;
	AVLNode left,right;
	public AVLNode(int data){
		this.data = data;
		height = 1;
	}
	public int getHeight(){
		return height;
	}
}

