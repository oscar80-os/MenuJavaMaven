import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//La clase RestaurantMenu representa el menú del restaurante.
// Contiene un mapa menu que almacena los platos del restaurante.
// Cada plato se identifica por su nombre y se asocia con una instancia de la clase Dish.
public class RestaurantMenu {
    private Map<String, Dish> menu;

    public RestaurantMenu() {
        menu = new HashMap<>();
    }

    public void addDish(String nombre, String categoria, String descripcion, double precio, List<String> ingredientes, List<String> postre) {
        Dish dish = new Dish(nombre, categoria, descripcion, precio, ingredientes, postre);
        menu.put(nombre, dish);
    }
//Los métodos getMenu, filterDishesByCategory y getDishByName
// proporcionan funcionalidades para obtener información sobre los platos del menú.
// getMenu devuelve una lista con todos los platos del menú, filterDishesByCategory
// filtra los platos por categoría y getDishByName busca un plato por su nombre.
    public List<Dish> getMenu() {
        return new ArrayList<>(menu.values());
    }

    public List<Dish> filterDishesByCategory(String category) {
        List<Dish> filteredDishes = new ArrayList<>();
        for (Dish dish : menu.values()) {
            if (dish.getCategory().equalsIgnoreCase(category)) {
                filteredDishes.add(dish);
            }
        }
        return filteredDishes;
    }

    public Dish getDishByName(String name) {
        return menu.get(name);
    }
// El método printMenu imprime en la consola el menú completo del restaurante,
// mostrando el nombre y el precio de cada plato
    public void printMenu() {
        System.out.println("Menu del Restaurante:");
        for (Dish dish : menu.values()) {
            System.out.println("- " + dish.getName() + " - Precio: $" + dish.getPrice());
        }
    }
// El método main es el punto de entrada del programa.
// Aquí se crea una instancia de RestaurantMenu y se agregan platos al menú
// utilizando el método addDish.
// Luego, se muestra el menú completo, se filtran los platos por categoría
// y se busca un plato por nombre para mostrar sus detalles.
    public static void main(String[] args) {
        RestaurantMenu menu = new RestaurantMenu();

        // Agregar platos al menú
        menu.addDish("Bandeja Paisa", "Platos principales", "Deliciosa bandeja con chicharron.", 12.000,
                List.of("Frijoles", "Huevos", "Carne", "Chicharron"), List.of("Frijoles", "Huevos"));

        menu.addDish("Ensalada César", "Entrantes", "Ensalada fresca con pollo a la parrilla.", 9.99,
                List.of("Lechuga", "Pollo", "Pan tostado", "Aderezo César"), List.of());

        menu.addDish("Sancocho Costeño", "Plato principal", "Sopa de costilla platano, masorca, yuca, papa.", 5.99,
                List.of("Costilla", "Mazorca", "Platano", "Papa", "Yuca" ), List.of());

        menu.addDish("Tiramisú", "Postres", "Delicioso postre italiano con capas de bizcocho y crema de mascarpone.", 8.99,
                List.of("Bizcocho", "Café", "Crema de mascarpone", "Cacao en polvo"), List.of("Gluten", "Lácteos"));

        // Ver el menú completo
        List<Dish> fullMenu = menu.getMenu();
        System.out.println("Menú completo:");
        for (Dish dish : fullMenu) {
            System.out.println("Nombre: " + dish.getName() + " - Categoría: " + dish.getCategory() + " - Precio: $" + dish.getPrice());
        }

        // Filtrar platos por categoría
        String categoryToFilter = "Entrantes";
        List<Dish> filteredMenu = menu.filterDishesByCategory(categoryToFilter);
        System.out.println("\nPlatos en la categoría '" + categoryToFilter + "':");
        for (Dish dish : filteredMenu) {
            System.out.println("Nombre: " + dish.getName() + " - Precio: $" + dish.getPrice());
        }

        // Buscar un plato por nombre y ver detalles
        String dishName = "Sancocho Costeño";
        Dish dish = menu.getDishByName(dishName);
        if (dish != null) {
            System.out.println("\nDetalles de " + dishName + ":");
            System.out.println("Descripción: " + dish.getDescription());
            System.out.println("Ingredientes: " + dish.getIngredients());
            System.out.println("postre: " + dish.getAllergens());
        } else {
            System.out.println("\nEl plato " + dishName + " no se encuentra en el menú.");
        }

    }
}
// La clase Dish representa un plato individual y contiene los atributos correspondientes al nombre,
// categoría, descripción, precio, ingredientes y alérgenos del plato.
// Además, tiene métodos de acceso (getters) para obtener los valores de los atributos.
class Dish {
    private String nombre;
    private String categoria;
    private String descriptcion;
    private double precio;
    private List<String> ingredientes;
    private List<String> postre;

    public Dish(String nombre, String categoria, String descriptcion, double precio, List<String> ingredientes, List<String> postre) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.descriptcion = descriptcion;
        this.precio = precio;
        this.ingredientes = ingredientes;
        this.postre = postre;
    }

    public String getName() {
        return nombre;
    }

    public String getCategory() {
        return categoria;
    }

    public String getDescription() {
        return descriptcion;
    }

    public double getPrice() {
        return precio;
    }

    public List<String> getIngredients() {
        return ingredientes;
    }

    public List<String> getAllergens() {
        return postre;
    }
}
