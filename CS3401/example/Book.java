package example;




public class Book {
	String title;
	String author;
	int pages;
	boolean hardcover;
	
	/** Constructor for a Book
	 * @param title title of the book
	 * @param author Name of the author
	 * @param hardcover
	 * @param pages
	 * @throw IllegalArgumentException if pages is 0

	 */
	public Book(String title, String author, boolean hardcover, int pages) {
		if (pages <= 0) {
			throw new IllegalArgumentException();
		}
		this.title = title;
		this.author = author;
		this.hardcover = hardcover;
		this.pages = pages;
	}

	/** Get Title of Book
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/** Change the title
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/** Get the name of the Author
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/** Change the name of the author
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/** Get number of pages
	 * @return the pages
	 */
	public int getPages() {
		return pages;
	}

	/** Change the number of pages
	 * @param pages the pages to set
	 * @throw IllegalArgumentException if pages is not positive
	 */
	public void setPages(int pages) {
		if (pages <= 0) {
			throw new IllegalArgumentException();
		}
		this.pages = pages;
	}

	/** Determine whether it is a hardcover book
	 * @return true if book is hardcover
	 */
	public boolean isHardcover() {
		return hardcover;
	}

	/** Set whether the book is hardcover
	 * @param hardcover true if the book is to be hardcover
	 */
	public void setHardcover(boolean hardcover) {
		this.hardcover = hardcover;
	}

	/**
	 * Computes cost of the book
	 * @return the cost
	 */
	public int cost(){
		return pages * (1 / 2);
	}

}
