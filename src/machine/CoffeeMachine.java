package machine;

import machine.coffeeTypes.Cappuccino;
import machine.coffeeTypes.Espresso;
import machine.coffeeTypes.Latte;
import machine.defaultValues.Machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Espresso espresso = new Espresso();
        Latte latte = new Latte();
        Cappuccino cappuccino = new Cappuccino();
        Machine machine = new Machine();

        boolean flag = false;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String option = sc.nextLine();
            System.out.println();
            switch (option) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    if (!sc.hasNextInt() && sc.nextLine().equals("back")) {
                            break;
                    }
                        int coffee = sc.nextInt();
                        sc.nextLine();
                        switch (coffee) {
                            case 1:
                                buy(machine, espresso.getWater(), 0, espresso.getBeans(), espresso.getPrice());
                                break;
                            case 2:
                                buy(machine, latte.getWater(), latte.getMilk(), latte.getBeans(), latte.getPrice());
                                break;
                            case 3:
                                buy(machine, cappuccino.getWater(), cappuccino.getMilk(), cappuccino.getBeans(), cappuccino.getPrice());
                                break;
                            default:
                                break;
                        }

                    flag = true;
                    break;
                case "fill":
                    fill(machine);
                    flag = true;
                    break;
                case "take":
                    take(machine);
                    flag = true;
                    break;
                case "remaining":
                    System.out.println("The coffee machine has:");
                    System.out.println(machine.getWater() + " ml of water");
                    System.out.println(machine.getMilk() + " ml of milk");
                    System.out.println(machine.getBeans() + " g of coffee beans");
                    System.out.println(machine.getCups() + " disposable cups");
                    System.out.println("$" + machine.getMoney() + " of money");
                    flag = true;
                    break;
                default:
                    break;
            }

            if(option.equals("exit")) {
                flag = false;
            } else {
            System.out.println();
            }

        } while (flag);

        sc.close();

    }


    private static void buy(Machine machine,int water, int milk, int beans, int price) {
        if (machine.getWater() >= water && machine.getMilk() >= milk && machine.getBeans() >= beans) {
            System.out.println("I have enough resources, making you a coffee!");
            machine.setWater(machine.getWater() - water);
            machine.setMilk(machine.getMilk() - milk);
            machine.setBeans(machine.getBeans() - beans);
            machine.setCups(machine.getCups() - 1);
            machine.setMoney(machine.getMoney() + price);
        } else if (machine.getWater() < water) {
            System.out.println("Sorry, not enough water!");
        } else if (machine.getMilk() < milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (machine.getBeans() < beans) {
            System.out.println("Sorry, not enough beans!");
        }

    }

    private static void fill(Machine machine) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        int water = sc.nextInt();
        sc.nextLine();
        machine.setWater(machine.getWater() + water);
        System.out.println("Write how many ml of milk you want to add:");
        int milk = sc.nextInt();
        sc.nextLine();
        machine.setMilk(machine.getMilk() + milk);
        System.out.println("Write how many grams of coffee beans you want to add:");
        int beans = sc.nextInt();
        sc.nextLine();
        machine.setBeans(machine.getBeans() + beans);
        System.out.println("Write how many disposable cups you want to add:");
        int cups = sc.nextInt();
        sc.nextLine();
        machine.setCups(machine.getCups() + cups);

    }

    private static void take(Machine machine) {
        System.out.println("I gave you $" + machine.getMoney());
        machine.setMoney(0);
    }



}

