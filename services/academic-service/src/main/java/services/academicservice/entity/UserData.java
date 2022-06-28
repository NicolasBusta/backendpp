package services.academicservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@Entity
//@Table(name = "SIS_USERS_DATA", schema = "sys")
public class UserData {

    private Long id;
    private String userDataName;
    private String userDataLastName;
    private List<UserData> userList = new ArrayList<>(Arrays.asList(
            new UserData(153312L, "ESTENKA", "MIHOVILOVIC OLGUÍN"),
            new UserData(153313L, "ALEJANDRO LUIS", "HINOJOSA CASTILLO"),
            new UserData(153314L, "CARLOS MANUEL", "CÉSPEDES ARAVENA"),
            new UserData(153315L, "RAUL ELEUTERIO", "BARRA NAVARRO"),
            new UserData(153316L, "PAZ EUGENIA", "LE-BERT RODRÍGUEZ")
    ));

    public UserData(Long id, String userDataName, String userDataLastName) {}

    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_DATA_NAME")
    private String userDataName;

    @Column(name = "USER_DATA_LASTNAME")
    private String userDataLastName;

    @Column(name = "USER_DATA_EMAIL")
    private String userDataEmail;

    @Column(name = "USER_DATA_BIRTH_DATE")
    private java.sql.Date userDataBirthDate;

    @Column(name = "USER_DATA_GENDER")
    private Short userDataGender;

    @Column(name = "USER_DATA_IDENTIFICATION_TYPE")
    private Short userDataIdentificationType;

    @Column(name = "USER_DATA_IDENTIFICATION")
    private String userDataIdentification;

    @Column(name = "USER_DATA_CELLPHONE")
    private String userDataCellphone;

    @Column(name = "USER_DATA_PHONE")
    private String userDataPhone;

    @Column(name = "USER_DATA_AVATAR")
    private Byte[] userDataAvatar;

    @Column(name = "USER_NATIONALITY")
    private String userNationality;

    @Column(name = "USER_BIRTH_PLACE")
    private String userBirthPlace;

    @Column(name = "USER_MARITAL_STATUS")
    private Short userMaritalStatus;

    @Column(name = "IDENTIFICATION_SERIAL_NUMBER")
    private String identificationSerialNumber;

    @Column(name = "IDENTIFICATION_VERIFICATION")
    private String identificationVerification;

    @OneToOne(mappedBy = "userAdress", cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID")
    private Set<UserAdress> userAdress;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;
    */

}
