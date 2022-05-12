// Source: https://leetcode.com/problems/unique-email-addresses/
import java.util.*;

public class E929UniqueEmail {
    public String modifyLocal(String s) {
        String[] emailParts = s.split("\\+");

        return emailParts[0].replaceAll("\\.", "");
    }

    public String toSimplify(String s) {
        String[] email = s.split("@");
        String localName = modifyLocal(email[0]);
        String domainName = email[1];

        return localName + "@" + domainName;
    }

    public int numUniqueEmails(String[] emails) {
        String s = "";
        HashSet<String> emailSet = new HashSet<String>();

        for (String email : emails) {
            s = toSimplify(email);

            if (!emailSet.contains(s))
                emailSet.add(s);
        }

        return emailSet.size();
    }

    public static void main(String[] args) {
        E929UniqueEmail program = new E929UniqueEmail();

        System.out.println(program.numUniqueEmails(new String[] {"test.email+alex@leetcode.com",
            "test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
        System.out.println(program.numUniqueEmails(new String[] {"test+alex.email@leetcode.com",
            "test+bob.cathy.email@leetcode.com","test.email+david@lee.tcode.com",
            ".test.e.mail+david.cathy@lee.tcode.com" + "davidemail+david.cathy@lee.tcode.com"}));
    }
}
