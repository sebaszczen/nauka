package seba.kursWielowatkowosci;

public class LiveLockLesson {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        Object spoon = new Object();
        Person husband = new Person(spoon);
        Person wife = new Person(spoon);
        Thread thread1 = new Thread(() -> husband.eatWith(wife), "husband");
        Thread thread2 = new Thread(() -> wife.eatWith(husband), "wife");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("done");
    }

    static class Person{
        Object spoon;
        boolean isHungry = true;

        public Person(Object spoon) {
            this.spoon = spoon;
        }

        private void eatWith(Person partner) {
            while (isHungry) {
                synchronized (spoon) {
                    if (partner.isHungry) {
                        System.out.println(Thread.currentThread().getName()+" i will wait, please eat first");
                    }
                    else {
                        System.out.println(Thread.currentThread().getName()+" i am eating");
                        isHungry = false;
                    }
                }
            }
        }
    }
}
