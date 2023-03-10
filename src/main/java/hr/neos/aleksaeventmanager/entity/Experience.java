package hr.neos.aleksaeventmanager.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "experience_sequence")
    @SequenceGenerator(name = "experience_sequence", allocationSize = 10)
    private Long id;

    @Column
    private Integer years;

    @Column
    private String repositoryUrl;

    @Column
    private String summary;

    @JoinColumn(name = "userId")
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "experience", cascade = CascadeType.PERSIST)
    private List<Skill> skills;

}
