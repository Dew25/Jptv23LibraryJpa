package ee.ivkhkdev.jptv23libraryjpa.enity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic()
    @Column()
    private String firstname;
    private String lastname;
    private boolean available = true;

    public Author() {
    }

    public Author(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;
        return available == author.available && Objects.equals(id, author.id) && Objects.equals(firstname, author.firstname) && Objects.equals(lastname, author.lastname);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(firstname);
        result = 31 * result + Objects.hashCode(lastname);
        result = 31 * result + Boolean.hashCode(available);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Author{");
        sb.append("id=").append(id);
        sb.append(", firstname='").append(firstname).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", available=").append(available);
        sb.append('}');
        return sb.toString();
    }
}
