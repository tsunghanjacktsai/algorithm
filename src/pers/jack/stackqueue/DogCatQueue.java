package pers.jack.stackqueue;

import java.util.LinkedList;
import java.util.Queue;


public class DogCatQueue {
    public static class Pet {
        private final String type;
        public Pet(String type) { this.type = type; }
        public String getPetType() { return type; }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    /**
     * 寵物進入隊列
     */
    public static class PetEnterQueue {
        private final Pet pet;
        private final long count;

        public PetEnterQueue(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }

        public String getEnterPetType() {
            return pet.getPetType();
        }
    }

    public static class DogAndCat {
        private final Queue<PetEnterQueue> dogQ;
        private final Queue<PetEnterQueue> catQ;
        private long count;

        public DogAndCat() {
            dogQ = new LinkedList<PetEnterQueue>();
            catQ = new LinkedList<PetEnterQueue>();
            count = 0;
        }

        /**
         * 添加寵物
         * 加入寵物後，count 指針也向上疊加
         * @param pet
         */
        public void add(Pet pet) {
            if ("dog".equals(pet.getPetType())) {
                dogQ.add(new PetEnterQueue(pet, count));
                count++;
            } else if ("cat".equals(pet.getPetType())) {
                catQ.add(new PetEnterQueue(pet, count));
                count++;
            } else {
                throw new RuntimeException("Not dog or cat");
            }
        }

        /**
         * 全部彈出
         * 將貓狗的指針都返回頭部，判斷其隊列長度，較小者代表為先進入的元素，進行彈出
         * @return 彈出的寵物類型
         */
        public Pet pollAll() {
            if (!dogQ.isEmpty() && !catQ.isEmpty()) {
                if (dogQ.peek().getCount() < catQ.peek().getCount()) {
                    return dogQ.poll().getPet();
                } else {
                    return catQ.poll().getPet();
                }
            } else if (!dogQ.isEmpty()) {
                return dogQ.poll().getPet();
            } else if (!catQ.isEmpty()) {
                return catQ.poll().getPet();
            } else {
                throw new RuntimeException("err, queue is empty");
            }
        }

        /**
         * 彈出狗
         * @return 彈出的寵物類型
         */
        public Dog pollDog() {
            if (isDogQueueEmpty()) {
                throw new RuntimeException("Dog queue is empty");
            } else {
                return (Dog) dogQ.poll().getPet();
            }
        }

        /**
         * 彈出貓
         * @return 彈出的寵物類型
         */
        public Cat pollCat() {
            if(!isCatQueueEmpty()) {
                return (Cat) catQ.poll().getPet();
            } else {
                throw new RuntimeException("Cat queue is empty");
            }
        }

        /**
         * 檢查貓狗隊列是否為空
         * @return 兩隊列是否為空
         */
        public boolean isEmpty() {
            return dogQ.isEmpty() && catQ.isEmpty();
        }

        /**
         * 檢查狗隊列是否為空
         * @return 狗隊列是否為空
         */
        public boolean isDogQueueEmpty() {
            return dogQ.isEmpty();
        }

        /**
         * 檢查貓隊列是否為空
         * @return 貓隊列是否為空
         */
        public boolean isCatQueueEmpty() {
            return catQ.isEmpty();
        }
    }

    public static void main(String[] args) {
        DogAndCat test = new DogAndCat();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogQueueEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    }
}
