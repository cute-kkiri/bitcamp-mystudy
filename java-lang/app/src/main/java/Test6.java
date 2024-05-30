// 실습
// - 애플리케이션 아규먼트를 다음과 같이 결과가 나오도록 모두 출력 하라.(Test5 응용)
//      $ java -classpath ... Test6 aaa bbb ccc ddd
//      'aaa'
//      'bbb'
//      'ccc'
//      'ddd'
//      $ java -classpath ... Test6 aaa       bbb ccc     ddd
//      - 공백은 자동으로 제거해서 출력.
//
//

class Test6 {
    // public static void main(int[] args) {
    public static void main(String[] args) { // main method(entry point)는 무조건 String으로 시작한다.
        // 코드를 완성하시오!

        /*
         * // 반복문 없이 만들어보기.
         * System.out.println("'" + args[0] + "'");
         * System.out.println("'" + args[1] + "'");
         * System.out.println("'" + args[2] + "'");
         * System.out.println("'" + args[3] + "'");
         */

        for (int i = 0; i < args.length; i++) {
            System.out.println("'" + args[i] + "'");
        }

    }
}
