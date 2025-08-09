package mybeans;

public class TextBean {
	private String txt,option;

	public TextBean() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Default constructor is called here");
	}

	public String getTxt() {
		System.out.println("getTxt is called here");
		return txt;
	}

	public void setTxt(String txt) {
		System.out.println("setTxt is called here");
		this.txt = txt;
	}

	public String getOption() {
		System.out.println("getOption is called here");
		return option;
	}

	public void setOption(String option) {
		this.option = option;
		System.out.println("setOption is called here");
	}
	
	public String upper()
	{
		return txt.toUpperCase();
	}
	public String lower()
	{
		return txt.toLowerCase();
	}
	public String reverse()
	{
		StringBuffer s =new StringBuffer(txt);
		return s.reverse().toString();
	}

}
