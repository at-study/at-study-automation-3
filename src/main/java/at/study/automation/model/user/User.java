package at.study.automation.model.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import at.study.automation.db.requests.UserRequests;
import at.study.automation.model.Creatable;
import at.study.automation.model.CreatableEntity;
import at.study.automation.model.Deleteable;
import at.study.automation.model.Updateable;
import at.study.automation.model.project.Project;
import at.study.automation.model.role.Role;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import static at.study.automation.utils.StringUtils.randomEnglishString;
import static at.study.automation.utils.StringUtils.randomHexString;
import static org.apache.commons.codec.digest.DigestUtils.sha1Hex;


@NoArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
public class User extends CreatableEntity implements Creatable<User>, Updateable<User>, Deleteable<User> {

    private String login = "AutoLogin" + randomEnglishString(10);
    private String password = "1qaz@WSX";
    private String salt = randomHexString(32);
    private String hashedPassword = hashPassword();
    private String firstName = "AutoF" + randomEnglishString(10);
    private String lastName = "AutoL" + randomEnglishString(10);
    private Boolean isAdmin = false;
    private Status status = Status.ACTIVE;
    private LocalDateTime lastLoginOn;
    private Language language = Language.RUSSIAN;
    private String authSourceId;
    private String type = "User";
    private String identityUrl;
    private MailNotification mailNotification = MailNotification.NONE;
    private Boolean mustChangePassword = false;
    private LocalDateTime passwordChangedOn;
    private List<Token> tokens = new ArrayList<>();
    private List<Email> emails = new ArrayList<>();

    public User setPassword(String password) {
        this.password = password;
        this.hashedPassword = hashPassword();
        return this;
    }

    private String hashPassword() {
        return sha1Hex(salt + sha1Hex(password));
    }

    @Override
    @Step("Создан пользователь в БД")
    public User create() {
        new UserRequests().create(this);
        tokens.forEach(t -> t.setUserId(id));
        tokens.forEach(Token::create);
        emails.forEach(e -> e.setUserId(id));
        emails.forEach(Email::create);
        return this;
    }

    @Override
    @Step("Удален пользователь в БД")
    public User delete() {
        new UserRequests().delete(this.id);
        return this;
    }

    @Override
    public User update() {
        new UserRequests().update(this.id, this);
        return this;
    }

    @Step("Пользователю добавлен проект {0} с ролями {1}")
    public void addProject(Project project, List<Role> roles) {
        // TODO: Реализовать с помощью SQL-запроса
    }

}
