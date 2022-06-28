package services.academicservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ACADEMIC_TEACHERS", schema = "academic")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;
    */

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "CV")
    private byte[] cv;

    @Column(name = "LMS_USER_ID")
    private Long lmsUserId;

}
