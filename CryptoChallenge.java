public class CryptoChallenge
{
    private String enc;
    private String ans;

    // Print prompt: We've received an encrypted message from Bacon Caesar with instructions on how to proceed. It's located below or something like that
    // Encrypted: BAABBAABBBAAAAAABBABABABA BBAAAABBBABABAA ABBAABAAAB ABABB BABBAAABAA AAAAAABBBBABBBBBAAABAABAAAAABAABAAAAAAAABAABBAABAA BAABBAABBBAABAA BABBAABBBABAAABABABA AAAAAABBABAAABB BAABBABAAAABBAAAABAA BBAAAABBBABABAA ABBBBBABAABAABB ABAAAABBAB AABABABBBABAAAB BABAABAABA AABAABABABAABAABAAABBBAAA AAABBAAAAABBAAA
    // Decrypted: THANK YOU MR.L! WE APPRECIATE THE WORK AND TIME YOU PUT IN FOR US EVERY DAY!

    public CryptoChallenge(String encrypted, String answer)
    {
        enc = encrypted;
        ans = answer;
    }

    public String getEncrypted()
    {
        return enc;
    }

    public String getDecrypted()
    {
        return ans;
    }

    public boolean check(String input)
    {
        return (input == ans);
    }
}
