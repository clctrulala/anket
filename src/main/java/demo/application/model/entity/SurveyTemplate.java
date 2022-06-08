package demo.application.model.entity;

import com.fasterxml.jackson.databind.util.JSONPObject;
import demo.application.model.enums.SurveyTemplateStatus;
import io.undertow.attribute.DateTimeAttribute;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "survey_template")
@Getter
@Setter
public class SurveyTemplate {
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

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private SurveyTemplateStatus status;

    @Column(name = "code")
    private String code;

    @Column(name = "version")
    private Integer version;

    @Column(name = "template_data")
    private JSONPObject templateData;

    @OneToMany(mappedBy = "surveyTemplate")
    private List<Survey> survey = new ArrayList<>();
}
