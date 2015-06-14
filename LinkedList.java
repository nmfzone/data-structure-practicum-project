
public class LinkedList {

	private Element first;

	public LinkedList()
	{
		first = null;
	}

	public Element getFirst()
	{
		return first;
	}

	public void setFirst(Element data)
	{
		first = data;
	}

	public void insertFirst(Element data)
	{
		data.setNext(first);
		first = data;
	}

	public void insertLast(Element data)
	{
		if (isEmpty())
		{
			first = data;
		}
		else
		{
			Element helper = first;
			while (helper.getNext() != null)
			{
				helper = helper.getNext();
			}
			helper.setNext(data);
		}
	}

	public Element deleteFirst()
	{
		Element helper = first;
		first = first.getNext();

		return helper;
	}

	public Element getLastElement()
	{
		Element lastElement = null;
		if (isEmpty())
		{
			lastElement = first;	
		}
		else
		{
			Element helper = first;
			while (helper.getNext() != null)
			{
				helper = helper.getNext();
			}
			lastElement = helper;
		}

		return lastElement;
	}

	public boolean isEmpty()
	{
		return first == null;
	}

	public void print()
	{
		Element helper = this.getFirst();
		System.out.print("Isi List : ");
		while (helper != null)
		{
			System.out.print(helper.getInfo().getIsi() + " ");
			helper = helper.getNext();
		}
		System.out.println();
	}

}