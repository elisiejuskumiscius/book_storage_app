package book.storage.app.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "book", schema = "book_store")
public class Book  {

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "author", length = 50, nullable = false)
    private String author;

    @NaturalId
    @Column(name = "barcode", length = 13, nullable = false, unique = true, updatable = false)
    private String barcode;

    @Min(value = 0, message = "Quantity must be greater than or equal to zero")
    @NotNull(message = "Quantity is required")
    @Column(name = "quantity")
    private Integer quantity;

    @Min(value = 0, message = "Price must be greater than or equal to zero")
    @NotNull(message = "Price is required")
    @Column(name = "price_per_unit", nullable = false)
    private Double price;

    public Book() { }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBarcode() { return barcode; }

    public void setBarcode(String barcode) { this.barcode = barcode; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() { return price; }

    public void setPrice(Double price) {
        this.price = price;
    }

    public double getTotalPrice() { return this.price * this.quantity; }

}
