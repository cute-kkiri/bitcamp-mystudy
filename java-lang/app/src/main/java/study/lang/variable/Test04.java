package study.lang.variable;

public class Test04 {
  public static void main(String[] args) {
    // int 배열에 주소를 담을 배열
    int[][] arr = new int[3][];
    arr[0] = new int[] {11, 12};
    arr[1] = new int[] {21, 22, 23};
    arr[2] = new int[] {31, 32, 33, 34};

    System.out.println(arr.length);
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + ",");
      }
      System.out.println();
    }

    int[][] arr2 = new int[3][4];
    // int[][] arr2 = new int[3][4];이것은 이 문장과 같다.
    // int[][] arr2 = new int[3][];
    // arr2[0] = new int[4];
    // arr2[1] = new int[4];
    // arr2[2] = new int[4];
    // 두번째 4로 지정해준 배열이 가비지가 된거.
    arr2[0] = new int[] {11, 12};
    arr2[1] = new int[] {21, 22, 23};
    arr2[2] = new int[] {31, 32, 33, 34};

    System.out.println(arr2.length);
    for (int i = 0; i < arr2.length; i++) {
      for (int j = 0; j < arr2[i].length; j++) {
        System.out.print(arr2[i][j] + ",");
      }
      System.out.println();
    }
  }
}
