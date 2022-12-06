package me.whiteship.chapter02.item13;

public class HashTable implements Cloneable {

    private Entry[] buckets = new Entry[10];

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public void add(Object key, Object value) {
            this.next = new Entry(key, value, null);
        }

        /**
         * 이거 stackoverflow 에러가 발생하는 deepcopy()임
         * 재귀 ㅈㄴ 많이 함
         * @return
         */
       // public Entry deepCopy() {
       //     return new Entry(key, value, next == null ? null : next.deepCopy());
       // }

        /**
         * 이걸로 deepcopy 구현해야 함
         * 강의자가 이보다 더 deep 하게 copy 할수 있다고 함
         * entry 안에 필드(key, value, next)도 새로 만들어서 넣어줄수 있다는 것임
         * @return
         */
        public Entry deepCopy() {
            Entry result = new Entry(key, value, next);
            for (Entry p = result ; p.next != null ; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            }
            return result;
        }
    }

    /**
     * TODO hasTable -> entryH[],
     * TODO copy -> entryC[]
     * TODO entryH[0] == entryC[0]
     *
     * shallow copy 부분
     * @return
     */
//    @Override
//    public HashTable clone() {
//        HashTable result = null;
//        try {
//            result = (HashTable)super.clone();
//            result.buckets = this.buckets.clone(); // p82, shallow copy 라서 위험하다.
//            return result;
//        } catch (CloneNotSupportedException e) {
//            throw  new AssertionError();
//        }
//    }

    /**
     * TODO hasTable -> entryH[],
     * TODO copy -> entryC[]
     * TODO entryH[0] != entryC[0]
     *
     * deep copy
     * @return
     */
    @Override
    public HashTable clone() {
        HashTable result = null;
        try {
            result = (HashTable)super.clone();
            result.buckets = new Entry[this.buckets.length];

            /**
             * 배열을 직접 새로 만듬
             */
            for (int i = 0 ; i < this.buckets.length; i++) {
                if (buckets[i] != null) {
                    result.buckets[i] = this.buckets[i].deepCopy(); // p83, deep copy
                }
            }
            return result;
        } catch (CloneNotSupportedException e) {
            throw  new AssertionError();
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        Entry entry = new Entry(new Object(), new Object(), null);
        hashTable.buckets[0] = entry;
        HashTable clone = hashTable.clone();
        System.out.println(hashTable.buckets[0] == entry);
        System.out.println(hashTable.buckets[0] == clone.buckets[0]);
    }
}
