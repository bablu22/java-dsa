public class CountVowels {

    public static void main() {

        String str = "programming";

        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = Character.toLowerCase(str.charAt(i));

            if (ch == 'a' ||
                    ch == 'e' ||
                    ch == 'i' ||
                    ch == 'o' ||
                    ch == 'u') {

                count++;
            }

        }

        System.out.println(count);
    }
}
