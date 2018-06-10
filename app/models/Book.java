package models;

import java.util.HashSet;
import java.util.Set;


public class Book {
    public Integer id;
    public String link;
    public String title;
    public String author;

    public Book(){

    }

    public Book(Integer id, String link, String title, String author){
        this.id = id;
        this.link=link;
        this.title=title;
        this.author=author;
    }

    private static Set<Book> books;
    private static Set<Book> cart;

    static {
        books = new HashSet<>();
        books.add(new Book(1, "https://picsum.photos/200/300?image=63", "Picture1", "Kot"));
        books.add(new Book(2, "https://picsum.photos/200/300?image=634", "Picture2", "Kot"));
        books.add(new Book(3, "https://picsum.photos/200/300?image=653", "Picture3", "Kot"));
    }

    public static Set<Book> retrieveAll(){
        return books;
    }

    public static Set<Book> retrieveCart(){
        return cart;
    }

    public static void clearCart(){
        cart = new HashSet<>();
    }

    public static Book retrieveById(Integer id) {
        for (Book book : books) {
            if (id.equals(book.id)) {
                return book;
            }
        }
    return null;
    }

    public static void add(Book book){
        books.add(book);
    }

    public static void addtoCart(Book book){
        cart.add(book);
    }

    public static boolean remove(Book book){
        return books.remove(book);
    }
    public static boolean removeFromCart(Book book){
        return cart.remove(book);
    }
}
