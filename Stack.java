
class Stack {
	
	private LinkedList list;
	private Element top;

	public Stack()
	{
		list = new LinkedList();
		top = null;
	}

	public void setTop(Element data)
	{
		top = data;
	}

	public void push(Element data)
	{
		list.insertFirst(data);
		this.setTop(data);
	}

	public Element pop()
	{
		Element helper = list.deleteFirst();;
		this.setTop(list.getFirst());

		return helper;
	}

	public Element peek()
	{
		return top;
	}

	public boolean isEmpty()
	{
		return list.isEmpty();
	}

	public void print()
	{
		Element helper = top;
		System.out.println("Isi Stack : ");
		while (helper != null)
		{
			System.out.println(helper.getInfo().getIsi());
			helper = helper.getNext();
		}
		System.out.println();
	}

}