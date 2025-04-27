class RegnUtFlettinger {
    public static int regnFlett(int ant) {
        int antFlett = 0;
        while (ant > 1) {
            int flettet = ant / 2;
            ant -= flettet;
            antFlett += flettet;
        }
        return antFlett;
    }
    public static void main(String[] args) {
        System.out.println(regnFlett(100));
        System.out.println(regnFlett(2));
        System.out.println(regnFlett(3));
        System.out.println(regnFlett(86));
        System.out.println(regnFlett(378));
    }
}