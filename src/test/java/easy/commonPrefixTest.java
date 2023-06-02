package easy;

import org.junit.jupiter.api.Test;

class commonPrefixTest {

    @Test
    void longestCommonPrefix() {
        commonPrefix commonPrefix = new commonPrefix();
        String s1 = commonPrefix.longestCommonPrefix(new String[]{"c","acc","ccc"});
//        String s2 = commonPrefix.longestCommonPrefix(new String[]{"rere", "ress", "rerr"});
//        String s3 = commonPrefix.longestCommonPrefix(new String[]{"rere", "aess", "rerr"});
        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
    }
}