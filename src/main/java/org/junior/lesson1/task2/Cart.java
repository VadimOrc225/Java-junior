package org.junior.lesson1.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Корзина
 * @param <T> Еда
 */
public class Cart<T extends Food> {

    //region Поля

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    //endregion

    //region Конструкторы

    /**
     * Создание нового экземпляра корзины
     * @param market принадлежность к магазину
     */
    public Cart(Class<T> clazz, UMarket market)
    {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    //endregion

    /**
     * Балансировка корзины
     */
    public void cardBalancing()
    {
        AtomicBoolean proteins = new AtomicBoolean(false);
        AtomicBoolean fats = new AtomicBoolean(false);
        AtomicBoolean carbohydrates = new AtomicBoolean(false);

//        for (var food : foodstuffs)
//        {
//            if (!proteins.get() && food.getProteins())
//                proteins.set(true);
//            else
//            if (!fats.get() && food.getFats())
//                fats.set(true);
//            else
//            if (!carbohydrates.get() && food.getCarbohydrates())
//                carbohydrates.set(true);
//            if (proteins.get() && fats.get() && carbohydrates.get())
//                break;
//        }
//
//        if (proteins.get() && fats.get() && carbohydrates.get())
//        {
//            System.out.println("Корзина уже сбалансирована по БЖУ.");
//            return;
//        }
        AtomicBoolean finalFats = fats;
        AtomicBoolean finalCarbohydrates = carbohydrates;
        foodstuffs.forEach(food -> {

            if (food.getProteins()) proteins.set(true);
            if (food.getFats()) finalFats.set(true);
            if (food.getCarbohydrates()) finalCarbohydrates.set(true);
        });
        if (proteins.get()&& finalFats.get()&&finalCarbohydrates.get())
        {System.out.println("Корзина уже сбалансирована по БЖУ."); return;}


//        for (var thing : market.getThings(clazz))
//        {
//            if (!proteins.get() && thing.getProteins())
//            {
//                proteins.set(true);
//                foodstuffs.add(thing);
//            }
//            else if (!fats.get() && thing.getFats())
//            {
//                fats.set(true);
//                foodstuffs.add(thing);
//            }
//            else if (!carbohydrates && thing.getCarbohydrates())
//            {
//                carbohydrates = true;
//                foodstuffs.add(thing);
//            }
//            if (proteins.get() && fats && carbohydrates)
//                break;
//        }
//
//        if (proteins.get() && fats && carbohydrates)
//            System.out.println("Корзина сбалансирована по БЖУ.");
//        else
//            System.out.println("Невозможно сбалансировать корзину по БЖУ.");

        market.getThings(clazz).forEach(thing -> {if (!proteins.get() && thing.getProteins()){ proteins.set(true);
            foodstuffs.add(thing);} else if (!finalFats.get() && thing.getFats())  {finalFats.set(true); foodstuffs.add(thing);}
            else if (!finalCarbohydrates.get() && thing.getCarbohydrates()){finalCarbohydrates.set(true); foodstuffs.add(thing);
        }} );
        if(proteins.get() && finalFats.get() && finalCarbohydrates.get())
            System.out.println("Корзина сбалансирована по БЖУ.");
        else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");


    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    /**
     * Распечатать список продуктов в корзине
     */
    public void printFoodstuffs(){
        /*int index = 1;
        for (var food : foodstuffs)
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index++, food.getName(), food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет", food.getCarbohydrates() ? "Да" : "Нет");
         */
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                index.getAndIncrement(), food.getName(),
                food.getProteins() ? "Да" : "Нет",
                food.getFats() ? "Да" : "Нет",
                food.getCarbohydrates() ? "Да" : "Нет"));

    }

}
