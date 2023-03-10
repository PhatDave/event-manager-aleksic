package hr.neos.aleksaeventmanager.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", allocationSize = 10)
    private Long id;

    @Embedded
    PersonalInfo personalInfo;

    @Embedded
    OtherUserInfo otherUserInfo;

    @JoinColumn(name = "teamId")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Team team;

    @JoinColumn(name = "registrationId")
    @OneToOne(cascade = CascadeType.ALL)
    private Registration registration;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Experience experience;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Education education;

}

