package services.academicservice.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
//@Table(name = "SIS_USERS", schema = "sys")
public class User {

    private Long id;

    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_PASSWORD")
    private String userPassword;

    @Column(name = "USER_STATUS")
    private Boolean userStatus;

    @Column(name = "USER_LAST_LOGIN")
    private java.sql.Date userLastLogin;

    @Column(name = "LMS_LAST_LOGIN")
    private java.sql.Date lmsLastLogin;

    @Column(name = "LOGIN_ATTEMPTS")
    private Short loginAttempts;

    @Column(name = "MAX_ATTEMPTS_DATE")
    private java.sql.Date maxAttemptsDate;

    @Column(name = "USER_TOKEN")
    private String userToken;

    @Column(name = "USER_TOKEN_TIME")
    private java.sql.Timestamp userTokenTime;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Teacher teacher;
    */

}
