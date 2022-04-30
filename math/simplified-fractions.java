class Solution {
    static class Fraction {
        int n;
        int d;

        public Fraction(int n, int d) {
            this.n = n;
            this.d = d;
            reduce();
        }

        public void reduce() {
            int gcd = gcd(n, d);
            n = n/gcd;
            d = d/gcd;
        }

        public static int gcd(int n, int d) {
            if (d == 0) {
                 return n;
            }
            return gcd(d, n % d);
        }

        @Override
        public String toString(){
            return n+"/"+d;
        }
    }
    
    public List<String> simplifiedFractions(int n) {
        List<String> l = new ArrayList<>();
        if (n < 2) {
            return l;
        }
        Set<String> s = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                s.add((new Fraction(j,i)).toString());
            }
        }
        l.addAll(s);
        return l;
    }
}
