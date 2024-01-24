package kg.aiylbank.aiylbanktask.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    @Id
    @SequenceGenerator(name = "test_gen", sequenceName = "test_seq", allocationSize = 1, initialValue = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_gen")
    private Long id;
    private String description;
    private boolean completed;

}
