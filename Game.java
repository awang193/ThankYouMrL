public class Game
{
    public Game()
    {

    }


    public void cryptoChallenge()
    {
        String encrypted = "BAABBAABBBAAAAAABBABABABA BBAAAABBBABABAA ABBAABAAAB ABABB BABBAAABAA AAAAAABBBBABBBBBAAABAABAAAAABAABAAAAAAAABAABBAABAA BAABBAABBBAABAA BABBAABBBABAAABABABA AAAAAABBABAAABB BAABBABAAAABBAAAABAA BBAAAABBBABABAA ABBBBBABAABAABB ABAAAABBAB AABABABBBABAAAB BABAABAABA AABAABABABAABAABAAABBBAAA AAABBAAAAABBAAA";
        System.out.println("We've received an encrypted message from Bacon Caesar with instructions on how to proceed. It's located below");


    }

    public static void main(String[] args)
    {
        Game g = new Game();
        g.cryptoChallenge();
    }
}
