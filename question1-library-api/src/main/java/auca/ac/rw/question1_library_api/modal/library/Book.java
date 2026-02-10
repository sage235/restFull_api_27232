package auca.ac.rw.question1_library_api.modal.library;

public class Book {
    private Long id;
    private String titles;
    private String authors;
    private String isbn;
    private int publicationYear;

    public Book() {
    }

    public Book(Long id, String titles, String authors, String isbn, int publicationYear) {
        this.id = id;
        this.titles = titles;
        this.authors = authors;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
