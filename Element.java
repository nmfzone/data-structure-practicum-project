
class Element {

	private Info info;
	private Element next;
	
	public Element(Info info)
	{
		this.info = info;
		this.next = null;
	}

	public Info getInfo()
	{
		return info;
	}

	public void setNext(Element next)
	{
		this.next = next;
	}

	public Element getNext()
	{
		return next;
	}

}