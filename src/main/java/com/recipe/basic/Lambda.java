package com.recipe.basic;

/**
 * lambda表达式
 * 
 * @author LinHai
 * @date 2020-12-29 17:22
 */
public class Lambda {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println("第" + (i + 1) + "次启动线程：");
//            anonymousInnerClass();
            lambdaImplementRunMethod();
        }
    }

    /**
     * Runnable接口的匿名内部类实现
     */
    private static void anonymousInnerClass() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(
                        "inside Runnable using an anonymous inner class"
                );
            }
        }).start();
    }

    /**
     * 在Thread构造函数中使用lambda表达式：
     *
     * lambda表达式必须匹配接口中单一抽象方法签名的参数类型和返回类型，这被称为与方法签名兼容。
     * 因此，lambda表达式属于接口方法的实现，可以将其赋给该接口类型的引用。
     */
    private static void lambdaInRunnableConstruct() {
        new Thread(() -> System.out.println("inside Thread constructor using lambda")).start();
    }

    /**
     * 将lambda表达式赋给变量：
     *
     * Java库中不存在名为Lambda的类，lambda表达式只能被赋给函数式接口引用。
     * “将lambda表达式赋给函数式接口”与“lambda表达式属于函数式接口中单一抽象方法的实现”表示相同的含义。
     * 可以将lambda表达式视为实现接口的匿名内部类的主题。
     */
    private static void lambdaImplementRunMethod() {
        Runnable r = () -> System.out.println("lambda expression implementing the run method");
        new Thread(r).start();
    }


}
