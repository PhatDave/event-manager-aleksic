package hr.neos.aleksaeventmanager.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_sequence")
    @SequenceGenerator(name = "skill_sequence", allocationSize = 10)
    private Long id;

    @Column
    private String name;

    @JoinColumn(name = "experienceId")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Experience experience;
}
