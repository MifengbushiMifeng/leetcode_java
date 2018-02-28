package cusannotation;

import java.util.List;

public class PasswordUtils {

    @UseCase(id = 47, description = "Passwords must contain at lease onr numeric")
    public boolean vaildatePassword(String password) {
        return password.matches("\\\\w*\\\\d\\\\w*");
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }


    @UseCase(id = 49, description = "New password can't be same with the previously ones")
    public boolean checkForNewPassword(List<String> prevPasswords, String password) {
        return !prevPasswords.contains(password);
    }
}
