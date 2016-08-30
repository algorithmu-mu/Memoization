/*
動的計画法の練習
フィボナッチ数列を用いてコードを書いてみる

引数番目の数値を返すメソッド

参考
http://www.slideshare.net/iwiwi/ss-3578511
*/

class FibSample {
  public static void main(String[] args) {
    Fib f = new Fib();
    System.out.println(f.fib(6));
    System.out.println(f.fibWithMemo(6));
    System.out.println(f.fibWithMemo(7));
  }  
}

class Fib {

  boolean[] done = new boolean[100];
  int[] memo = new int[100];

  int[] dp = new int[100];

  //1. まずは普通に再帰
  int fib(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fib(n - 1) + fib(n - 2);
  }

  //メモ化
  int fibWithMemo(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;

    if (done[n]) {
      return memo[n];
    }
    System.out.println("=========");
    done[n] = true;
    return memo[n] = fibWithMemo(n - 1) + fibWithMemo(n - 2);
  }

  //ループ
  int fibWithLoop(int n) {
    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }

}
