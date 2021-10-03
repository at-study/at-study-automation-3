package at.study.automation.api.dto.users;

import java.time.LocalDateTime;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;

    private String login;

    @SerializedName("firstname")
    private String firstName;

    @SerializedName("lastname")
    private String lastName;

    private String mail;

    private String password;

    @SerializedName("created_on")
    private LocalDateTime createdOn;

    @SerializedName("last_login_on")
    private LocalDateTime lastLoginOn;

    private Integer status;
}
