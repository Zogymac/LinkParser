public sealed interface Link permits GithubLink, StackOverflowLink {
    public abstract Object getLinkInfo();
}
