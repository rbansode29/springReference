package com.example.demo.aopcode.aopclass.lookup;

public class Singer {

	public Singer() {
		// TODO Auto-generated constructor stub
	}

	private String lyric = "I played a quick game of chess with the salt and pepper shaker";

	public void sing() {
		// commented because it pollutes the output
		// System.out.println(lyric);
	}
}

/*

@Component("singer)
@Scope("prototype")
public class Singer {
	private String lyric = "I played a quick game of chess	with the salt and pepper shaker";
	public void sing() {
		// commented to avoid console pollution
		//System.out.println(lyric);
	}
}
*/
