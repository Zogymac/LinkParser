import java.net.URI;

public record StackOverflowLink(int questionId) implements Link {
    public StackOverflowLink {
        if (questionId <= 0) {
            throw new IllegalArgumentException("Question ID must be positive");
        }
    }

    public static StackOverflowLink parseStackOverflowLink(URI uri) {
        if (!uri.getHost().equals("stackoverflow.com")) {
            return null;
        }

        String path = uri.getPath();
        if (!path.startsWith("/questions/")) {
            return null;
        }

        String questionIdString = path.substring("/questions/".length());

        int slashIndex = questionIdString.indexOf('/');
        if (slashIndex >= 0) {
            questionIdString = questionIdString.substring(0, slashIndex);
        }
        try {
            int questionId = Integer.parseInt(questionIdString);
            return new StackOverflowLink(questionId);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public Object getLinkInfo() {
        return String.format("StackOverflow question: %d", questionId);
    }
}