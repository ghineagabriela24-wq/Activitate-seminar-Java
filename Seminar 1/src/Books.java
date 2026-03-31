public class Books
{
    private String title;
    private String author;
    private int pages;

    public Books()
    {
    }

    public Books(String title, String author, int pages)
    {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}