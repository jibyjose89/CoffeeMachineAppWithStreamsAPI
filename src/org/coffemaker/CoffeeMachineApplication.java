package org.coffemaker;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class CoffeeMachineApplication {
	public static void main(String[] args) {
        List<Ingredient> ingredients = Default.getDefaultIngredients();
        Map<Ingredient, Integer> ingredientStock = ingredients.stream().
            collect(Collectors.toMap(ingredient -> ingredient, ingredient -> 10));
//        for(Ingredient key: ingredientStock.keySet()) {
//        	 System.out.println("HI JIBY:"+key+ " "+ingredientStock.get(key));
//        }
       
        List<Drink> drinks = Default.getDefaultDrinks();

        CoffeeMachine coffeeMachine = new CoffeeMachine(ingredients, ingredientStock, drinks);
        CoffeeMachineDisplay coffeeMachineDisplay = new CoffeeMachineDisplay(coffeeMachine);

        do {
        	//display ingredients, cost and stock
            coffeeMachineDisplay.displayCurrentStock();
            //display available drinks
            coffeeMachineDisplay.displayMenu();
        } while (coffeeMachineDisplay.processInputAndContinue());
    }
}





