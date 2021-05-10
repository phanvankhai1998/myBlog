package book.java.com;

import java.util.Scanner;

public class Book {
	static Scanner sc; 
	static Article[] list;
	static int seq;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		list = new Article[10];
		seq = 0;
		
		while(true) {
			System.out.println(" > ");
			String cmd = sc.nextLine();
			
			//CREATE
			if(cmd.equals("new")) {
				registArticle();
			}
			
			//RETRIEVE
			if(cmd.equals("showlist")) {
				showList();
			}
			
			//UPDATE
			if(cmd.equals("edit")) {
				System.out.print("Select art's Index > ");
				cmd = sc.nextLine();				// "1"
				int idx = Integer.parseInt(cmd);	//	1
				if(idx < seq) {						//if seq 3, [0][1][2]
					editArticle(idx);				//go to edit [idx]article
				}else {
					System.out.println("Invaild index");
				}
			}
			
			//DELETE
			if(cmd.equals("delete")) {
				System.out.println("Seleact article's index :>");
				cmd = sc.nextLine();
				int idx = Integer.parseInt(cmd);
				
				if(idx < seq) {
					deleteArticle(idx);
					showList();
				}else {
					System.out.println("invalid index");
				}
			}
		}
	}

	private static void deleteArticle(int idx) {
		// TODO Auto-generated method stub
		for(int i=idx; (i+1)<list.length; i++) {
			list[i] = list[i+1];// [0] <- [] <- [9]
		}
		// decrease numbers of save data
		--seq;
	}

	private static void showList() {
		// TODO Auto-generated method stub
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				System.out.println(
						"Title : " + list[i].getTitle() + " Write : " + list[i].getWriterName() + " Contetn : " + list[i].getContent()
				);
			}
		}
	}

	private static void editArticle(int idx) {
		// TODO Auto-generated method stub
		Article article = list[idx];		//get reference
		
		System.out.println("Title >" + article.getTitle());
		String title = sc.nextLine();
		// <enter>, empty string
		if(title.length() > 0 ) {
			article.setTitle(title);	//over write data
		}
		
		System.out.println("Write > " + article.getWriterName());
		String name = sc.nextLine();
		if(name.length() > 0 ) {
			article.setWriterName(name);
		}
		
		System.out.println("Content >" + article.getContent());
		String content = sc.nextLine();
		if(content.length() > 0) {
			article.setContent(content);
		}
	}

	private static void registArticle() {
		// TODO Auto-generated method stub
		System.out.println("Title > ");
		String title = sc.nextLine();
		
		System.out.print("Writer > ");
		String name = sc.nextLine();
		
		System.out.print("Content > ");
		String content = sc.nextLine();
		
		//save data in  Article instance
		Article article = new Article();
		article.setTitle(title);
		article.setWriterName(name);
		article.setContent(content);
		System.out.println(article);
		if(seq < list.length) {
			list[seq] = article;	//need index of array
			seq++;
			//ArrayIndexOutOfBounds
		}
	}
}
