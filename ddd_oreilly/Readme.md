# Domain Driven Design Boot Camp

## Usecase 1. Add Apple Pencil to Cart
```java
see below
```
## Usecase 2. Add Sony Wireless Headphone to a Cart
```java
package com.ddd_bootcamp.application;
public class Application {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Product applePencil = new Product("Apple Pencil");
        cart.add(applePencil);

        Product headphone = new Product("Sony Wireless headphone");
        cart.add(headphone);

        System.out.println("--------------------------------------------------------");
        System.out.println("Cart = " + cart);
        List<Product> products = cart.getProducts();
        System.out.println("products = " + products);
        System.out.println("--------------------------------------------------------");

    }
}
```
## Usecase3. Add 2 quantity of "Apple Pencil" to a Cart
Ask domain expert about what you call 2 product  --> Item, LineItem
```java
public class Application {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Product headphone = new Product("Sony Wireless headphone");
        Item headphoneItem = new Item(headphone,1);
        cart.add(headphoneItem);

        Product applePencil = new Product("Apple Pencil");
        Item applePencilItem = new Item(applePencil, 2);
        cart.add(applePencilItem);

        System.out.println("--------------------------------------------------------");
        System.out.println("Cart = " + cart);
        List<Item> items = cart.getItems();
        System.out.println("--------------------------------------------------------");
        System.out.println("items = " + items);
        System.out.println("--------------------------------------------------------");

    }
}
public class Cart {
    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }
}
public class Item {
    private Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
```
## What is domain layer in context of 3 tier and hexagonal?
controller(Layer), application(Service Layer), repository(Data Access Layer)
Domain Layer
Can Domain Layer serve functionality asked by business if we remove other 3 layers?
Yes --> DDD

