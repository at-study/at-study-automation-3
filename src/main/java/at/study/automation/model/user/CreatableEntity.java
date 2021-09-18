package at.study.automation.model.user;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public abstract class CreatableEntity extends Entity {

    protected LocalDateTime createdOn = LocalDateTime.now();
    protected LocalDateTime updatedOn = LocalDateTime.now();

}
