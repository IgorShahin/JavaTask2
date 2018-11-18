import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /**
         * 2. Написать простое лямба-выражение в переменной myClosure, лямба-выражение должно выводить
         * в консоль фразу "I love Java". Вызвать это лямба-выражение. Далее написать функцию, которая будет запускать
         * заданное лямба-выражение заданное количество раз. Объявить функцию так:
         * public void repeatTask (int times, Runnable task). Функция должна запускать times раз лямба-выражение task.
         * Используйте эту функцию для печати «I love Java 10 раз.
         */
        Runnable myClosure = () -> System.out.println("I love Java");
        Main main = new Main();
        main.repeatTask(10, myClosure);


        main.loc(); //      | Задание 5 |

        // | Задание 6 |
        Shape rect = new Rectangle(25, 48);
        rect.perimetr();
        rect.area();

        Shape sqare = new Sqare(13);
        sqare.perimetr();
        sqare.area();

        Shape circle = new Circle(20);
        circle.perimetr();
        circle.area();



    }

    /**
     * Функция выводящая times количество раз функцию run() (лямда выражение)       | Задание 2 |
     *
     * @param times
     * @param task
     */
    public void repeatTask(int times, Runnable task){
        for(int i = 0; i <= times; i++){
            task.run();
        }
    }

    /**
     * 4. Создать метод, принимающий координаты и одно из направлений и возвращающий координату
     * после перехода по направлению
     *
     * @param x
     * @param y
     * @param directions
     * @return
     */
    public int walk(int x, int y , Directions directions) {
        switch (directions) {
            case UP: {
                return y + 1;
            }
            case DOWN: {
                return y - 1;
            }
            case LEFT: {
                return x - 1;
            }
            case RIGHT: {
                return x + 1;
            }
        }
        return 0;
    }

    /**
     * 5. Создать метод, осуществлящий несколько переходов от первоначальной координаты и выводящий координату
     * после каждого перехода. Для этого внутри метода следует определить переменную location
     * с начальными координатами (0,0) и  массив направлений,
     * содержащий элементы [up, up, left, down, left, down, down, right, right, down, right], и програмно
     * вычислить какие будут координаты у переменной location после выполнения этой последовательности шагов.
     * Для вычисленеия результата каждого перемещения следует использовать
     * созданный ранее метод перемещения на один шаг.
     */
    public void loc(){
        int[] location = {0 , 0};
        Directions[] directions = { Directions.UP, Directions.UP, Directions.LEFT, Directions.DOWN, Directions.LEFT,
                                    Directions.DOWN, Directions.DOWN, Directions.RIGHT, Directions.RIGHT,
                                    Directions.DOWN, Directions.RIGHT };

        for (int i = 0; i < directions.length; i++){
            if(directions[i] == Directions.UP || directions[i] == Directions.DOWN) location[1] = walk(location[0], location[1], directions[i]);
                else location[0] = walk(location[0], location[1], directions[i]);

            System.out.println(Arrays.toString(location));
        }
    }

    /**
     * 3. Создать enum Directions с возможными направлениями движения.
     */
    enum Directions{
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    /**
     * 6. Создать интерфейс Shape с двумя методами perimeter и area, выводящими периметр и площадь фигуры
     * соответственно, после чего реализовать и использовать для вывода периметра и площади следующие классы,
     * реализующие интерфейс Shape:
     *
     * Rectangle - прямоугольник с двумя свойствами: ширина и длина
     *
     * Square - квадрат с одним свойством: длина стороны
     *
     * Circle - круг с одним свойством: диаметр круга
     */
    interface Shape{
        void perimetr();
        void area();
    }

    private static class Rectangle implements Shape{

        private int width;
        private int height;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public void perimetr() {
            int p = 2*(width + height);

            System.out.println("\nПеримет прямоугольника: " + p);
        }

        @Override
        public void area() {
            int s = width*height;

            System.out.println("Площадь прямоугольника: " + s);
        }
    }

    private static class Sqare implements Shape{

        private int sideLength;

        public Sqare(int sideLength) {
            this.sideLength = sideLength;
        }

        @Override
        public void perimetr() {
            int p = 4*sideLength;

            System.out.println("\nПеримет квадрата: " + p);
        }

        @Override
        public void area() {
            int s = (int) Math.pow(sideLength, 2);

            System.out.println("Площадь квадрата: " + s);
        }
    }

    private static class Circle implements Shape{

        private int diameter;

        public Circle(int diameter) {
            this.diameter = diameter;
        }

        @Override
        public void perimetr() {
            double p =  (2*Math.PI*(diameter/2));

            System.out.println("\nПеримет круга: " + p);
        }

        @Override
        public void area() {
            double s = Math.PI*Math.pow((diameter/2), 2);

            System.out.println("Площадь круга: " + s);
        }
    }
}
