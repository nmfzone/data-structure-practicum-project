
class Queue {

	private LinkedList list;
	private Element head;

	public Queue()
	{
		list = new LinkedList();
		head = null;
	}

	public void setHead(Element data)
	{
		this.head = data;
	}

	public Element getHead()
	{
		return head;
	}
	
	public void enQueue(Element data)
	{
		list.insertLast(data);
		this.setHead(list.getFirst());
	}

	public Element deQueue()
	{
		Element data = list.getFirst();
		list.setFirst(list.getFirst().getNext());
		this.setHead(list.getFirst());

		return data;
	}

	public boolean isEmpty()
	{
		return head == null;
	}

	public void print()
	{
		if (!isEmpty())
		{
			Element helper = head;
			int i = 1;
			while (helper != null)
			{
				System.out.println("   " + i + ". " + helper.getInfo().getIsi());
				helper = helper.getNext();
				i++;
			}
		}
		else
		{
			System.out.println("Queue is Empty!");
		}
	}

}