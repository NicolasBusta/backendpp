package services.academicservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import services.academicservice.dto.CareerDtoPost;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ACADEMIC_CAREERS_BOOKS", schema = "academic")
public class CareerBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="BOOK")
    private Short book;

    @Column(name="INVOICE")
    private Short invoice;

    @Column(name="DATE")
    private java.sql.Date date;

    @OneToOne
    @JoinColumn(name = "CAREER_ID")
    @JsonBackReference
    private Career career;

    public CareerBook(Career career, CareerDtoPost dto) {
        this.book = dto.getBook();
        this.invoice = dto.getInvoice();
        this.career = career;
    }

    public void update(CareerDtoPost dto) {
        this.book = dto.getBook();
        this.invoice = dto.getInvoice();
    }
}
