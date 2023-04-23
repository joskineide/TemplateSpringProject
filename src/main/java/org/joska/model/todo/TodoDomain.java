package org.joska.model.todo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joska.model.photo.PhotoDomain;
import org.joska.model.user.domain.UserDomain;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todo")
@Entity
public class TodoDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_user_id")
    private UserDomain user;

    @Column(name= "title")
    private String title;

    @Column(name= "completed")
    private Boolean completed;


}
