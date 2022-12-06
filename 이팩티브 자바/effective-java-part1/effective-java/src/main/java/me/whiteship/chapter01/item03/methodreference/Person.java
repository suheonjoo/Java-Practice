package me.whiteship.chapter01.item03.methodreference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Person {

    LocalDate birthday;

    public Person() {

    }

    public Person(LocalDate birthday) {
        this.birthday = birthday;
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(LocalDate.of(1982, 7, 15)));
        people.add(new Person(LocalDate.of(2011, 3, 2)));
        people.add(new Person(LocalDate.of(2013, 1, 28)));

        /**
         * 익명클래스 버전
         */
        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return a.birthday.compareTo(b.birthday);
            }
        });

        /**
         * 람다 버전
         */
        people.sort((a, b) -> compareByAge(a,b));

        /**
         * 메서드 참조 버전
         * - 여기서 혹시 모를 주의점인데, compareByAge 는 인스터스 없이 바로 호출한 static 메서드임!! 만약 static 이 아니면 new Person 으로
         * 인스턴스 만들어야함 -> ㄹㅇ 당연하 소리임 ㅋ
         */
        people.sort(Person::compareByAge);

        /**
         * compareByAge()를 static 하게 만들지 않고 사용하는 방법
         * - 일단 위에 방법하고 겹치니깐 주석 처리할 것임
         */
        // Person person = new Person(null);
        // people.sort(person::compareByAge);

        /**
         * 추가로 인자를 2개 넘기지 않는 버전
         * 이것도 위에꺼하고 겹치는데 compareByAge()를 인자 하나만 받도록 하는 것임
         * 그니깐 비교 대상만 인자로 넘기는 것임  -> 솔직히 이거 내가 아는 내용임 우리 sort 나 비교할때 인자 하나만 넘기는 경우 있잖음
         * 자기 자신은 인자로 넘기지 않고.. 그거임 ㅋ
         *
         * 이거 "임의 객체의 인스턴스 메소드 레퍼런스" 인 경우에만 해당하는 것임
         */

    }

    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }

}
