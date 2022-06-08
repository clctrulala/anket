package demo.application.model.entity;

import com.fasterxml.jackson.databind.util.JSONPObject;
import demo.application.model.enums.SurveyStatus;
import io.undertow.attribute.DateTimeAttribute;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "survey")
@Getter
@Setter
public class Survey {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name = "created_at")
    private DateTimeAttribute createdAt;

    @Column(name = "updated_at")
    private DateTimeAttribute updatedAt;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private SurveyStatus status;

    @Column(name = "user")
    private String user;

    @Column(name = "company")
    private String company;

    @Column(name = "survey_data")
    private JSONPObject surveyData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id")
    private SurveyTemplate surveyTemplate;

    @OneToMany(mappedBy = "survey")
    private Set<Feedback> feedbacks;
}
