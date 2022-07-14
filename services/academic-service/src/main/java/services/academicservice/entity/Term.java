package services.academicservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ACADEMIC_TERMS", schema = "academic")
public class Term {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TERM_DESCRIPTION")
    private String termDescription;

    @Column(name = "TERM_CODE")
    private String termCode;

    @Column(name = "MODALITY_TYPE")
    private Short modalityType;

    @Column(name = "STUDY_TYPE")
    private Short studyType;

    @Column(name = "TERM_STATUS")
    private Boolean termStatus;

    @Column(name = "SALE_DATE_FROM")
    private java.sql.Date saleDateFrom;

    @Column(name = "SALE_DATE_TO")
    private java.sql.Date saleDateTo;

    @Column(name = "CLASS_START_DATE")
    private java.sql.Date classStartDate;

    @Column(name = "CLASS_END_DATE")
    private java.sql.Date classEndDate;

    @Column(name = "SALE_RI_DATE_FROM")
    private java.sql.Date saleRiDateFrom;

    @Column(name = "SALE_RI_DATE_TO")
    private java.sql.Date saleRiDateTo;

    @Column(name = "REFUND_DATE_FROM")
    private java.sql.Date refundDateFrom;

    @Column(name = "REFUND_DATE_TO")
    private java.sql.Date refundDateTo;

    @Column(name = "REFUND_FORCE_DATE_FROM")
    private java.sql.Date refundForceDateFrom;

    @Column(name = "REFUND_FORCE_DATE_TO")
    private java.sql.Date refundForceDateTo;

    @Column(name = "REPAYMENT_RI_DATE_FROM")
    private java.sql.Date repaymentRiDateFrom;

    @Column(name = "REPAYMENT_RI_DATE_TO")
    private java.sql.Date repaymentRiDateTo;

    @Column(name = "SECTION_DATE_FROM")
    private java.sql.Date sectionDateFrom;

    @Column(name = "SECTION_DATE_TO")
    private java.sql.Date sectionDateTo;

    @Column(name = "SCHOLARSHIP_DATE_FROM")
    private java.sql.Date scholarshipDateFrom;

    @Column(name = "SCHOLARSHIP_DATE_TO")
    private java.sql.Date scholarshipDateTo;

    @Column(name = "CHANGE_DATE_FROM")
    private java.sql.Date changeDateFrom;

    @Column(name = "CHANGE_DATE_TO")
    private java.sql.Date changeDateTo;

    @Column(name = "DISENROLLMENT_DATE_FROM")
    private java.sql.Date disenrollmentDateFrom;

    @Column(name = "DISENROLLMENT_DATE_TO")
    private java.sql.Date disenrollmentDateTo;

    @Column(name = "LMS_ID")
    private Long lmsId;

    @Column(name = "TERM_TYPE")
    private Short termType;

    @OneToMany(mappedBy = "term")
    private Set<Section> sections;

}
