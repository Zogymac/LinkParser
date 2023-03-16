import java.net.URI;

public class LinkParser {
    public static Link parseLink(String urlString) {
        URI uri = URI.create(urlString);


        GithubLink githubLink = GithubLink.parseGithubLink(uri);
        if (githubLink != null) {
            return githubLink;
        }

        StackOverflowLink stackOverflowLink = StackOverflowLink.parseStackOverflowLink(uri);
        if (stackOverflowLink != null) {
            return stackOverflowLink;
        }

        return null;
    }
}