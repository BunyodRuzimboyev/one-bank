package uz.br29.profile.enums;

import java.util.LinkedList;
import java.util.List;

public enum RoleEnum {

    ROLE_USER, ROLE_ADMIN, ROLE_MODERATOR, ROLE_PUBLISH;

    public static List<RoleEnum> values(String[] roles) {
        if (roles == null || roles.length == 0) {
            return new LinkedList<>();
        }
        List<RoleEnum> roleList = new LinkedList<>();
        for (String role : roles) {
            roleList.add(RoleEnum.valueOf(role));
        }
        return roleList;
    }

    public static List<RoleEnum> valuesFromStr(String valuesStr) {
        if (valuesStr == null) {
            return new LinkedList<>();
        }
        return values(valuesStr.split(","));
    }
}
