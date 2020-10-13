package webService.java.Controller;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Utils {

    public String getSubstring(String body, String leftBorder, String rightBorder) {
        Pattern pattern = Pattern.compile("(?<=("+leftBorder+"))(.*)(?=("+rightBorder+"))");
        Matcher matcher = pattern.matcher(body);
        matcher.find();
        return matcher.group(0);
    }
}
