package me.whiteship.chapter01.item03.serialization;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Serializable 를 상속 받아야 직렬화 가능함 아니면 예외 뜸
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private String isbn;

    private String title;

    private LocalDate published;

    private String name;

    /**
     * 직렬화 하고 싶지 않은 필드는 transient 를 붙이면 된다
     *
     * 그리고 static 한 필드는 직렬화 되지 않음 !
     * static 은 객체에 속해 있는 값보다는 따로 관리되는 메모리 값임
     */
    private transient int numberOfSold;

    public Book(String isbn, String title, String author, LocalDate published) {
        this.isbn = isbn;
        this.title = title;
        this.published = published;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", published=" + published +
                ", numberOfSold=" + numberOfSold +
                '}';
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    public int getNumberOfSold() {
        return numberOfSold;
    }

    public void setNumberOfSold(int numberOfSold) {
        this.numberOfSold = numberOfSold;
    }
}
