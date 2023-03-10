package hr.neos.aleksaeventmanager.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "education_sequence")
    @SequenceGenerator(name = "education_sequence", allocationSize = 10)
    private Long id;

    @Column
    private String faculty;

    @Column
    private Integer year;

    @JoinColumn(name = "userId")
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

}
