package Repository;

public class CExceptionInMemoryRepository extends RuntimeException {
        String str;
        public CExceptionInMemoryRepository(String str) {
            this.str = str;
        }
        public String toString() {
            return ("message = " + str);
        }
    }


