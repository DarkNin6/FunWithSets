
public class IntegerSet {

	public int[] elements;
	public int numElements;

	public IntegerSet(int maxNumElements) {
		this.elements = new int[maxNumElements];
		this.numElements = 0;
	}

	public boolean equals(Object other) {
		if (other == null || !(other instanceof IntegerSet)) {
			return false;
		}
		IntegerSet otherIntegerSet = (IntegerSet) other;
		for (int i=0; i<this.cardinality(); i++) {
			if (!otherIntegerSet.isMember(this.elements[i])) {
				return false;
			}
		}
		return (this.cardinality() == otherIntegerSet.cardinality());
	}

	public String toString() {
		String result = "{";
		for (int i=0; i < this.cardinality(); i++) {
			result += this.elements[i];
			if (i != this.numElements - 1) {
				result += ",";
			}
		}
		return result + "}";
	}

	public boolean isMember(int key) {
		for(int i=0; i<this.numElements; i++) {
			if (key == elements[i]) return true;
		}
		return false;
	}

	public boolean isFull() {
		return (this.numElements == elements.length);
	}

	public void add(int newMember) {
		if (this.isMember(newMember)) return;
		if (this.isFull()) {
			int[] tempArray = new int[numElements*2];
			for (int i=0; i<numElements; i++) {
				tempArray[i] = elements[i];
			}
			elements = tempArray;  // Old array becomes garbage
		}
		elements[numElements] = newMember;
		numElements++; 
	}

	public void delete(int key) {
		for(int i=0; i < this.numElements; i++)
		{
			if (this.elements[i] == key)
				this.elements[i] = this.elements[numElements - 1];
			numElements--;
		}
	}

	public long sum() {
		long sum = 0;
		for (int i=0; i < this.numElements; i++) {
			sum += this.elements[i];
		}
		return sum;
	}

	public boolean allEven() {
		boolean result = true;
		for(int i=0; i < this.numElements; i++) {
			result = result && (this.elements[i] % 2) == 0;
		}
		return result;
	}

	public int cardinality() {
		return this.numElements;
	}

	public IntegerSet intersection(IntegerSet b) {
		IntegerSet c = new IntegerSet(b.cardinality());
		for(int i=0; i < this.numElements; i++) {
			if (b.isMember(this.elements[i])) {
				c.add(this.elements[i]);
			}
		}
		return c;
	}

	public IntegerSet union(IntegerSet b) {
		IntegerSet c = new IntegerSet(this.cardinality()+b.cardinality());
		for (int i=0; i<this.cardinality(); i++) {
			c.add(this.elements[i]);
		}
		for (int i=0; i<b.cardinality(); i++) {
			c.add(b.elements[i]);
		}
		return c;
	}
}