## Naming classes
Two things are hard in software development
There are only 2 hard things in CS: cache invalidation and naming things 
     - Phil karlton(https://quotesondesign.com/phil-karlton/)
--> Ask domain expert for name
domain language in your code -> ubiquitous language
## Usecase 4. Remove already added Item "Apple Pencil"(with all quantities) from Cart
```java
public class Application {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Product headphone = new Product("Sony Wireless headphone");
        Item headphoneItem = new Item(headphone,1);
        cart.add(headphoneItem);

        Product applePencil = new Product("Apple Pencil");
        Item applePencilItem = new Item(applePencil, 2);
        cart.add(applePencilItem);

        System.out.println("-------------------------------------------------------");
        System.out.println("Cart = " + cart);
        List<Item> items = cart.getItems();
        System.out.println("items = " + items);

        Product applePencilProduct1 = new Product("Apple Pencil");
        Item applePencilItem1 = new Item(applePencilProduct1, 2);

        //cart.remove(applePencilItem1);
        cart.remove(applePencilProduct1);

        System.out.println("-------------------------------------------------------");
        System.out.println("After Removing Apple Pencil with 2 quantity");
        System.out.println("Cart = " + cart);
        System.out.println("--------------------------------------------------------");
        List<Item> items1 = cart.getItems();
        System.out.println("items = " + items1);
        System.out.println("--------------------------------------------------------");

    }
}

public class Cart {
    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }


    public void remove(Item item) {
        items.remove(item);
    }

    public void remove(Product product) {
        items.removeIf(item -> item.getProduct().equals(product));
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }

}
```
## Usecase 5 
As a business User, I would like to know which Products(Product's names) were removed from Cart.
---
Note: Please do not create business User class. You could have a method on Cart class or some other class, which returns list of Products names which were removed form Cart
```java
public class Application {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Product headphone = new Product("Sony Wireless headphone");
        Item headphoneItem = new Item(headphone,1);
        cart.add(headphoneItem);

        Product applePencil = new Product("Apple Pencil");
        Item applePencilItem = new Item(applePencil, 2);
        cart.add(applePencilItem);

        System.out.println("----------------------------------------");
        System.out.println("Cart = " + cart);
        List<Item> items = cart.getItems();
        System.out.println("items = " + items);

        Product applePencil1 = new Product("Apple Pencil");
        Item applePencilItem1 = new Item(applePencil1, 2);
        cart.remove(applePencilItem1);

        System.out.println("----------------------------------------");
        System.out.println("After Removing Apple Pencil with 2 quantity");
        System.out.println("Cart = " + cart);
        List<Item> items1 = cart.getItems();
        System.out.println("items = " + items1);

        System.out.println("----------------------------------------");
        System.out.println("Removed product names = " + cart.removedProductNames());
    }
}
// Domain Event
package com.ddd_bootcamp.domain.events;

public interface DomainEvent {
}

public class ItemAddedToCartEvent implements DomainEvent {
    private String productName;
    private int quantity;

    public ItemAddedToCartEvent(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
}

```
### Cart.java
```java
public class Cart {

    private List<DomainEvent> events = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        ItemAddedToCartEvent itemAddedEvent =
                new ItemAddedToCartEvent(item.getProductName(),
                        item.getQuantity());

        apply(itemAddedEvent);
    }

    public List<Item> getItems() {
        return items;
    }

    public void remove(Item item) {
        ItemRemovedFromCartEvent itemRemovedFromCartEvent =
                new ItemRemovedFromCartEvent(item.getProductName());

        apply(itemRemovedFromCartEvent);
    }

    private void apply(ItemAddedToCartEvent event) {
        events.add(event);
        this.items.add(new Item(new Product(event.getProductName()), event.getQuantity()));
    }

    private void apply(ItemRemovedFromCartEvent event) {
        events.add(event);
        this.items.
                remove(this.items.stream().filter(item -> item.getProductName()
                        .equals(event.getProductName())).findFirst().get());
    }

    public Set<String> removedProductNames() {
        return events.stream()
                .filter(event -> event instanceof ItemRemovedFromCartEvent)
                .map(event -> ((ItemRemovedFromCartEvent) event).getProductName())
                .collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return "Cart{" +
                "events=" + events +
                ", items=" + items +
                '}';
    }
}
```
## DDD Concept 1 Domain Event 
1. Capture something important that happened in Domain
1. Should be of importance to Domain Expert and business folks.
1. Immutable
1. Named in past tense and event has ALREADY happened
1. Event cannot be deleted
1. Event cannot be updated
1. Is CartUpdatedEvent a good Domain Event? 
- Probably not. Intent should be shown.

## Usecase 6. Entity
As a business User, I would like to differentiate between 2 Carts, even if they contain same item.
- Application.java
```java
// Application.java
Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        Product headphone1 = new Product("Sony Wireless headphone");
        Item headphoneItem1 = new Item(headphone1,1);

        Product headphone2 = new Product("Sony Wireless headphone");
        Item headphoneItem2= new Item(headphone2,1);

        cart1.add(headphoneItem1);
        cart2.add(headphoneItem2);

        System.out.println("----------------------------------------");
        System.out.print("cart1.equals(cart2) :");
        System.out.println(cart1.equals(cart2)? "true=Carts are same " : "false=Carts are different");
        System.out.println("----------------------------------------");
        System.out.print("cart1.hasSameIdentityAs(cart2) :");
        System.out.println(cart1.hasSameIdentityAs(cart2)? "true=Carts are same"  : "false=Carts are different");
        System.out.println("----------------------------------------");
```
- Cart
```java
public class Cart implements Entity<Cart> {

    private CartId cartId;
    private List<DomainEvent> events = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    public Cart() {
        cartId = CartId.generateCartId();
    }

    public void add(Item item) {
        ItemAddedToCartEvent itemAddedEvent =
                new ItemAddedToCartEvent(item.getProductName(),
                        item.getQuantity());

        apply(itemAddedEvent);
    }

    public List<Item> getItems() {
        return items;
    }

    public void remove(Item item) {
        ItemRemovedFromCartEvent itemRemovedFromCartEvent =
                new ItemRemovedFromCartEvent(item.getProductName());

        apply(itemRemovedFromCartEvent);
    }

    private void apply(ItemAddedToCartEvent event) {
        events.add(event);
        this.items.add(new Item(new Product(event.getProductName()), event.getQuantity()));
    }

    private void apply(ItemRemovedFromCartEvent event) {
        events.add(event);
        this.items.
                remove(this.items.stream().filter(item -> item.getProductName().equals(event.getProductName())).findFirst().get());
    }

    public Set<String> removedProductNames() {
        return events.stream()
                .filter(event -> event instanceof ItemRemovedFromCartEvent)
                .map(event -> ((ItemRemovedFromCartEvent) event).getProductName())
                .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;
        return cartId.equals(cart.cartId);
    }

    @Override
    public int hashCode() {
        return cartId.hashCode();
    }

    @Override
    public boolean hasSameIdentityAs(Cart other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return cartId.equals(other.cartId);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", items=" + items +
                '}';
    }
}

public interface Entity<T> {
    boolean hasSameIdentityAs(T other);
}

public class CartId {
    private UUID randomUUID;

    public static CartId generateCartId() {
        return new CartId(UUID.randomUUID());
    }

    private CartId(UUID randomUUID) {
        this.randomUUID = randomUUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartId cartId = (CartId) o;
        return randomUUID.equals(cartId.randomUUID);
    }

    @Override
    public int hashCode() {
        return randomUUID.hashCode();
    }

    @Override
    public String toString() {
        return "CartId{" +
                "randomUUID=" + randomUUID +
                '}';
    }
}
```




